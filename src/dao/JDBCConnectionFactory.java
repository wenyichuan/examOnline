package dao;
import java.sql.*;

public class JDBCConnectionFactory {
	public JDBCConnectionFactory(){

	}
	public static Connection getConnection(){
		Connection conn=null;

		String driverClass="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
		String user="root";
		String password="root";

		try{
			Class.forName(driverClass);
			conn=DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void closeAll(Connection con,PreparedStatement pstmt,ResultSet rs){
		//�رս��������
		if(rs!=null){
			try{
				rs.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		//�رձ���ִ��SQL���
		if(pstmt!=null){
			try{
				pstmt.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		//�ر����ݿ�����
		if(con!=null){
			try{
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
