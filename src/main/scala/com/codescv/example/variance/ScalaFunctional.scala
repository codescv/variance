package com.codescv.example.variance

import scala.collection.mutable
import FuncUtils._

import scala.language.implicitConversions
import Numeric._
import scala.runtime.RichInt

class ScalaFunctional {
  def f() = {
    val x = Array("a", "b", "c")
    x.toStream.toParArray.map(_.length).foreach {
      a =>
        println(a)
        println(Thread.currentThread())
    }

    this match {
      case it => it
    }

    val a1 = Array("a", "b", "c")
    val a2 = Array(1,2,3)
    val m = a1.zip(a2).toMap
    println(m)


    println(Array(1,2,3).map(sum(1)).mkString("\t"))

    println(Runtime.getRuntime.availableProcessors())

    Map("a"->1)

  }



  def sum(x: Int)(y: Int): Int = {
    x + y
  }




}



object ScalaFunctional {

  def main(args: Array[String]): Unit = {
    val x: Int = 3.5
  }

  implicit def double2int(i: Double): Int = {
    return i.toInt
  }

  implicit class IntObj(x: Int) extends Ordered[Int] {
    override def compare(that: Int) = if (x > that) 1 else -1
  }

  def ff[T <: Ordered[T]](x: T) = x < x

}


