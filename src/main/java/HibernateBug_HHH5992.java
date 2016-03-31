import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class HibernateBug_HHH5992 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// TRIGGER HIBERNATE BUG: HHH-5992, already fixed in 4.0.0.CR7.
		// 该BUG引发的思考，在编写SQL时，养成为字段名或表名取别名的习惯，非常非常重要.
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/liuyf_test?useUnicode=true&amp;characterEncoding=utf8";
			String user = "liuyf";
			String password = "123456";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT id, amount + 1 as amount, amount + 2 as amount, amount + 3 as amount FROM product";
			
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(metaData.getColumnLabel(i) + "\t");
			}
			
			System.out.println("\n");
			System.out.println("not expected: ");
			
			for ( ; rs.next(); ) {
				System.out.println(rs.getString("id") + "\t" + rs.getInt("amount") + "\t" + rs.getInt("amount") + "\t" + rs.getInt("amount"));
			}
			
			System.out.println("\n");
			System.out.println("expected: ");
			
			rs.beforeFirst();
			
			for ( ; rs.next(); ) {
				System.out.println(rs.getString(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4));
			}
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
