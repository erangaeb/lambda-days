package com.pagero.labdadays.higherodersample


/**
  * Created by ranjeewe on 9/8/16.
  */
object HandlingTransactionBitImprovedSample {

  def deleteIssuerConnection(criteria: TransactionCriteria, session: DatabaseSession): Unit = {
    //deleteIssuer
    //deleteConnection
  }

  def deleteRecipientConnection(criteria: TransactionCriteria, session: DatabaseSession): Unit = {
    //deleteRecipient
    //deleteConnection
  }

  def deletePayloadAndSaveLog(criteria: TransactionCriteria, session: DatabaseSession): Unit = {
    //deletePayload
    //saveLoad
  }
}