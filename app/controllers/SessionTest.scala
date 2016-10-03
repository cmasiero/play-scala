package controllers

import javax.inject.Inject

import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

/**
  * Created by cristiano on 9/23/16.
  */
class SessionTest @Inject() extends Controller {


  def index = Action {
    Logger.info("[SessionTest::index] BEGIN")
    Ok(views.html.indexSessionTest("Http Session Test"))
  }

  /**
    * Test Session example
    */
  case class SessionDto(valueInSession: String)

  val sessionForm: Form[SessionDto] = Form {
    mapping(
      "valueInSession" -> text
    )(SessionDto.apply)(SessionDto.unapply)
  }

  def cleanSession = Action { implicit request =>
    Logger.info("[SessionTest::cleanSession] BEGIN")
    Ok("Session cleaned.") withNewSession
  }

  /**
    * Test Session example
    */
  def addInSession = Action { implicit request =>
    Logger.info("[SessionTest::addInSession] BEGIN")
    val sessionDto = sessionForm.bindFromRequest.get
    request.session.get("counter") match {
      case s: Some[String] =>
        Logger.info(s"[SessionTest::addInSession] Exists elems in session, new elem to insert : ${sessionDto.valueInSession}")
        var counter = request.session.get("counter").get.toInt
        counter += 1
        Ok(s"Got request ${sessionDto.valueInSession}") addingToSession("counter" -> counter.toString, counter.toString -> sessionDto.valueInSession)
      case None =>
        Logger.info(s"[SessionTest::addInSession] No elems in session, first element : ${sessionDto.valueInSession}")
        Ok(s"Got request ${sessionDto.valueInSession}") withSession("counter" -> "0", "0" -> sessionDto.valueInSession)
    }
  }

}
