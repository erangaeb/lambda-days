package com.pagero.labdadays.higherodersample

/**
  * Created by ranjeewe on 9/8/16.
  */

package object Database {
  val db = new DB
}

class DB {
  //def withTransaction[T](f: Session => T): T = f(new Session)
  //def withTransaction[T](f: Session => T): T = withSession { s => s.withTransaction(f(s)) }

  def withTransaction[T](f: DatabaseSession => T): T = {
    withSession(f)
    //withSession(s => s.withTransaction(f(s))) // Goes inside the session
  }

  /*
  def withTransaction[T](f: Session => T): T {
   f(new Session)
   }
  */

  def withSession[T](f: DatabaseSession => T): T = {
    val realCreatedSession = null //createSession() //creating the session
    var ok = false
    try {
      val res = f(realCreatedSession)
      ok = true
      res
    } finally {
      if (ok) {
        //clossing the session realCreatedSession.close()
      }
      else {
        // f(s) threw an exception, so don't replace it with an Exception from close()
        try {
          //closing the session realCreatedSession.close() s.close()
        } catch {
          case _: Throwable =>
        }
      }
    }
  }
}

class DatabaseSession {
  def withTransaction[T](f: => T): T = {
    f
  }
}

case class TransactionCriteria(id: Long)
