package controllers

import javax.inject.Inject

import models.{DB, Person}
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

/**
  * Created by cristiano on 9/23/16.
  */
class DbSormCoffescript @Inject() extends Controller {

  def index = Action {
    Logger.info("[DbSormCoffescript::index] BEGIN")
    Ok(views.html.indexSormCoffeescript("Test Db orm sorm, coffescript html form post"))
  }

  /**
    * Test Db orm sorm, coffescript html form post
    */
  val personForm: Form[Person] = Form {
    mapping(
      "name" -> text
    )(Person.apply)(Person.unapply)
  }

  /**
    * Test Db orm sorm, coffescript html form post
    *
    * @return
    */
  def addPerson = Action { implicit request =>
    Logger.info("[DbSormCoffescript::addPerson] BEGIN")
    val person = personForm.bindFromRequest.get
    DB.save(person)
    Redirect(routes.DbSormCoffescript.index())
  }

  /**
    * Test Db orm sorm, coffescript html form post
    *
    * @return
    */
  def getPersons = Action {
    Logger.info("[DbSormCoffescript::getPersons] BEGIN")
    val persons = DB.query[Person].fetch
    Ok(Json.toJson(persons))
  }


}
