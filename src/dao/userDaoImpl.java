package dao;

import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userDaoImpl extends JDBCConnectionFactory implements userDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	User u = null;
	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
				
		String sql = "select * from db_student order by sysid";
				try{
					con = this.getConnection();
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					User u = null;
					while(rs.next()){
						u= new User();
						u.setSysid(rs.getInt("sysid"));
						u.setStudentID(rs.getString("studentID"));
						u.setPassword(rs.getString("password"));
						u.setStudentName(rs.getString("studentName"));
						u.setResult(rs.getInt("result"));
						u.setSclass(rs.getString("sclass"));

						list.add(u);
						System.out.println(rs.getString(1));
					}
				}

				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					this.closeAll(con, pstmt, rs);
				}
				return list;
	}
	
	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "insert into db_student(sysid,studentID,password,studentName,result,sclass)"
				+ "values(?,?,?,?,?,?)";
		try{
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, u.getSysid());
			pstmt.setString(2, u.getStudentID());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getStudentName());
			pstmt.setInt(5, u.getResult());
			pstmt.setString(6, u.getSclass());

			result = pstmt.executeUpdate();
			if(result!=0){
				System.out.println("Ìí¼Ó³É¹¦");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.closeAll(con, pstmt, rs);
		}
		return result;
	}

}
