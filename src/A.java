import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		String name = scan.next();
		String college = scan.next();
		String url = "jdbc:mysql://localhost:3306/testDb";
		String username = "root";
		String password = "test";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			String query = "INSERT INTO sample (id, name, college) VALUES (?, ?, ?)";
			  PreparedStatement ps = con.prepareStatement(query);
		    // Set the values for the placeholders
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, college);

            // Execute the update
            int executeUpdate = ps.executeUpdate();

            // Check if insertion was successful
            if (executeUpdate > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }

            // Close resources
            ps.close();
            con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
