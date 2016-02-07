[![Build Status](https://travis-ci.org/kypeli/sversion.svg?branch=master)](https://travis-ci.org/kypeli/sversion)

# sversion is a Scala library that lets you easily compare version strings
Inspired by PHP's [version_compare](http://php.net/manual/en/function.version-compare.php) this library lets you to compare two version strings with regular comparison operators in Scala.  

  * The version string is expected to be separated by `.`, `_` or `-` characters. 
  * The version string can contain additional characters such as `RC`. 
  * Different version lengths are taken into account.
  * Succeeding `0`s are omitted. 
  * All comparison operators are supported (`>`, `>=`, `<`, `<=` and `==`) 

## Installation
Coming soon to Sonatype's Nexus repository. Sorry about that. Until then, you have to clone this repo and include the source code directly to your project.

## Examples
Normal version strings.

```scala
import com.github.sversion.Version

Version("1.2") > Version("1.1")  // true

Version("1.2.1") > Version("1.1.2")  // true

Version("1.1.1") == Version("1.1.1")  // true

```
Version strings of different length.
```scala
import com.github.sversion.Version

Version("1.1.1") > Version("1.1")  // true

Version("1.1.0") == Version("1.1")  // true
```
Version strings with additional characters.
```scala
import com.github.sversion.Version

Version("1.1-RC2") > Version("1.1-RC1")  // true

Version("1.1-RC1") > Version("1.1")  // true
```

## Implicit conversions
Implicit conversions are also possible directly from Strings.
```scala
import com.github.sversion.Version
import com.github.sversion.utils.Implicit
import Implicit._

val v1: Version = "1.2.0"
val v2: Version = "1.1.0"

v1 > v2  // true
```

## Thank you
This code is being sponsored by [Futurice](https://www.futurice.com) [Spice Program](http://spiceprogram.org/)

## License

[Apache 2.0](https://raw.githubusercontent.com/kypeli/sversion/master/LICENSE)
