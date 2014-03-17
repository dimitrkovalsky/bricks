package com.liberty.processing

/**
 * User: Dimitr
 * Date: 16.03.14
 * Time: 11:49
 */
case class FormingBricks(zone: Int) extends Operation("Forming bricks", zone) {
  private val FORMING_TIME = 700

  override def execute() = {
    Thread.sleep(FORMING_TIME)
    true
  }
}
