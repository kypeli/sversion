package com.github.sversion.utils

import com.github.sversion.Version

object Implicit {
  implicit def convert(version: String): Version = new Version(version)
}
