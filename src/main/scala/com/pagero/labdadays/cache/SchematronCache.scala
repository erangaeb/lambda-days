package com.pagero.labdadays.cache

object SchematronCache {
  def empty[K, V]: SchematronCache[K, V] = SchematronCache[K, V](Map.empty[K, V])

  def apply[K, V](m: Map[K, V]): SchematronCache[K, V] = new SchematronCache[K, V](m)
}

class SchematronCache[K, V](m: Map[K, V]) extends Cache[K, V] {

  override def get(k: K): Option[V] = {
    m.get(k)
  }

  override def put(kv: (K, V)): (Set[K], SchematronCache[K, V]) = {
    (Set.empty[K], new SchematronCache(m + kv))
  }

  override def invalidate() = {
    (Set.empty[K], new SchematronCache(Map.empty[K, V]))
  }

  override def iterator: Iterator[(K, V)] = m.iterator

  override def toString: String = m.toString()

}

