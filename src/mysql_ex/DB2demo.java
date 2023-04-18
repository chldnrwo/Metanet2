package mysql_ex;

import java.sql.*;

public class DB2demo {
  public static void main(String[] args) {
    Connection conn = makeConnection();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(
          "insert into customer (custid ,name, address, phone) " +
              "values (?, ?, ?, ?)");
      ps.setInt(1, 8);
      ps.setString(2, "손흥민");
      ps.setString(3, "영국");
      ps.setString(4, "010-1234-5678");

      int i = ps.executeUpdate();

      if(i > 0){
        System.out.println(i+"레코드 추가 성공했습니다.");
      }else{
        System.out.println(i+"레코드 추가 실패했습니다.");
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
