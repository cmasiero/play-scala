package controllers

import javax.inject.Inject

import play.api.Logger
import play.api.mvc._

/**
  * Created by cristiano on 9/23/16.
  */
class AjaxCall @Inject() extends Controller {


  def index = Action {
    Logger.info("[AjaxCall::index] BEGIN")
    Ok(views.html.indexAjaxCall("Test ajax jquery call"))
  }

  /**
    * Test method jquery/ajax.
    *
    * @param id
    * @return
    */
  def user(id: Long) = Action {
    Logger.info("[AjaxCall::user] BEGIN")
    Ok("Got request [ " + id + "]")
  }


}
