package com.pagero.labdadays.higherodersample

trait TransactionHandler {

  import Database._

  def withTransaction[T](f: (TransactionCriteria, DatabaseSession) => T, criteria: TransactionCriteria) = {
    db withTransaction {
      implicit session => {
        f(criteria, session)
      }
    }
  }
}