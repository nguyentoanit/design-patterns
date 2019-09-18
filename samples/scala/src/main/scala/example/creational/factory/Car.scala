package example.creational.factory.transportation

class Car extends Transportation {
  override def get(): Transportation = new Car

  override def start(): String = "Car is starting"
}
