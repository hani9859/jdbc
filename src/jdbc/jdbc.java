package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
   public static void main(String[] args) {
      Connection conn = null;
      // 1.����̹� �ε�
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // 2. connection ���
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
         System.out.println("DB���� ����");
      } catch (ClassNotFoundException ex) {
         System.out.println("JDBC  ���̺귯���� ã�� �� �����ϴ�.");
         // ex.printStackTrace();
      } catch (SQLException ex) {
         System.out.println("DBMS�� �����Ҽ� �����ϴ�.");
         System.out.println("DBMS�� �����Ҽ� �����ϴ�.");
         System.out.println("DBMS�� �����Ҽ� �����ϴ�.");

      } finally {
         try {
            /// 3. �ڿ�����
            if (conn != null) {
               conn.close();
            }
         } catch (SQLException ex) {
         }
      }
   }
}