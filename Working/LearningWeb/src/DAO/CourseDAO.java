package DAO;

import Entity.CourseEntity;
import Entity.CourseEntity;
import Page.CoursePage;
import Page.CoursePage;
import Page.CoursePage;
import Util.HibernateUtils;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class CourseDAO {

    public boolean IsOk(CoursePage coursePage){
        boolean flag = true;
        CourseDAO courseDAO = new CourseDAO();
        List<CoursePage> coursePageList = new ArrayList<>();
        coursePageList = courseDAO.GetAll();
        for(int i=0;i<coursePageList.size();i++){
            CoursePage s = new CoursePage();
            s = coursePageList.get(i);
            if(s.getTeacherid().equals(coursePage.getTeacherid())&&s.getName().equals(coursePage.getName()))
                return false;
        }
        return true;
    }
    
    public boolean Add(CoursePage coursePage) {
        if(!IsOk(coursePage))
            return false;
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setName(coursePage.getName());
            courseEntity.setTeacherid(coursePage.getTeacherid());
            courseEntity.setIntroduction(coursePage.getIntroduction());
            courseEntity.setPicture(coursePage.getPicture());
            courseEntity.setKind(coursePage.getKind());

            /*BeanUtils.copyProperties(coursePage, courseEntity);*/

            session.save(courseEntity);
            session.getTransaction().commit();
            flag = true;
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            flag = false;
        }finally {
            HibernateUtils.closeSession(session);
        }
        return flag;
    }

    public boolean Del(CoursePage coursePage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            CourseEntity courseEntity=(CourseEntity)session.load(CourseEntity.class,coursePage.getId());
            session.delete(courseEntity);

            session.getTransaction().commit();
            flag = true;
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            flag = false;
        }finally {
            HibernateUtils.closeSession(session);
        }
        return flag;
    }

    public boolean Update(CoursePage coursePage) {
        if(!IsOk(coursePage))
            return false;
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            CourseEntity courseEntity = (CourseEntity) session.load(CourseEntity.class, coursePage.getId());
            courseEntity.setName(coursePage.getName());
            courseEntity.setTeacherid(coursePage.getTeacherid());
            courseEntity.setIntroduction(coursePage.getIntroduction());
            courseEntity.setPicture(coursePage.getPicture());
            courseEntity.setKind(coursePage.getKind());
            /*BeanUtils.copyProperties(coursePage, courseEntity);*/

            session.update(courseEntity);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            flag = false;
        } finally {
            HibernateUtils.closeSession(session);
        }
        return flag;
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
                coursePage.setIntroduction(courseEntity.getIntroduction());
                coursePage.setPicture(courseEntity.getPicture());
                coursePage.setKind(courseEntity.getKind());
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
        coursePage.setIntroduction(courseEntity.getIntroduction());
        coursePage.setPicture(courseEntity.getPicture());
        coursePage.setKind(courseEntity.getKind());
        /*BeanUtils.copyProperties(courseEntity, coursePage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return coursePage;
    }

    /*
    根据一列的某一属性值得到一条数据
     */
               /*第一个参数是列的名称，第二个参数是列的值*/
    public CoursePage GetByColumn(String column,String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from CourseEntity where "+ column +" = "+ "'"+key+"'";
        List<CourseEntity> s=session.createQuery(hql).list();
        CoursePage coursePage = null;
        if(s.size()>0){
            coursePage = new CoursePage();
            coursePage.setId(s.get(0).getId());
            coursePage.setName(s.get(0).getName());
            coursePage.setTeacherid(s.get(0).getTeacherid());
            coursePage.setIntroduction(s.get(0).getIntroduction());
            coursePage.setPicture(s.get(0).getPicture());
            coursePage.setKind(s.get(0).getKind());
        }
        HibernateUtils.closeSession(session);
        return coursePage;
    }


    /*
    根据一列的某一属性值得到很多条数据
     */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<CoursePage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from CourseEntity where "+ column +" = "+ "'"+key+"'";
        List<CourseEntity> courseEntityList=session.createQuery(hql).list();
        List<CoursePage> coursePageList = new ArrayList();
        if (courseEntityList != null && courseEntityList.size() > 0){
            for(CourseEntity courseEntity : courseEntityList){
                CoursePage coursePage = new CoursePage();
                coursePage.setId(courseEntity.getId());
                coursePage.setName(courseEntity.getName());
                coursePage.setTeacherid(courseEntity.getTeacherid());
                coursePage.setIntroduction(courseEntity.getIntroduction());
                coursePage.setPicture(courseEntity.getPicture());
                coursePage.setKind(courseEntity.getKind());
                /*BeanUtils.copyProperties(courseEntity, coursePage);*/
                coursePageList.add(coursePage);
            }
        }
        HibernateUtils.closeSession(session);
        return coursePageList;
    }

}
