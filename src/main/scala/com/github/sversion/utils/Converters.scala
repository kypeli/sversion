package com.github.sversion.utils

object Converters {

  implicit class RichOptionConvert(val s: String) extends AnyVal {
    def toOptInt() =
      try {
        Some(s.toInt)
      } catch {
        case e: NumberFormatException => None
      }
  }

}