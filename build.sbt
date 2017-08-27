name := "sparkProject"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.5",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "info.cukes" % "cucumber-core" % "1.2.5" % "test",
  "info.cukes" %% "cucumber-scala" % "1.2.5" % "test",
  "info.cukes" % "cucumber-jvm" % "1.2.5" % "test",
  "info.cukes" % "cucumber-junit" % "1.2.5" % "test",
  "junit" % "junit" % "4.12"
)

val framework = new TestFramework("com.waioeka.sbt.runner.CucumberFramework")
testFrameworks += framework

testOptions in Test += Tests.Argument(framework,"--monochrome")
testOptions in Test += Tests.Argument(framework,"--glue","")
testOptions in Test += Tests.Argument(framework,"--plugin","pretty")
testOptions in Test += Tests.Argument(framework,"--plugin","html:/tmp/html")
testOptions in Test += Tests.Argument(framework,"--plugin","json:/tmp/json")

unmanagedClasspath in Test += baseDirectory.value / "src/test/com.app.playground/features"

resolvers += "Templemore Repository" at "https://templemore.co.uk/repo/"

