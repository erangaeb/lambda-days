package com.pagero.labdadays.comp

import java.io.{File, FileFilter}

import com.pagero.labdadays.config.Configuration

object DirComp extends Configuration {
  def rootIter(dirs: List[File], dirIter: File => Unit): Unit = {
    dirs match {
      case Nil =>
        println("EMPTY")
      case f :: tail =>
        println(f.getPath)

        dirIter(f)
        rootIter(tail, dirIter)
    }
  }

  val dirFilter = new FileFilter {
    override def accept(pathname: File): Boolean = pathname.isDirectory
  }

  def dirIter(dir: File): Unit = {
    dir.listFiles(dirFilter).toList match {
      case Nil =>
        println("EMPTY_DIR")
      case f :: tail =>
        println(f)
        dirIter(f)
    }
  }

  val root = new File(schematronRoot)
  rootIter(root.listFiles(dirFilter).toList, dirIter)
}
