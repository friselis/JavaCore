package ru.geekbrains.work_with_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
  private static Connection connection;
  private static PreparedStatement ps;

  private static final int DB_SIZE = 10_000;

  public static void main(String[] args) throws Exception {
    connect();
    populateTable();

    System.out.println("Please insert the command.");
    Scanner commandScanner = new Scanner(System.in);
    String nextCommand = commandScanner.nextLine();
    String[] commandArgs = nextCommand.split(" ");

    while (!commandArgs[0].equals("/disconnect")) {
      switch (commandArgs[0]) {
        case "/cost" :
          ResultSet resultSet = getCost(Integer.parseInt(commandArgs[1]));
          if (resultSet.next()){
            int cost = resultSet.getInt(1);
            System.out.println(cost);
          } else {
            System.out.println("This product does not exist!");
          }
          break;
        case "/changecost" :
          changeCost(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
          break;
        case "/productswithcost" :
          ResultSet products = getProducts(Integer.parseInt(commandArgs[1]),
              Integer.parseInt(commandArgs[2]));
          boolean next = products.next();
          if (next){
            while (next) {
              System.out.println(products.getString("prodid"));
              next = products.next();
            }
          } else {
            System.out.println("The products with this price do not exist!");
          }
          break;
        case "/?" :
          System.out.println("/cost - get the price of the product by using prodId");
          System.out.println("/changecost - change the price of the product by using " +
              "prodId and new price");
          System.out.println("/productswithcost - prints out the list of products with the price " +
              "from the range ");
          break;
        default :
          System.out.println("The command does not exist." +
              "Please print /? to get the list of commands.");
      }
      nextCommand = commandScanner.nextLine();
      commandArgs = nextCommand.split(" ");
    }

    disconnect();
  }

  private static ResultSet getProducts(int minCost, int maxCost) throws Exception {
    ps = connection.prepareStatement("SELECT prodid FROM Products WHERE cost>? AND cost<?");
    ps.setInt(1, minCost);
    ps.setInt(2, maxCost);
    return ps.executeQuery();
  }

  private static void changeCost(int prodId, int newCost) throws Exception {
    ps = connection.prepareStatement("UPDATE Products SET cost=? WHERE prodid=?");
    ps.setInt(1, newCost);
    ps.setInt(2, prodId);
    ps.executeUpdate();
  }

  private static ResultSet getCost(int prodId) throws Exception {
    ps = connection.prepareStatement("SELECT cost FROM Products WHERE prodid=?");
    ps.setInt(1, prodId);
    return ps.executeQuery();
  }

  private static void populateTable() throws Exception {
    Statement stmt = connection.createStatement();

    stmt.execute("CREATE TABLE IF NOT EXISTS Products (\n" +
        "    id     INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
        "    prodid INTEGER, \n" +
        "    title  TEXT, \n" +
        "    cost   INTEGER) ;");

    ps = connection.prepareStatement("INSERT INTO Products (prodid, title, cost) "
        + "VALUES (?, ?, ?)");

    stmt.execute("DELETE FROM Products");
    stmt.execute("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='Products';");

    connection.setAutoCommit(false);

    for (int i = 1; i <= DB_SIZE ; i++) {
      ps.setInt(1, i);
      ps.setString(2,"product" + i);
      ps.setInt(3, (i + 1) * 10);
      ps.addBatch();
    }

    ps.executeBatch();
    connection.commit();
  }

  private static void connect() {
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:MainDb.db");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  private static void disconnect() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
