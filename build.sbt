name := "sversion"

organization := "com.github.kypeli"

version := "1.1"

scalaVersion := "2.12.1"

crossScalaVersions := Seq("2.11.7", "2.12.1")

publishMavenStyle := true

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.8.6" % "test",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "ch.qos.logback" % "logback-classic" % "1.1.2"
)
    
