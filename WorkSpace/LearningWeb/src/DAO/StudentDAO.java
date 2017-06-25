package DAO;

import Entity.StudentEntity;
import Entity.StudentEntity;
import Page.StudentPage;
import Util.HibernateUtils;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class StudentDAO {

    public void Add(StudentPage studentPage) {

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            StudentEntity studentEntity = new StudentEntity();
            BeanUtils.copyProperties(studentPage, studentEntity);

            session.save(studentEntity);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Del(StudentPage studentPage){

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            StudentEntity studentEntity=(StudentEntity)session.load(StudentEntity.class,studentPage.getId());
            session.delete(studentEntity);

            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Update(StudentPage studentPage) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            StudentEntity studentEntity = (StudentEntity) session.load(StudentEntity.class, studentPage.getId());
            BeanUtils.copyProperties(studentPage, studentEntity);

            session.update(studentEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<StudentPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<StudentEntity> studentEntityList = session.createQuery("from StudentEntity ").list();
        List<StudentPage> studentPageList = new ArrayList<StudentPage>();
        if (studentEntityList != null && studentEntityList.size() > 0) {
            for (StudentEntity studentEntity : studentEntityList) {
                StudentPage studentPage = new StudentPage();
                BeanUtils.copyProperties(studentEntity, studentPage);
                studentPageList.add(studentPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return studentPageList;
    }

    public StudentPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        StudentPage studentPage = new StudentPage();
        StudentEntity studentEntity = (StudentEntity) session.load(StudentEntity.class,id);
        BeanUtils.copyProperties(studentEntity, studentPage);
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return studentPage;
    }

}
