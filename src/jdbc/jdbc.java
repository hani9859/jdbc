package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
   public static void main(String[] args) {
      Connection conn = null;
      // 1.드라이버 로드
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // 2. connection 얻기
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
         System.out.println("DB연결 성공");
      } catch (ClassNotFoundException ex) {
         System.out.println("JDBC  라이브러리를 찾을 수 없습니다.");
         // ex.printStackTrace();
      } catch (SQLException ex) {
         System.out.println("DBMS와 연결할수 없습니다.");
         System.out.println("DBMS와 연결할수 없습니다.");
         System.out.println("DBMS와 연결할수 없습니다.");

      } finally {
         try {
            /// 3. 자원정리
            if (conn != null) {
               conn.close();
            }
         } catch (SQLException ex) {
         }
      }
   }
}