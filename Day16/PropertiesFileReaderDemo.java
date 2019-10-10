import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class PropertiesFileReaderDemo {
	public static Connection getConnection() throws SQLException{
		Properties properties=new Properties();
		String userName=null;
		String password=null;
		String driver=null;
		String url=null;
		try {
			FileReader fileReader=new FileReader("C:\\Users\\pbalaji5\\dxc\\mydb.properties");
				properties.load(fileReader);
				userName=properties.getProperty("userName");
				password=properties.getProperty("password");
				driver=properties.getProperty("driver");
				url=properties.getProperty("url");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection=null;
		connection=DriverManager.getConnection(url,userName,password);
		return connection;
	}
		public static void main(String[] args) {
			try {
				getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
