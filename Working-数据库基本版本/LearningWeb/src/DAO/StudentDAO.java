package DAO;

import Entity.StudentEntity;

import Page.StudentPage;
import Util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
            studentEntity.setGrade(studentPage.getGrade());
            studentEntity.setBirthday(studentPage.getBirthday());
            studentEntity.setUsername(studentPage.getUsername());
            studentEntity.setStatus(studentPage.getStatus());
            studentEntity.setPassword(studentPage.getPassword());
            studentEntity.setName(studentPage.getName());
            studentEntity.setMajor(studentPage.getMajor());
            studentEntity.setGendar(studentPage.getGendar());
            studentEntity.setEmail(studentPage.getEmail());
            /*BeanUtils.copyProperties(studentPage, studentEntity);*/

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
            studentEntity.setGrade(studentPage.getGrade());
            studentEntity.setBirthday(studentPage.getBirthday());
            studentEntity.setUsername(studentPage.getUsername());
            studentEntity.setStatus(studentPage.getStatus());
            studentEntity.setPassword(studentPage.getPassword());
            studentEntity.setName(studentPage.getName());
            studentEntity.setMajor(studentPage.getMajor());
            studentEntity.setGendar(studentPage.getGendar());
            studentEntity.setEmail(studentPage.getEmail());
            /*BeanUtils.copyProperties(studentPage, studentEntity);*/

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
                studentPage.setId(studentEntity.getId());
                studentPage.setGrade(studentEntity.getGrade());
                studentPage.setBirthday(studentEntity.getBirthday());
                studentPage.setUsername(studentEntity.getUsername());
                studentPage.setStatus(studentEntity.getStatus());
                studentPage.setPassword(studentEntity.getPassword());
                studentPage.setName(studentEntity.getName());
                studentPage.setMajor(studentEntity.getMajor());
                studentPage.setGendar(studentEntity.getGendar());
                studentPage.setEmail(studentEntity.getEmail());
                /*BeanUtils.copyProperties(studentEntity, studentPage);*/
                studentPageList.add(studentPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return studentPageList;
    }

    public StudentPage GetByColumn(String column, String key) {
        Session session1 = HibernateUtils.getSession();
        Session session = HibernateUtils.getSession();
        String hql = "from StudentEntity where "+ column +" = "+"'"+ key+"'";
        List<StudentEntity> s=session.createQuery(hql).list();
        StudentPage studentPage = null;
        if(!s.isEmpty())
        {
            studentPage=new StudentPage();
            studentPage.setId(s.get(0).getId());
            studentPage.setGrade(s.get(0).getGrade());
            studentPage.setBirthday(s.get(0).getBirthday());
            studentPage.setUsername(s.get(0).getUsername());
            studentPage.setStatus(s.get(0).getStatus());
            studentPage.setPassword(s.get(0).getPassword());
            studentPage.setName(s.get(0).getName());
            studentPage.setMajor(s.get(0).getMajor());
            studentPage.setGendar(s.get(0).getGendar());
            studentPage.setEmail(s.get(0).getEmail());
        }



        return studentPage;
    }




}
