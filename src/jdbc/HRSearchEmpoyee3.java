package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HRSearchEmpoyee3 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int minSalary = sc.nextInt();
      int maxSalary = sc.nextInt();
      Connection conn = null;
     // Statement stmt = null;
      PreparedStatement pstmt = null;
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
      
           String sql = "	select first_name || last_name," +
        		   		"	salary"+
        		   		"	from employees"+
        		   		"	where salary > ?"+
        		   		"	and salary <= ?" +
        		   		"	order by salary asc";
           pstmt=conn.prepareStatement(sql);
           
           pstmt.setInt(1, minSalary );
           pstmt.setInt(2, maxSalary);
           
           ResultSet rs = pstmt.executeQuery();
         while(rs.next()){
            String firstName = rs.getString(1);
            int salary = rs.getInt(2);
            
            System.out.println(firstName+" : "+salary);
         }
         System.out.println("연결");                    
      } catch (ClassNotFoundException e) {
         System.out.println("JDBC 파일을 찾을수 없습니다.");
      } catch (SQLException s) {
         System.out.println("db오류" + s);
      } finally {
         try {
            if (pstmt != null) {
               pstmt.close();
            }
            if (conn != null) {
               conn.close();
            }
         } catch (SQLException s) {

         }
      }
   }
}