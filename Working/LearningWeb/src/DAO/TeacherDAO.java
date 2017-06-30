package DAO;

import Entity.TeacherEntity;
import Entity.TeacherEntity;
import Page.TeacherPage;
import Page.TeacherPage;
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
    public boolean IsOk(TeacherPage teacherPage){
        boolean flag = true;
        TeacherDAO teacherDAO = new TeacherDAO();
        List<TeacherPage> teacherPageList = new ArrayList<>();
        teacherPageList = teacherDAO.GetAll();
        for(int i=0;i<teacherPageList.size();i++){
            TeacherPage s = new TeacherPage();
            s = teacherPageList.get(i);
            if(s.getUsername().equals(teacherPage.getUsername()))
                return false;
        }
        return true;
    }


    
    public boolean Add(TeacherPage teacherPage) {

        TeacherDAO teacherDAO = new TeacherDAO();
        if(!teacherDAO.IsOk(teacherPage))
            return false;
        boolean flag = false;
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
            teacherEntity.setPicture(teacherPage.getPicture());
            teacherEntity.setIntroduction(teacherPage.getIntroduction());
            /*BeanUtils.copyProperties(teacherPage, teacherEntity);*/

            session.save(teacherEntity);
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

    public boolean Del(TeacherPage teacherPage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            TeacherEntity teacherEntity=(TeacherEntity)session.load(TeacherEntity.class,teacherPage.getId());
            session.delete(teacherEntity);

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

    public boolean Update(TeacherPage teacherPage) {
        TeacherDAO teacherDAO = new TeacherDAO();
        if(!teacherDAO.IsOk(teacherPage))
            return false;
        boolean flag = false;
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
            teacherEntity.setPicture(teacherPage.getPicture());
            teacherEntity.setIntroduction(teacherPage.getIntroduction());
            session.update(teacherEntity);
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
                teacherPage.setPicture(teacherEntity.getPicture());
                teacherPage.setIntroduction(teacherEntity.getIntroduction());
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
        teacherPage.setPicture(teacherEntity.getPicture());
        teacherPage.setIntroduction(teacherEntity.getIntroduction());
        /*BeanUtils.copyProperties(teacherEntity, teacherPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return teacherPage;
    }

    /*
返回Page类 第一个参数是column的名称，第二个参数是column具体的值
 */
    public TeacherPage GetByColumn(String column, String key) {

        Session session = HibernateUtils.getSession();
        String hql = "from TeacherEntity where "+ column +" = "+ "'"+key+"'";
        List<TeacherEntity> s=session.createQuery(hql).list();
        TeacherPage teacherPage = null;
        if(s.size()>0){
            teacherPage = new TeacherPage();
            teacherPage.setId(s.get(0).getId());
            teacherPage.setUsername(s.get(0).getUsername());
            teacherPage.setStatus(s.get(0).getStatus());
            teacherPage.setPassword(s.get(0).getPassword());
            teacherPage.setName(s.get(0).getName());
            teacherPage.setMajor(s.get(0).getMajor());
            teacherPage.setEmail(s.get(0).getEmail());
            teacherPage.setGender(s.get(0).getGender());
            teacherPage.setPicture(s.get(0).getPicture());
            teacherPage.setIntroduction(s.get(0).getIntroduction());
        }
        HibernateUtils.closeSession(session);
        return teacherPage;

    }

    /*
    返回List<Page>类（上面方法的重载） 第一个参数是column的名称，第二个参数是column具体的值
     */
    public List<TeacherPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from TeacherEntity where "+ column +" = "+ "'"+key+"'";
        List<TeacherEntity> teacherEntityList=session.createQuery(hql).list();
        List<TeacherPage> teacherPageList = new ArrayList();
        if (teacherEntityList != null && teacherEntityList.size() > 0){
            for(TeacherEntity teacherEntity : teacherEntityList){
                TeacherPage teacherPage = new TeacherPage();
                teacherPage.setId(teacherEntity.getId());
                teacherPage.setUsername(teacherEntity.getUsername());
                teacherPage.setStatus(teacherEntity.getStatus());
                teacherPage.setPassword(teacherEntity.getPassword());
                teacherPage.setName(teacherEntity.getName());
                teacherPage.setMajor(teacherEntity.getMajor());
                teacherPage.setGender(teacherEntity.getGender());
                teacherPage.setEmail(teacherEntity.getEmail());
                teacherPage.setPicture(teacherEntity.getPicture());
                teacherPage.setIntroduction(teacherEntity.getIntroduction());
                /*BeanUtils.copyProperties(teacherEntity, teacherPage);*/
                teacherPageList.add(teacherPage);
            }
        }
        HibernateUtils.closeSession(session);
        return teacherPageList;
    }

}
