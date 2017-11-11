# Midget-SparkApps

After downloadig any app from here please follow the following guide to compile it.
Deault `build.sbt` is having following configs

    name := "Simple Project"
    version := "1.0"
    scalaVersion := "2.11.8"
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"


# Your directory layout should look like this

    $ find .
    .
    ./build.sbt
    ./src
    ./src/main
    ./src/main/scala
    ./src/main/scala/SimpleApp.scala

# Package a jar containing your application
    
    $ sbt package
    ...
    [info] Packaging {..}/{..}/target/scala-2.11/simple-project_2.11-1.0.jar

# Use spark-submit to run your application
(replace the `YOUR_SPARK_HOME` with your Spark home path)

    $ YOUR_SPARK_HOME/bin/spark-submit \
      --class "SimpleApp" \
      --master local[4] \
      target/scala-2.11/simple-project_2.11-1.0.jar
      
© [Omal Perera](https://github.com/OmalPerera)
