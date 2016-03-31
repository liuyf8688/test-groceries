import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SqlInjectProblem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/liuyf_test?useUnicode=true&amp;characterEncoding=utf8";
			String user = "liuyf";
			String password = "123456";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT id, name, amount FROM product where name = ?";
			
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, " and i = 10");
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(metaData.getColumnLabel(i) + "\t");
			}
			
			System.out.println("\n");
			for ( ; rs.next(); ) {
				System.out.println(rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("amount"));
			}
			
			System.out.println("\n");
		} finally {
			if (rs != null) {
				rs.close();
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		}
	}
}
