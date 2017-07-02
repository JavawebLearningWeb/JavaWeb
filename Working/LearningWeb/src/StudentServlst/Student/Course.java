package StudentServlst.Student;

import DAO.CourseDAO;
import DAO.LearnDAO;
import DAO.TeacherDAO;
import Page.CoursePage;
import Page.LearnPage;
import Page.StudentPage;
import Page.TeacherPage;

import java.util.ArrayList;

/**
 * Created by 16689 on 2017/7/1.
 */
public class Course {
    private StudentPage studentPage;//学生的个人信息
    private CoursePage learningcourse;//学生选择的课程
    private ArrayList<CoursePage> allcourses;//全部的课程列表
    private int count;//总的数目
    private ArrayList<CoursePage> choosedcourses;//已经选择的课程
    private int choosedcount;//已选择课程的数目
    private ArrayList<CoursePage> canchoosecourses;//还未学习的课程
    private ArrayList<TeacherPage> canteacherPages;//可以选择的老师信息,与canchoosecourses形成映射关系
    private int canchoosecount;//可以选择的课程个数
    private ArrayList<SuggestCourse> suggestCourses;//对应的每一个课程建议课程
    private CoursePage suggestcoursepage; //系统推荐课程将来可以采用好的推荐算法

    public Course(StudentPage studentPage) {
        this.studentPage = studentPage;
        CourseDAO courseDAO = new CourseDAO();
        allcourses = (ArrayList<CoursePage>) courseDAO.GetAll();//获得全部的课程列表
        count = allcourses.size();
        setChoosedcourses();          //获取已经学习的课程
        suggestCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            SuggestCourse suggestCourse = new SuggestCourse(allcourses.get(i),getChoosedcourses());
            suggestCourses.add(suggestCourse);
        }

        setCanchoosecourses();       //设置还没学习的课程


    }

    public StudentPage getStudentPage() {
        return studentPage;
    }

    public void setStudentPage(StudentPage studentPage) {
        this.studentPage = studentPage;
    }

    public CoursePage getLearningcourse() {
        return learningcourse;
    }

    public void setLearningcourse(CoursePage learningcourse) {
        this.learningcourse = learningcourse;
        choosedcourses.add(learningcourse);
        choosedcount++;
        for (int i = 0; i < canchoosecount; i++) {
            if (canchoosecourses.get(i).getId().equals(learningcourse.getId())) {
                canchoosecourses.remove(i);
                canteacherPages.remove(i);
                break;
            }
        }
        canchoosecount--;
        LearnPage learnPage = new LearnPage();
        learnPage.setCourseid(learningcourse.getId());
        learnPage.setStudentid(studentPage.getId());
        LearnDAO learnDAO = new LearnDAO();
        learnDAO.Add(learnPage);    //写入数据库
    }

    public ArrayList<CoursePage> getAllcourses() {
        return allcourses;
    }

    public void setAllcourses(ArrayList<CoursePage> allcourses) {
        this.allcourses = allcourses;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<CoursePage> getChoosedcourses() {
        return choosedcourses;
    }

    public void setChoosedcourses() {//获取已经学习的课程
        choosedcourses = new ArrayList<>();
        LearnDAO learnDAO = new LearnDAO();
        ArrayList<LearnPage> learnPages = (ArrayList<LearnPage>) learnDAO.GetAllByColumn("studentid", studentPage.getId());
        CourseDAO courseDAO = new CourseDAO();
        for (int i = 0; i < learnPages.size(); i++) {
            choosedcourses.add(courseDAO.GetById(learnPages.get(i).getCourseid()));
        }
        choosedcount = choosedcourses.size();
    }

    public int getChoosedcount() {
        return choosedcount;
    }

    public void setChoosedcount(int choosedcount) {
        this.choosedcount = choosedcount;
    }

    public ArrayList<SuggestCourse> getSuggestCourses() {
        return suggestCourses;
    }

    public void setSuggestCourses(ArrayList<SuggestCourse> suggestCourses) {
        this.suggestCourses = suggestCourses;
    }

    public ArrayList<CoursePage> getCanchoosecourses() {
        return canchoosecourses;
    }

    public void setCanchoosecourses() { //条件：已经获取了已经学习的课程
        canchoosecourses = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            boolean flag = false;
            for (int j = 0; j < choosedcount; j++) {
                if (allcourses.get(i).getId().equals(choosedcourses.get(j).getId())) {
                    flag = true;//发生匹配就改变值
                }
            }
            if (flag == false) {
                canchoosecourses.add(allcourses.get(i));
            }
        }
        canchoosecount = canchoosecourses.size();
        canteacherPages = new ArrayList<>();
        TeacherDAO teacherDAO = new TeacherDAO();
        for (int i = 0; i < canchoosecount; i++) {
            canteacherPages.add(teacherDAO.GetById(canchoosecourses.get(i).getTeacherid()));
        }
        Randow();//用随机数模拟推荐算法
    }

    public int getCanchoosecount() {
        return canchoosecount;
    }

    public void setCanchoosecount(int canchoosecount) {
        this.canchoosecount = canchoosecount;
    }

    public void setChoosedcourses(ArrayList<CoursePage> choosedcourses) {
        this.choosedcourses = choosedcourses;
    }

    public void setCanchoosecourses(ArrayList<CoursePage> canchoosecourses) {
        this.canchoosecourses = canchoosecourses;
    }

    public ArrayList<TeacherPage> getCanteacherPages() {
        return canteacherPages;
    }

    public void Randow() {
        int ran = -1;
        while (!(ran >= 0 && ran < canchoosecount)) {
            ran = (int) (Math.random() * 10);
        }
        suggestcoursepage = canchoosecourses.get(ran);

    }

    public void setCanteacherPages(ArrayList<TeacherPage> canteacherPages) {
        this.canteacherPages = canteacherPages;
    }

    public CoursePage getSuggestcoursepage() {
        return suggestcoursepage;
    }

    public void setSuggestcoursepage(CoursePage suggestcoursepage) {
        this.suggestcoursepage = suggestcoursepage;
    }
}
