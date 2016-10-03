package models

import play.api.libs.json.Json

/**
  * Created by cristiano on 9/20/16.
  */
case class Person (name: String)

object Person {

  implicit val personFormat = Json.format[Person]
}
