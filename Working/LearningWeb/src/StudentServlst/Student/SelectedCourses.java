package StudentServlst.Student;

import DAO.ChapterDAO;
import DAO.CourseDAO;
import DAO.LearnDAO;
import DAO.ProgressDAO;
import Page.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16689 on 2017/6/29.
 */
public class SelectedCourses {
    private StudentPage studentPage;
    private ArrayList<CoursePage> coursePages;
    private  int count;
    private  int [] finishpersentage;//完成进度百分比*100

    public SelectedCourses(StudentPage studentPage) {
        this.studentPage = studentPage;
        LearnDAO learnDAO=new LearnDAO();
        List<LearnPage> learnPages= (List<LearnPage>) learnDAO.GetAllByColumn("studentid",studentPage.getId());
        coursePages=new ArrayList<>();
        CourseDAO courseDAO=new CourseDAO();
        for (int i=0;i<learnPages.size();i++)
        {
            coursePages.add(courseDAO.GetById(learnPages.get(i).getCourseid()));
        }
        count=coursePages.size();
        setFinishpersentage();//计算出完成进度百分比
    }

    public StudentPage getStudentPage() {
        return studentPage;
    }

    public void setStudentPage(StudentPage studentPage) {
        this.studentPage = studentPage;
    }

    public ArrayList<CoursePage> getCoursePages() {
        return coursePages;
    }

    public void setCoursePages(ArrayList<CoursePage> coursePages) {
        this.coursePages = coursePages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int [] getFinishpersentage() {
        return finishpersentage;
    }

    public void setFinishpersentage() {
       finishpersentage=new int[count];
       int percentage;
        ProgressDAO progressDAO=new ProgressDAO();
        ChapterDAO chapterDAO=new ChapterDAO();
       for (int i=0;i<count;i++)
       {
           List<ProgressPage> progressPages=progressDAO.GetAllByColumn("studentid",studentPage.getId(),"courseid",coursePages.get(i).getId());
           List<ChapterPage> chapterPages =chapterDAO.GetAllByColumn("courseid",coursePages.get(i).getId());
           int procount,chaptercount;
           chaptercount=chapterPages.size();
           procount=progressPages.size();
           if (chaptercount==0)
           {
               percentage=0;

           }
           else {
               percentage=  (procount*100/chaptercount);
           }

           finishpersentage[i]= percentage;

       }
    }


}
