package example.creational.factory

import example.creational.factory.transportation.{Car, Ship, Transportation}

object Main {
  def main(args: Array[String]): Unit = {
    val transportation: Transportation = if (args.length == 1) new Car
    else new Ship

    println(transportation.start())
  }
}
