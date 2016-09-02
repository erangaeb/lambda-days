name := "lambda-days"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {

  val akkaVersion       = "2.3.9"
  val cassandraVersion  = "3.0.0"

  Seq(
    "com.typesafe.akka"       %% "akka-actor"               % akkaVersion,
    "com.typesafe.akka"       %% "akka-slf4j"               % akkaVersion,
    "com.datastax.cassandra"  % "cassandra-driver-core"     % cassandraVersion,
    "org.slf4j"               % "slf4j-api"                 % "1.7.5",
    "ch.qos.logback"          % "logback-classic"           % "1.0.9",
    "org.mongodb"             %% "casbah"                   % "3.1.1",
    "org.scalatest"           % "scalatest_2.11"            % "2.2.1"               % "test"
  )
}

resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)
