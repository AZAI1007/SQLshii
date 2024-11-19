import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to Database
            String url = "jdbc:mysql://localhost:3306/abd";
            String user = "root";
            String password = "localroot";
            System.out.println("Connecting to: " + url + " with user " + user);
            Connection con = DriverManager.getConnection(url, user, password);

            // Query
            String query = "SELECT student_name FROM student WHERE student_id = 23002223";
            System.out.println("Executing query: " + query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Process Results
            if (rs.next()) {
                String name = rs.getString("student_name");
                System.out.println("Student Name: " + name);
            } else {
                System.out.println("No results found for student_id = 23002223.");
            }

            // Close Resources
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred:");
            e.printStackTrace();
        }
    }
}
