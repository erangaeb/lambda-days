/*package com.pagero.labdadays.transactionalblocks

class TransactionHandler {

  def withTransaction[T](f: (TransactionCriteria, Session) => T, criteria: TransactionCriteria) = {
    db withTransaction {
      implicit session => {
        f(criteria, session)
      }
    }
  }
}
object Database{
  def withTransaction: Unit ={

  }
}*/
