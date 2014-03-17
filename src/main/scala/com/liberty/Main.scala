package com.liberty

import com.liberty.common.{TemperatureBounds, Zone}
import com.liberty.processing._

/**
 * User: Dimitr
 * Date: 16.03.14
 * Time: 12:12
 */
object Main extends App {
  val zones: List[Zone] =
    Zone(1, PrepareCeramicMixture(1)) ::
      Zone(2, FormingBricks(2)) ::
      Zone(3, DryingBricks(TemperatureBounds(540, 720), 3)) ::
      Zone(4, DryingBricks(TemperatureBounds(720, 790), 4)) ::
      Zone(5, DryingBricks(TemperatureBounds(900, 920), 5)) ::
      Zone(6, DryingBricks(TemperatureBounds(540, 600), 6)) :: Nil

  ParametersController.initialize(zones, null)
  zones.foreach(_.run())
}
