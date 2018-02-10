package com.codescv.example.variance

import scala.collection.mutable

/**
  * Created by czzha on 12/30/16.
  */
object FuncUtils {
  implicit def mkTupleList[K, V](s: Seq[Tuple2[K, V]]): TupleSeq[K, V] = {
    new TupleSeq[K, V](s)
  }

  implicit def mkTupleList[K, V](s: Array[Tuple2[K, V]]): TupleSeq[K, V] = {
    new TupleSeq[K, V](s)
  }

  def sum[T: Numeric](a: Tuple2[T, T], b:Tuple2[T, T]): Tuple2[T, T] = {
    val num = implicitly[Numeric[T]]
    (num.plus(a._1, b._1), num.plus(a._2, b._2))
  }
}

class TupleSeq[K, V](vals : Seq[Tuple2[K, V]]) {
  def reduceByKey(accumulator: (V, V) => V): Seq[Tuple2[K, V]] = {
    val result: mutable.Map[K, V] = mutable.Map()

    for ((k, v) <- vals) {
      var value = v
      if (result.contains(k))
        value = accumulator(result(k), v)
      result.put(k, value)
    }

    result.toSeq
  }

  def reduceByKey2(accumulator: (V, V) => V): Seq[Tuple2[K, V]] = {
    vals.groupBy(_._1).map {
      case (k, v) =>
        (k, v.map(_._2).reduce(accumulator))
    }.toSeq
  }
}

