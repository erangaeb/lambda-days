package com.pagero.labdadays.errohandling

import scala.util.Try

/**
  * Created by ranjeewe on 9/12/16.
  */
object MissingDataErrorCode extends Enumeration {
  type LPCErrorCode = Value
  val
  MISSING_COMPANY_ID,
  MISSING_SUPPLIER_NAME = Value
}

class ExampleException(id: Long) extends Exception {
}

case class MissingDataException(id: Long, code: MissingDataErrorCode.Value, message: String) extends ExampleException(id)

case class CommunicationAPIException(id: Long, message: String) extends ExampleException(id)

object ThirdPartyCaller extends App {

  callingThirdParty(SearchRequest(1, None, None))
  callingThirdParty(SearchRequest(1, Some(10), None))
  callingThirdParty(SearchRequest(1, Some(15), Some("Test")))


  /**
    * Usage of recover in Try
    *
    * @param searchRequest searchRequest
    */
  def callingThirdParty(searchRequest: SearchRequest) {
    Try[Long] {
      val id = searchRequest.companyId.
        getOrElse(throw MissingDataException(1, MissingDataErrorCode.MISSING_COMPANY_ID, "Missing company id"))
      val name = searchRequest.supplierName.
        getOrElse(throw MissingDataException(2, MissingDataErrorCode.MISSING_SUPPLIER_NAME, "Missing supplier name"))

      requestToThirdParty(id, name)
    } recover {
      case exception: ExampleException =>
        handleException(exception)
      case _ =>
        println("No need to handle these exceptions")
    }

  }

  def handleException(exception: ExampleException): Unit = {

    exception match {
      case MissingDataException(id, code, message) =>
        println(s"$exception ,id=$id code=$code, message=$message")
      case CommunicationAPIException(id, message) =>
        println(exception)
    }
  }

  def requestToThirdParty(id: Long, name: String): Long = {
    throw new CommunicationAPIException(id, "exception")
  }
}

case class SearchRequest(id: Long, companyId: Option[Long], supplierName: Option[String])