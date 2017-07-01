package StudentServlst.Student;

import DAO.CourseDAO;
import DAO.RelationDAO;
import Page.CoursePage;
import Page.RelationPage;

import java.util.ArrayList;

/**
 * Created by 16689 on 2017/7/1.
 */
public class SuggestCourse {
    private  CoursePage learningcoursePage;//课程
    private ArrayList<CoursePage> suggestcourse;//该课程的建议课程
    private  int suggestcount;

    public SuggestCourse(CoursePage learningcoursePage) {
        this.learningcoursePage = learningcoursePage;
        setSuggestcourse();  //获得课程的前置节点



    }

    public CoursePage getLearningcoursePage() {
        return learningcoursePage;
    }

    public void setLearningcoursePage(CoursePage learningcoursePage) {
        this.learningcoursePage = learningcoursePage;
    }

    public ArrayList<CoursePage> getSuggestcourse() {
        return suggestcourse;
    }

    public void setSuggestcourse() {//获得课程的前节点
        RelationDAO relationDAO=new RelationDAO();
        suggestcourse=new ArrayList<>();
        ArrayList<RelationPage> relationPages= (ArrayList<RelationPage>) relationDAO.GetAllByColumn("courseid",learningcoursePage.getId());
        CourseDAO courseDAO=new CourseDAO();
      for (int i=0;i<relationPages.size();i++)
     {
         CoursePage coursePage=courseDAO.GetById(relationPages.get(i).getFrontcourseid());
         suggestcourse.add(coursePage);
     }
     setSuggestcount(suggestcourse.size());

    }

    public int getSuggestcount() {
        return suggestcount;
    }

    public void setSuggestcount(int suggestcount) {
        this.suggestcount = suggestcount;
    }


}
