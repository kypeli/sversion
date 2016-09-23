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
package com.github.sversion.utils

object VersionUtils {
  def compare(v1: List[Int], v2: List[Int])(fn: (Int, Int) => Boolean): Boolean = {
    v1 match {
      case v :: tail if v2.nonEmpty => {
        v -> v2.head match {
          case (t1, t2) if t1 == t2 => compare(tail, v2.tail)(fn)
          case (t1, t2) => fn(t1, t2)
        }
      }
      case v :: tail if v2.isEmpty => fn(v, 0)
      case v :: Nil if v2.nonEmpty => fn(v, v2.head)
      case v :: Nil if v2.isEmpty => fn(v, 0)
      case Nil if v2.nonEmpty => fn(0, v2.head)
      case _ => false
    }
  }
}
