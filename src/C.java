import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class C {

	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "test");
		PreparedStatement stmt = con.prepareStatement("select * from sample");
		ResultSet res = stmt.executeQuery();
	
		while (res.next()) {
			System.out.println(res.getInt("id"));
			System.out.println(res.getString("name"));
			System.out.println(res.getString("college"));
		}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
