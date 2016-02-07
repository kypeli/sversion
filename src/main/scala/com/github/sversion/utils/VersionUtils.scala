package com.github.sversion.utils

object VersionUtils {
  def compare(v1: List[Int], v2: List[Int])(resultThisLonger: Boolean)(fn: (Int, Int) => Boolean): Boolean = {
    v1 match {
      case v :: tail if v2.nonEmpty => {
        v -> v2.head match {
          case (t1, t2) if t1 == t2 => compare(tail, v2.tail)(resultThisLonger)(fn)
          case (t1, t2) => fn(t1, t2)
        }
      }
      case v :: tail if v2.isEmpty => resultThisLonger
      case v :: Nil if v2.nonEmpty => fn(v, v2.head)
      case v :: Nil if v2.isEmpty => resultThisLonger
      case Nil => !resultThisLonger
      case _ => false
    }
  }
}
