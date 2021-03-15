name := "tasks"

version := "0.1"

scalaVersion := "2.12.12"

val scalaSuffixVersion = "2.12"

val testDependencies = Seq(
  "org.scalatest" % s"scalatest_$scalaSuffixVersion" % "3.0.3"
)

libraryDependencies ++= testDependencies.map(_ % "test")