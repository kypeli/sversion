name := "sversion"

organization := "com.github.kypeli"

version := "1.1"

scalaVersion := "2.11.7"

publishMavenStyle := true

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.7" % "test",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "ch.qos.logback" % "logback-classic" % "1.1.2"
)
    
