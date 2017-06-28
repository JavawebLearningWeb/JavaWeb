package DAO;

import Entity.ExamEntity;
import Entity.ExamEntity;
import Page.ExamPage;
import Page.ExamPage;
import Util.HibernateUtils;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class ExamDAO  {
    public boolean Add(ExamPage examPage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ExamEntity examEntity = new ExamEntity();
            examEntity.setAddress(examPage.getAddress());
            examEntity.setAnswer(examPage.getAnswer());
            examEntity.setChapterid(examPage.getChapterid());
            /*BeanUtils.copyProperties(examPage, examEntity);*/

            session.save(examEntity);
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

    public boolean Del(ExamPage examPage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ExamEntity examEntity=(ExamEntity)session.load(ExamEntity.class,examPage.getId());
            session.delete(examEntity);

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

    public boolean Update(ExamPage examPage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ExamEntity examEntity = (ExamEntity) session.load(ExamEntity.class, examPage.getId());
            examEntity.setAddress(examPage.getAddress());
            examEntity.setAnswer(examPage.getAnswer());
            examEntity.setChapterid(examPage.getChapterid());
            /*BeanUtils.copyProperties(examPage, examEntity);*/

            session.update(examEntity);
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

    public List<ExamPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<ExamEntity> examEntityList = session.createQuery("from ExamEntity ").list();
        List<ExamPage> examPageList = new ArrayList<ExamPage>();
        if (examEntityList != null && examEntityList.size() > 0) {
            for (ExamEntity examEntity : examEntityList) {
                ExamPage examPage = new ExamPage();
                examPage.setId(examEntity.getId());
                examPage.setAddress(examEntity.getAddress());
                examPage.setAnswer(examEntity.getAnswer());
                examPage.setChapterid(examEntity.getChapterid());
                /*BeanUtils.copyProperties(examEntity, examPage);*/
                examPageList.add(examPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return examPageList;
    }

    public ExamPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        ExamPage examPage = new ExamPage();
        ExamEntity examEntity = (ExamEntity) session.load(ExamEntity.class,id);
        examPage.setId(examEntity.getId());
        examPage.setAddress(examEntity.getAddress());
        examPage.setAnswer(examEntity.getAnswer());
        examPage.setChapterid(examEntity.getChapterid());
        /*BeanUtils.copyProperties(examEntity, examPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return examPage;
    }
    /*
  根据一列的某一属性值得到一条数据
   */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public ExamPage GetByColumn(String column,String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from ExamEntity where "+ column +" = "+ "'"+key+"'";
        List<ExamEntity> s=session.createQuery(hql).list();
        ExamPage examPage = null;
        if(s.size()>0){
            examPage = new ExamPage();
            examPage.setId(s.get(0).getId());
            examPage.setChapterid(s.get(0).getChapterid());
            examPage.setAddress(s.get(0).getAddress());
            examPage.setAnswer(s.get(0).getAnswer());
        }
        HibernateUtils.closeSession(session);
        return examPage;
    }


    /*
    根据一列的某一属性值得到很多条数据
     */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<ExamPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from ExamEntity where "+ column +" = "+ "'"+key+"'";
        List<ExamEntity> examEntityList=session.createQuery(hql).list();
        List<ExamPage> examPageList = new ArrayList();
        if (examEntityList != null && examEntityList.size() > 0){
            for(ExamEntity examEntity : examEntityList){
                ExamPage examPage = new ExamPage();
                examPage.setId(examEntity.getId());
                examPage.setChapterid(examEntity.getChapterid());
                examPage.setAnswer(examEntity.getAnswer());
                examPage.setAddress(examEntity.getAddress());
                /*BeanUtils.copyProperties(examEntity, examPage);*/
                examPageList.add(examPage);
            }
        }
        HibernateUtils.closeSession(session);
        return examPageList;
    }

}
