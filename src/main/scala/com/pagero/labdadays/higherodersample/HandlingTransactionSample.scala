package com.pagero.labdadays.higherodersample

object HandlingTransactionSample {

  import Database._

  def deleteIssuerConnection(criteria: TransactionCriteria): Unit = {
    db withTransaction {
      implicit session => {
        //deleteIssuer
        //deleteConnection
      }
    }
  }

  def deleteRecipientConnection(criteria: TransactionCriteria): Unit = {
    db withTransaction {
      implicit session => {
        //deleteRecipient
        //deleteConnection
      }
    }
  }

  def deletePayloadAndSaveLog(criteria: TransactionCriteria): Unit = {
    db withTransaction {
      implicit session => {
        //deletePayload
        //saveLoad
      }
    }
  }
}