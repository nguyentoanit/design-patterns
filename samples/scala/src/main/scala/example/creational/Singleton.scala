package example.creational

import java.sql.{Connection, DriverManager, Statement}

object Singleton {
  def main(args: Array[String]): Unit = {
    val statement: Statement = Database.getConnection.createStatement()
    val resultSet = statement.executeQuery("SELECT host, user FROM user")
    while ( resultSet.next() ) {
      val host = resultSet.getString("host")
      val user = resultSet.getString("user")
      println("host, user = " + host + ", " + user)
    }
  }
}

object Database {
  val url = "jdbc:mysql://localhost:8889/mysql"
  val driver = "com.mysql.jdbc.Driver"
  val username = "username"
  val password = "password"
  private var connection: Connection = null

  def getConnection: Connection = {
    if (this.connection == null) {
      Class.forName(driver)
      this.connection = DriverManager.getConnection(url, username, password)
      this.connection
    } else this.connection
  }
}
