import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnect {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb1","root","1987leon");
	PreparedStatement ps = con.prepareStatement("insert into image1(name,image)values(?,?)");
		FileInputStream fin=new FileInputStream("C:\\\\Users\\\\amank\\\\OneDrive\\\\Desktop\\\\photos\\\\aman.jpg");  
		ps.setString(1,"aman pic");
		ps.setBinaryStream(2, fin);
		int result2 = ps.executeUpdate();
		Statement stmt1 = con.createStatement();
		
		
		ResultSet rs3 = 	stmt1.executeQuery("select * from image");
		while(rs3.next())
		{
			System.out.println(rs3.getString(1)+" "+rs3.getBlob(2));
		}
		
		
		
			//	Statement stmt = con.createStatement();
			
			
/*			int result = stmt.executeUpdate("insert into customer(name,age,address,salary) values ('mehar',35,'5399 sunday',200),('sonia',45,'5399 sunday',200)");
			int reult1 = stmt.executeUpdate("Delete from customer where name='mehar'");
			int a[] = stmt.executeBatch();
			ResultSet rs = stmt.executeQuery("select* from customer");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getNString(2)+" "+rs.getInt(3)+" "+rs.getNString(4)+" "+rs.getDouble(5));
			}
			*/
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
