package DAO;

import Entity.AddcourseEntity;
import Entity.CourseEntity;
import Page.*;
import Util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 79333 on 2017/6/27.
 */
public class CDAO {
    public List<Course> Get() {
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courseList = new ArrayList();
        List<CoursePage>coursePageList =  courseDAO.GetAll();
        if(coursePageList!=null){
            for(int i=0;i<coursePageList.size();i++){
                Course course = new Course();
                course.setCp(coursePageList.get(i));
                TeacherDAO teacherDAO = new TeacherDAO();
                TeacherPage teacherPage =  teacherDAO.GetById(course.getCp().getTeacherid());
                course.setTname(teacherPage.getName());
                course.setTusername(teacherPage.getUsername());
                ProgressDAO progressDAO = new ProgressDAO();
                List<ProgressPage> progressPageList =  progressDAO.GetAllByColumn("courseid",course.getCp().getId());
                HashSet<String> hashSet = new HashSet();
                if(progressPageList!=null){
                    for(int j=0;j<progressPageList.size();j++){
                        hashSet.add(progressPageList.get(j).getStudentid()+progressPageList.get(j).getCourseid());
                    }
                    course.setCnum(hashSet.size());
                }
                else
                    course.setCnum(0);
                courseList.add(course);
            }
        }
        else
            courseList = null;
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return courseList;
    }


    public List<Course> Get1() {
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courseList = new ArrayList();
        List<CoursePage> coursePageList = courseDAO.GetAll();
        if (coursePageList != null) {
            for (int i = 0; i < coursePageList.size(); i++) {
                Course course = new Course();
                course.setCp(coursePageList.get(i));
                TeacherDAO teacherDAO = new TeacherDAO();
                TeacherPage teacherPage = teacherDAO.GetById(course.getCp().getTeacherid());
                course.setTname(teacherPage.getName());
                course.setTusername(teacherPage.getUsername());
                LearnDAO learnDAO = new LearnDAO();
                List<LearnPage> learnPageList = learnDAO.GetAllByColumn("courseid",course.getCp().getId());
                if(learnPageList!=null)
                    course.setCnum(learnPageList.size());
                else
                    course.setCnum(0);
                courseList.add(course);
            }
        }
        else
            courseList = null;
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return courseList;
    }
}