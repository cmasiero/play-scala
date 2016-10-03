package models

import sorm._
/**
  * Created by cristiano on 9/20/16.
  */
object DB extends Instance(entities = Seq(Entity[Person]()), url = "jdbc:h2:mem:test")
