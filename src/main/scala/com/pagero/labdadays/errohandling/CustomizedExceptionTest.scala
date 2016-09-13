package com.pagero.labdadays.errohandling

import scala.util.{Failure, Success, Try}

/**
  * Created by ranjeewe on 9/12/16.
  */
object SampleErrorCode extends Enumeration {
  type LPCErrorCode = Value
  val
  CALCULATION_ERROR,
  COMMUNICATION_ERROR,
  DATABASE_SAVING_ERROR = Value
}

case class SampleException(code: SampleErrorCode.Value, message: String) extends Exception

object CustomizedExceptionTest extends App {

  val processResults = processData
  println("processResults = " + processResults)


  def processData: Try[Long] = {
    Try {
      callThirdParty()
      saveDataInDB()
      mathCalculation()
    } match {
      case success: Success[Long] =>
        success
      case Failure(exception: MathException) =>
        Failure(SampleException(SampleErrorCode.CALCULATION_ERROR, exception.getMessage))
      case Failure(exception: CommunicationException) =>
        Failure(SampleException(SampleErrorCode.COMMUNICATION_ERROR, exception.getMessage))
      case Failure(exception: DBException) =>
        Failure(SampleException(SampleErrorCode.DATABASE_SAVING_ERROR, exception.getMessage))
    }
  }

  private def callThirdParty() {
    //the code it self doesn't throw, but just for display purposes throwing some exception
    throw new CommunicationException()
  }

  private def saveDataInDB() {
    //the code it self doesn't throw, but just for display purposes throwing some exception
    throw new DBException()
  }

  private def mathCalculation(): Long = {
    //the code it self doesn't throw, but just for display purposes throwing some exception
    throw new MathException()
  }

}


//these are not our exceptions. Not defined by us
class MathException extends Exception

//these are not our exceptions. Not defined by us
class DBException extends Exception

//these are not our exceptions. Not defined by us
class CommunicationException extends Exception