package com.pagero.labdadays.config

import com.typesafe.config.ConfigFactory

import scala.util.Try

/**
 * Load configurations define in application.conf from here
 *
 * @author eranga herath(erangaeb@gmail.com)
 */
trait Configuration {
  // config object
  val config = ConfigFactory.load()

  // schematron root
  lazy val schematronRoot = Try(config.getString("schemator.root")).getOrElse("")
}
