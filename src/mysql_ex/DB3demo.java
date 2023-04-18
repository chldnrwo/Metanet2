package mysql_ex;

import java.sql.*;

public class DB3demo {
  public static void main(String[] args) {
    Connection conn = makeConnection();
    //Statement stmt = null;
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement("select * from customer " +
          "where (custid >= ? and custid <= ?) or " +
          "address like ?");
      ps.setInt(1, 2);
      ps.setInt(2, 4);
      ps.setString(3, "대한민국%");
      ResultSet resultSet = ps.executeQuery();
      while(resultSet.next()) {
        System.out.print(resultSet.getString("custid")+":");
        System.out.print(resultSet.getString("name")+":");
        System.out.print(resultSet.getString("address")+":");
        System.out.println(resultSet.getString("phone"));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  public static Connection makeConnection() {

    String url = "jdbc:mysql://localhost:3306/" +
        "madang?serverTimezone=Asia/Seoul&" +
        "useSSL=false&useUnicode=true&characterEncoding=UTF-8";

    Connection conn = null;

    try{
      System.out.println("데이터베이스 연결중...");
      conn = DriverManager.getConnection(url, "root", "qkznaks1!2!3!");
      System.out.println("데이터베이스 연결 성공!");
    }catch(Exception e){
      System.out.println("데이터베이스 연결 실패!");
      System.out.println(e.getMessage());
    }
    return conn;
  }
}
