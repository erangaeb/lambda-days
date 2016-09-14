package com.pagero.labdadays.futures

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * Created by ranjeewe on 9/14/16.
  */
object ParallelVsSequential extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  runTest

  private def runTest: Unit = {

    val parallel1 = parallelMethod1
    val parallel2 = parallelMethod2
    val parallel3 = parallelMethod3

    //Can run parallelly. But wait till each of them is finished
    val parallelButWaitForAll = for {
      _ <- parallel1
      _ <- parallel2
      _ <- parallel3
    } yield println("These will run parallelly but will wait at the end for every future to get completed.. Parallel ")

    //The following is good only if sequencialMethod2 depends on sequencialMethod1's output
    val sequencialInAll = for {
      _ <- sequencialMethod1
      _ <- sequencialMethod2
      _ <- sequencialMethod3
    } yield println("These will run sequentialy waiting at till the final one is completed.. Sequential ")


    //Await is just for testing to keep the main running until others get finished
    Await.result(sequencialInAll, Duration.Inf)
    Await.result(parallelButWaitForAll, Duration.Inf)
  }


  private def sequencialMethod1 = {
    Future {
      Thread.sleep(10000)
      println(" = sequencialMethod1")
    }
  }

  private def sequencialMethod2 = {
    Future {
      Thread.sleep(1)
      println(" = sequencialMethod2")
    }
  }

  private def sequencialMethod3 = {
    Future {
      Thread.sleep(10)
      println(" = sequencialMethod3")
    }
  }

  private def parallelMethod1 = {
    Future {
      Thread.sleep(10000)
      println(" = parallelMethod1")
    }
  }

  private def parallelMethod2 = {
    Future {
      Thread.sleep(1)
      println(" = parallelMethod2")
    }
  }

  private def parallelMethod3 = {
    Future {
      Thread.sleep(10)
      println(" = parallelMethod3")
    }
  }
}