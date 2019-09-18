package example.creational.factory.transportation

trait Transportation {
  def get(): Transportation
  def start(): String
}