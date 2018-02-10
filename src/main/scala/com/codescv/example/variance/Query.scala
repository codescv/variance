package com.codescv.example.variance

import play.api.libs.json.{Json, Writes}
import play.api.libs.json._

/**
  * Created by czzha on 1/1/17.
  */
object Query {
  implicit val locationWrites = new Writes[Result] {
    def writes(r: Result) = Json.obj(
      "status" -> r.status,
      "data" -> r.data
    )
  }

  def query = {
    val s = List("a","b","c")
    val data = Map("1"->"aaa")
    Json.toJson(Result(200, data)).toString()
//    locationWrites.writes(Result(200, data))
  }
}

case class Result(status: Int, data: Map[String, String])