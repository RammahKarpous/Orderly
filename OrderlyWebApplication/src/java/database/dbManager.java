package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbManager 
{  
  public static Connection getConnection() throws SQLException
  {
    DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver() );
    return DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");
  }
}
