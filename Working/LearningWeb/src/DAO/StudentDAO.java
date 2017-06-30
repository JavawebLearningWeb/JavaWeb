package DAO;

import Entity.StudentEntity;
import Page.StudentPage;
import Util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class StudentDAO {

    public boolean IsOk(StudentPage studentPage){
        boolean flag = true;
        StudentDAO studentDAO = new StudentDAO();
        List<StudentPage> studentPageList = new ArrayList<>();
        studentPageList = studentDAO.GetAll();
        for(int i=0;i<studentPageList.size();i++){
            StudentPage s = new StudentPage();
            s = studentPageList.get(i);
            if(s.getUsername().equals(studentPage.getUsername()))
                return false;
        }
        return true;
    }

    public boolean Add(StudentPage studentPage) {
        boolean flag = false;
        Session session = null;
        StudentDAO studentDAO = new StudentDAO();
        if(!studentDAO.IsOk(studentPage))
            return flag;
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
            studentEntity.setPicture(studentPage.getPicture());
            /*BeanUtils.copyProperties(studentPage, studentEntity);*/

            session.save(studentEntity);
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

    public boolean Del(StudentPage studentPage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            StudentEntity studentEntity=(StudentEntity)session.load(StudentEntity.class,studentPage.getId());
            session.delete(studentEntity);

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

    public boolean Update(StudentPage studentPage) {
        boolean flag = false;
        Session session = null;
        StudentDAO studentDAO = new StudentDAO();
        if(!studentDAO.IsOk(studentPage))
            return flag;
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
            studentEntity.setPicture(studentPage.getPicture());
            session.update(studentEntity);
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
                studentPage.setPicture(studentEntity.getPicture());
                /*BeanUtils.copyProperties(studentEntity, studentPage);*/
                studentPageList.add(studentPage);
            }
        }
        HibernateUtils.closeSession(session);
        return studentPageList;
    }

    public StudentPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        StudentPage studentPage = new StudentPage();
        StudentEntity studentEntity = (StudentEntity) session.load(StudentEntity.class,id);
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
        studentPage.setPicture(studentEntity.getPicture());
        /*BeanUtils.copyProperties(studentEntity, studentPage);*/
        HibernateUtils.closeSession(session);
        return studentPage;
    }
/*
返回Page类 第一个参数是column的名称，第二个参数是column具体的值
 */
    public StudentPage GetByColumn(String column, String key) {

        Session session = HibernateUtils.getSession();
        String hql = "from StudentEntity where "+ column +" = "+ "'"+key+"'";
        List<StudentEntity> s=session.createQuery(hql).list();
        StudentPage studentPage = null;
        if(s.size()>0){
            studentPage = new StudentPage();
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
            studentPage.setPicture(s.get(0).getPicture());
        }
        HibernateUtils.closeSession(session);
            return studentPage;




    }

    /*
    返回List<Page>类（上面方法的重载） 第一个参数是column的名称，第二个参数是column具体的值
     */
    public List<StudentPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from StudentEntity where "+ column +" = "+ "'"+key+"'";
        List<StudentEntity> studentEntityList=session.createQuery(hql).list();
        List<StudentPage> studentPageList = new ArrayList();
        if (studentEntityList != null && studentEntityList.size() > 0){
            for(StudentEntity studentEntity : studentEntityList){
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
                studentPage.setPicture(studentEntity.getPicture());
                /*BeanUtils.copyProperties(studentEntity, studentPage);*/
                studentPageList.add(studentPage);
            }
        }
        HibernateUtils.closeSession(session);
        return studentPageList;
    }


}
