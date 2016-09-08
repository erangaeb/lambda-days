package com.pagero.labdadays.higherodersample

/**
  * Created by ranjeewe on 9/8/16.
  */
object Test extends App with TransactionHandler {

  val handlingTransactionSample = HandlingTransactionSample
  handlingTransactionSample.deleteIssuerConnection
  handlingTransactionSample.deleteRecipientConnection
  handlingTransactionSample.deletePayloadAndSaveLog


  val handlingTransactionBitImprovedSample = HandlingTransactionBitImprovedSample
  withTransaction(handlingTransactionBitImprovedSample.deleteIssuerConnection, new TransactionCriteria(1))
  withTransaction(handlingTransactionBitImprovedSample.deleteRecipientConnection, new TransactionCriteria(1))
  withTransaction(handlingTransactionBitImprovedSample.deletePayloadAndSaveLog, new TransactionCriteria(1))
}