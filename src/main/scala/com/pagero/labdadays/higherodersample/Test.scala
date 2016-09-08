package com.pagero.labdadays.higherodersample

/**
  * Created by ranjeewe on 9/8/16.
  */
object Test extends App with TransactionHandler {

  val handlingTransactionSample = HandlingTransactionSample
  handlingTransactionSample.deleteIssuerConnection(new TransactionCriteria(1))
  handlingTransactionSample.deleteRecipientConnection(new TransactionCriteria(1))
  handlingTransactionSample.deletePayloadAndSaveLog(new TransactionCriteria(1))


  val handlingTransactionBitImprovedSample = HandlingTransactionBitImprovedSample
  withTransaction(handlingTransactionBitImprovedSample.deleteIssuerConnection, new TransactionCriteria(1))
  withTransaction(handlingTransactionBitImprovedSample.deleteRecipientConnection, new TransactionCriteria(1))
  withTransaction(handlingTransactionBitImprovedSample.deletePayloadAndSaveLog, new TransactionCriteria(1))
}