package dao;

import bean.Choice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class choiceDaoImpl extends JDBCConnectionFactory implements choiceDao {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Choice choice=null;
    @Override
    public List<Choice> getAll() {
        List<Choice> list = new ArrayList<Choice>();

        String sql = "select * from db_subject order by stID";
        try {
            con = this.getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            Choice choice = null;
            while (rs.next()) {
                choice = new Choice();
                choice.setStID(rs.getInt("stID"));
                choice.setStTitle(rs.getString("stTitle"));
                choice.setStOptionA(rs.getString("stOptionA"));
                choice.setStOptionB(rs.getString("stOptionB"));
                choice.setStOptionC(rs.getString("stOptionC"));
                choice.setStOptionD(rs.getString("stOptionD"));
                choice.setStAnswer(rs.getString("stAnswer"));
                choice.setStParse(rs.getString("stParse"));
                list.add(choice);
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(con, pstmt, rs);
        }
        return list;
    }
    @Override
    public int addChoice(Choice choice) {
        // TODO Auto-generated method stub
        int result = 0;
        String sql = "insert into db_subject(stID,stTitle,stOptionA,stOptionB,stOptionC,stOptionD,stAnswer,stParse)"
                + "values(?,?,?,?,?,?,?,?)";
        try {
            con = this.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,choice.getStID());
            pstmt.setString(2,choice.getStTitle());
            pstmt.setString(3,choice.getStOptionA());
            pstmt.setString(4,choice.getStOptionB());
            pstmt.setString(5,choice.getStOptionC());
            pstmt.setString(6,choice.getStOptionD());
            pstmt.setString(7,choice.getStAnswer());
            pstmt.setString(8,choice.getStParse());
            result = pstmt.executeUpdate();
            if(result!=0){
                System.out.println("Success");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            this.closeAll(con, pstmt, rs);
        }
        return result;
    }
}

