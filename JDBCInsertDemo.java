import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertDemo {

    static final String DB_URL = "jdbc:mysql://localhost:3306/bca_db";

    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        String sql = "INSERT INTO students (name, rollNo) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Successful");

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Anil Kumar"); 
            pstmt.setInt(2, 101);            

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("Record Inserted");
            }

        } catch (SQLException se) {

            System.err.println("SQL Error: " + se.getMessage());
            se.printStackTrace();
        } catch (ClassNotFoundException e) {

            System.err.println("JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        } finally {

            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
