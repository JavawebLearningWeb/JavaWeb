package Database;

import Page.Course;
import Page.CoursePage;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Administrator on 2017/6/27.
 */
public class AddCourseDao extends BaseDao{
    public ArrayList<Course> findTeacherCourse(String result){

        ArrayList<Course> teacouList=new ArrayList<Course>();
        String sql="SELECT distinct addcourse.id,username,teacher.name,course,result,teacher.id,course.kind ,precourseid1,precourseid2,precourseid3,precourseid4  FROM  " +
                "learningweb.addcourse,learningweb.teacher,learningweb.course where teacher.id=addcourse.teacherid=course.teacherid and result like  ?;";
        try (
                Connection conn=dataSource.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
                pstmt.setString(1, result);
                ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                Course t=new Course();
                CoursePage cp=new CoursePage();
                cp.setName(rst.getString("course"));
                t.setCp(cp);
                t.setKind(rst.getString("course.kind"));
                t.setTeacherid(rst.getString("teacher.id"));
                t.setAddcouid(rst.getString("addcourse.id"));
                t.setTname(rst.getString("teacher.name"));
                t.setTusername(rst.getString("username"));
                t.setResult(rst.getString("result"));
                t.setPrecourse1(rst.getString("precourseid1"));
                t.setPrecourse2(rst.getString("precourseid2"));
                t.setPrecourse3(rst.getString("precourseid3"));
                t.setPrecourse4(rst.getString("precourseid4"));
                teacouList.add(t);
            }
            return teacouList;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    public boolean updateTeaCou(String result,Course c){
        String sql="update learningweb.addcourse set result=? where id=?";
        try (
                Connection conn=dataSource.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1, result);
            pstmt.setString(2, c.getAddcouid());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }
    public boolean findExistCourse(String cname,String tid){

        String sql="SELECT * FROM learningweb.course where name=? and teacherid=?;";
        try (
                Connection conn=dataSource.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1, cname);
            pstmt.setString(2, tid);
            ResultSet rst=pstmt.executeQuery();
            boolean valid=rst.next();
            if(valid){
                return false;
            }else {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    public boolean addCourse(CoursePage c){

        String sql="INSERT INTO learningweb.course (id,name,teacherid,kind)VALUES(?,?,?,?);";
        try (
                Connection conn=dataSource.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,c.getId());
            pstmt.setString(2,c.getName());
            pstmt.setString(3, c.getTeacherid());
            pstmt.setString(4, c.getKind());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    public boolean JudgeAdmin(String no,String pswd){

        String sql="SELECT * FROM learningweb.administrator where username=? and password=?;";
        try (
                Connection conn=dataSource.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            pstmt.setString(2,pswd);
            ResultSet rst=pstmt.executeQuery();

            boolean valid=rst.next();
            return valid;


        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateCourse(Course c,String cno) {
        String sql = "update learningweb.course set id=?,name=?,introduction=?,kind=? where id=?;";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getCp().getId());
            pstmt.setString(2, c.getCp().getName());
            pstmt.setString(3, c.getCp().getIntroduction());
            pstmt.setString(4, c.getCp().getKind());
            pstmt.setString(5, cno);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteCourse(String cno){
        String sql="DELETE FROM learningweb.course WHERE id=?;";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,cno);
            int i=pstmt.executeUpdate();
            if(i!=0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    public String findmaxid(){

        String maxid = null;
        String sql="SELECT max(id+0) as maxid FROM learningweb.relation ORDER BY CAST(`id` AS DECIMAL);" ;

        try (
                Connection conn=dataSource.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                maxid=rst.getString("maxid");

            }
            return maxid;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    public boolean addprecourseid(String cid,String preid,String id) {
        String sql = "insert into learningweb.relation values(?,?,?);";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2,cid);
            pstmt.setString(3, preid);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
