package DAO;

import Entity.TeacherEntity;
import Page.TeacherPage;
import Util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class TeacherDAO {
    /*
 * 增加
 */
    public void Add(TeacherPage teacherPage) {

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            TeacherEntity teacherEntity = new TeacherEntity();
            teacherEntity.setUsername(teacherPage.getUsername());
            teacherEntity.setStatus(teacherPage.getStatus());
            teacherEntity.setPassword(teacherPage.getPassword());
            teacherEntity.setName(teacherPage.getName());
            teacherEntity.setMajor(teacherPage.getMajor());
            teacherEntity.setGender(teacherPage.getGender());
            teacherEntity.setEmail(teacherPage.getEmail());
            /*BeanUtils.copyProperties(teacherPage, teacherEntity);*/

            session.save(teacherEntity);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Del(TeacherPage teacherPage){

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            TeacherEntity teacherEntity=(TeacherEntity)session.load(TeacherEntity.class,teacherPage.getId());
            session.delete(teacherEntity);

            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Update(TeacherPage teacherPage) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            TeacherEntity teacherEntity = (TeacherEntity) session.load(TeacherEntity.class, teacherPage.getId());
            teacherEntity.setUsername(teacherPage.getUsername());
            teacherEntity.setStatus(teacherPage.getStatus());
            teacherEntity.setPassword(teacherPage.getPassword());
            teacherEntity.setName(teacherPage.getName());
            teacherEntity.setMajor(teacherPage.getMajor());
            teacherEntity.setGender(teacherPage.getGender());
            teacherEntity.setEmail(teacherPage.getEmail());
            /*BeanUtils.copyProperties(teacherPage, teacherEntity);*/

            session.update(teacherEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<TeacherPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<TeacherEntity> teacherEntityList = session.createQuery("from TeacherEntity ").list();
        List<TeacherPage> teacherPageList = new ArrayList<TeacherPage>();
        if (teacherEntityList != null && teacherEntityList.size() > 0) {
            for (TeacherEntity teacherEntity : teacherEntityList) {
                TeacherPage teacherPage = new TeacherPage();
                teacherPage.setId(teacherEntity.getId());
                teacherPage.setUsername(teacherEntity.getUsername());
                teacherPage.setStatus(teacherEntity.getStatus());
                teacherPage.setPassword(teacherEntity.getPassword());
                teacherPage.setName(teacherEntity.getName());
                teacherPage.setMajor(teacherEntity.getMajor());
                teacherPage.setGender(teacherEntity.getGender());
                teacherPage.setEmail(teacherEntity.getEmail());
                /*BeanUtils.copyProperties(teacherEntity, teacherPage);*/
                teacherPageList.add(teacherPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return teacherPageList;
    }

    public TeacherPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        TeacherPage teacherPage = new TeacherPage();
        TeacherEntity teacherEntity = (TeacherEntity) session.load(TeacherEntity.class,id);
        teacherPage.setId(teacherEntity.getId());
        teacherPage.setUsername(teacherEntity.getUsername());
        teacherPage.setStatus(teacherEntity.getStatus());
        teacherPage.setPassword(teacherEntity.getPassword());
        teacherPage.setName(teacherEntity.getName());
        teacherPage.setMajor(teacherEntity.getMajor());
        teacherPage.setGender(teacherEntity.getGender());
        teacherPage.setEmail(teacherEntity.getEmail());
        /*BeanUtils.copyProperties(teacherEntity, teacherPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return teacherPage;
    }

}
