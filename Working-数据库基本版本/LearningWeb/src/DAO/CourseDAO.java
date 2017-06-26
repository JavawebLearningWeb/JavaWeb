package DAO;

import Entity.CourseEntity;
import Page.CoursePage;
import Util.HibernateUtils;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class CourseDAO {
    public void Add(CoursePage coursePage) {

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setName(coursePage.getName());
            courseEntity.setTeacherid(coursePage.getTeacherid());

            /*BeanUtils.copyProperties(coursePage, courseEntity);*/

            session.save(courseEntity);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Del(CoursePage coursePage){

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            CourseEntity courseEntity=(CourseEntity)session.load(CourseEntity.class,coursePage.getId());
            session.delete(courseEntity);

            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Update(CoursePage coursePage) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            CourseEntity courseEntity = (CourseEntity) session.load(CourseEntity.class, coursePage.getId());
            courseEntity.setName(coursePage.getName());
            courseEntity.setTeacherid(coursePage.getTeacherid());
            /*BeanUtils.copyProperties(coursePage, courseEntity);*/

            session.update(courseEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<CoursePage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<CourseEntity> courseEntityList = session.createQuery("from CourseEntity ").list();
        List<CoursePage> coursePageList = new ArrayList<CoursePage>();
        if (courseEntityList != null && courseEntityList.size() > 0) {
            for (CourseEntity courseEntity : courseEntityList) {
                CoursePage coursePage = new CoursePage();
                coursePage.setId(courseEntity.getId());
                coursePage.setName(courseEntity.getName());
                coursePage.setTeacherid(courseEntity.getTeacherid());
                /*BeanUtils.copyProperties(courseEntity, coursePage);*/
                coursePageList.add(coursePage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return coursePageList;
    }

    public CoursePage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        CoursePage coursePage = new CoursePage();
        CourseEntity courseEntity = (CourseEntity) session.load(CourseEntity.class,id);
        coursePage.setId(courseEntity.getId());
        coursePage.setName(courseEntity.getName());
        coursePage.setTeacherid(courseEntity.getTeacherid());
        /*BeanUtils.copyProperties(courseEntity, coursePage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return coursePage;
    }

}
