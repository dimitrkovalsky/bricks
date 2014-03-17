package com.liberty.processing

import com.liberty.common.{TemperatureComponent, TemperatureBounds, Zone, ZoneStatus}
import com.liberty.common.Zone._
import com.liberty.controllers.TPController

/**
 * User: Dimitr
 * Date: 16.03.14
 * Time: 13:03
 */
object ParametersController {

  var zones: Map[Int, ZoneStatus] = Map.empty
  var temperatures: Map[Int, TemperatureComponent] = Map.empty
  var controller: TPController = _

  def initialize(list: List[Zone], tp: TPController) {
    controller = tp
    list.foreach(z => zones += z.zoneId -> ZoneStatus(z.zoneId))

    list.foreach(zone => {
      zone.operation match {
        case op: DryingBricks =>
          temperatures += zone.zoneId -> TemperatureComponent(op.bounds.average(), op.bounds)
        case _ =>
      }
    })
    println(temperatures)
  }

  def checkTemperature(zoneId: Int): Int = {
    temperatures.get(zoneId).map {
      component => component.simulateTemperatureChange()
        component.current
    }.getOrElse(0)
  }

  def setZoneStatus(zoneId: Int, status: Zone.Value) {
    zones.get(zoneId).foreach {
      st => zones += zoneId -> ZoneStatus(zoneId, status)
    }
  }

  def increaseTemperature(zoneId: Int, delta: Int) {
    temperatures.get(zoneId).foreach(c => c.current = c.current + delta)
  }

  def decreaseTemperature(zoneId: Int, delta: Int) {
    temperatures.get(zoneId).foreach(c => c.current = c.current - delta)
  }

  def getCurrentTemperature(zoneId: Int) = {
    temperatures.get(zoneId).map {
      component => component.current
    }.getOrElse(0)
  }
}

