/**
  * Copyright 2016 Johan Paul (johan.paul@gmail.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *   http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  *
  **/
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
    .replaceAll(".0$", "")
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
