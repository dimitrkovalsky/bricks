package com.liberty.processing

/**
 * User: Dimitr
 * Date: 16.03.14
 * Time: 11:49
 */
case class PrepareCeramicMixture(zone: Int) extends Operation("Prepare ceramic mixture", zone) {
  private val PREPARATION_TIME = 1000

  override def execute() = {
    Thread.sleep(PREPARATION_TIME)
    true
  }
}
