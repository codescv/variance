import play.api.libs.json._

case class Result(status: Int, data: Map[String, String])

implicit val resultFormat = Json.format[Result]

val r = Result(200, Map("a"->"b"))

val rjs = Json.toJson(r)

rjs.as[Result]


trait Addable[T] {
  def zero: T
  def append(a: T, b: T): T
}
//yup, it's our friend the monoid, with a different name!

implicit object IntIsAddable extends Addable[Int] {
  def zero = 0
  def append(a: Int, b: Int) = a + b
}

implicit object StringIsAddable extends Addable[String] {
  def zero = ""
  def append(a: String, b: String) = a + b
}

def sum[T](xs: List[T])(implicit addable: Addable[T]) =
  xs.foldLeft(addable.zero)(addable.append)

//or the same thing, using context bounds:

def sum[T](a: (T, T), b: (T, T))(implicit addable: Addable[T]) = {
  addable.append(a._1, b._1)
}

sum(List("a", "b"))

case class Filter(fc: Option[Set[String]], pl: Option[Set[String]])

val x = Filter(None, Some(Set("a", "b")))

def check(fc: String, pl: String, filter: Filter): Boolean = {
  filter.fc.forall(_.contains(fc)) && filter.pl.forall(_.contains(pl))
}

implicit val filterFormat = Json.format[Filter]

val fstring = Json.toJson(x).toString()

val xback = Json.parse(fstring).as[Filter]

check("a", "b", x)

for {
  x <- Set("a", "b", "c")
  if x != "c"
} yield x

Array(1,2,3)