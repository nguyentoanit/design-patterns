package example.creational.factory.transportation

class Ship extends Transportation {
  override def get(): Transportation = new Ship

  override def start(): String = "Ship is starting"
}
