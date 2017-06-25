package DAO;

import Entity.ExamEntity;
import Entity.ExamEntity;
import Page.ExamPage;
import Page.ExamPage;
import Util.HibernateUtils;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class ExamDAO  {
    public void Add(ExamPage examPage) {

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ExamEntity examEntity = new ExamEntity();
            BeanUtils.copyProperties(examPage, examEntity);

            session.save(examEntity);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Del(ExamPage examPage){

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ExamEntity examEntity=(ExamEntity)session.load(ExamEntity.class,examPage.getId());
            session.delete(examEntity);

            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Update(ExamPage examPage) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ExamEntity examEntity = (ExamEntity) session.load(ExamEntity.class, examPage.getId());
            BeanUtils.copyProperties(examPage, examEntity);

            session.update(examEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
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
                BeanUtils.copyProperties(examEntity, examPage);
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
        BeanUtils.copyProperties(examEntity, examPage);
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return examPage;
    }

}
