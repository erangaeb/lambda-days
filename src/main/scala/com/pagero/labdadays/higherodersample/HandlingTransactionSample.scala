package com.pagero.labdadays.higherodersample

object HandlingTransactionSample {

  import Database._

  def deleteIssuerConnection: Unit = {
    db withTransaction {
      implicit session => {
        //deleteIssuer
        //deleteConnection
      }
    }
  }

  def deleteRecipientConnection: Unit = {
    db withTransaction {
      implicit session => {
        //deleteRecipient
        //deleteConnection
      }
    }
  }

  def deletePayloadAndSaveLog: Unit = {
    db withTransaction {
      implicit session => {
        //deletePayload
        //saveLoad
      }
    }
  }
}