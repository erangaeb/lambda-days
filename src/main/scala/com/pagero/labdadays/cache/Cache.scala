package com.pagero.labdadays.cache

object Cache {
  def fromMap[K, V]: SchematronCache[K, V] = SchematronCache.empty[K, V]
}

trait Cache[K, V] {
  def get(k: K): Option[V]

  def put(kv: (K, V)): (Set[K], Cache[K, V])

  def invalidate(): (Set[K], Cache[K, V])

  def iterator: Iterator[(K, V)]
}
