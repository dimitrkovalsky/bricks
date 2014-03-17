package com.liberty.controllers

import com.liberty.utills.Logger
import java.net.URL
import java.util
import javafx.scene.control.Label
import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe}
import javafx.{fxml => jfxf}
import javafx.fxml.FXML
import com.liberty.common.{TemperatureBounds, Zone}
import com.liberty.processing.{ParametersController, DryingBricks, FormingBricks, PrepareCeramicMixture}
import scalafx.scene.control.ListView

class TPController extends jfxf.Initializable {

  @FXML private var processStatus: Label = _
  @FXML private var history: ListView[String] = _

  @FXML
  private def onStartButton(event: jfxe.ActionEvent) {
    Logger.log("Processing started")

    processStatus.setText("On processing")
    startProcessing()
  }


  def startProcessing(){
    val zones: List[Zone] =
      Zone(1, PrepareCeramicMixture(1)) ::
        Zone(2, FormingBricks(2)) ::
        Zone(3, DryingBricks(TemperatureBounds(540, 720), 3)) ::
        Zone(4, DryingBricks(TemperatureBounds(720, 790), 4)) ::
        Zone(5, DryingBricks(TemperatureBounds(900, 920), 5)) ::
        Zone(6, DryingBricks(TemperatureBounds(540, 600), 6)) :: Nil

    ParametersController.initialize(zones, this)
    zones.foreach(_.run())

  }

  def initialize(url: URL, rb: util.ResourceBundle) {}
}