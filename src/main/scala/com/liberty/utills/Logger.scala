package com.liberty.utills

/**
 * User: Dimitr
 * Date: 16.03.14
 * Time: 10:50
 */
object Logger {
  def log(msg: String) {
    println(msg)
  }

  def log(msg: String, zoneNumber: Int) {
    println(s"[Zone # $zoneNumber] $msg => ${System.currentTimeMillis()}")
  }

  def logWithTime(msg: String)(implicit zoneNumber: Int) {
    println(s"[Zone # $zoneNumber] $msg => ${System.currentTimeMillis()}")
  }
}
