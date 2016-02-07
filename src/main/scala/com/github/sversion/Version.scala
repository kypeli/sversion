package com.github.sversion

import com.typesafe.scalalogging.LazyLogging

import com.github.sversion.utils.{VersionUtils, Converters}
import Converters._

object Version {
  def apply(version: String) = new Version(version)
}

class Version(version: String) extends LazyLogging {
  val tokens = version
    .replaceAll("[^0-9\\.\\-_]", "")
    .split("[\\.\\-_]")
    .flatMap(v => v.toOptInt())
    .toList

  def >(that: Version): Boolean = VersionUtils.compare(this.tokens, that.tokens)(resultThisLonger = true)((a: Int, b: Int) => a > b)
  def >=(that: Version): Boolean = this == that || this > that
  def <(that: Version): Boolean = VersionUtils.compare(this.tokens, that.tokens)(resultThisLonger = false)((a: Int, b: Int) => a < b)
  def <=(that: Version): Boolean = this == that || this < that
  def ==(that: Version): Boolean = this.equals(that)

  override def equals(that: Any): Boolean = {
    that match {
      case v: Version => this.tokens.length == v.tokens.length && this.tokens.zip(v.tokens).forall(t => t._1 == t._2)
      case _ => false
    }
  }
}
