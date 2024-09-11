import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class B {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the name to be update");
		String name=scan.next();
		System.out.println("enter the id need to be updated");
		int id=scan.nextInt();
		String url="jdbc:mysql://localhost:3306/testdb";
		String username="root";
		String password="test";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			//this is for the update statement
			//PreparedStatement ps = con.prepareStatement("update sample set name=? where id=?");
			//ps.setString(1, name);
			//ps.setInt(2, id);
//			if (executeUpdate>0) {
//				System.out.println("updated succesfull!!");
//			}
//			else {
//				System.out.println("update not successfull!!");
//			}
			//this is for the delete statement
			PreparedStatement ps = con.prepareStatement("delete from sample where id=?");
			ps.setInt(1, id);
			
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate>0) {
				System.out.println("deletion done successfully!!!");
			}
			else {
				System.out.println("deletion not done sucessfully!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
