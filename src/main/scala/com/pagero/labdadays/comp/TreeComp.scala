package com.pagero.labdadays.comp

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Node[A](nodes: Seq[Tree[A]]) extends Tree[A]

object TreeComp {
  val tree: Tree[String] = Node(
    Seq(
      Node(
        Seq(Node(Seq(Leaf("A"), Leaf("B"))))
      ),
      Node(
        Seq(Leaf("C"))
      ),
      Node(
        Seq(Node(Seq(Leaf("D"), Leaf("E"))))
      )
    )
  )

  def traverse(tree: Tree[String]): Unit = {
    tree match {
      case Leaf(l) =>
        println(l)
      case Node(n) =>
        for (i <- n) traverse(i)
    }
  }

}