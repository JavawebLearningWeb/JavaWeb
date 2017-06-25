package DAO;

import Entity.ProgressEntity;
import Entity.ProgressEntity;
import Page.ProgressPage;
import Page.ProgressPage;
import Util.HibernateUtils;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class ProgressDAO {
    public void Add(ProgressPage progressPage) {

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ProgressEntity progressEntity = new ProgressEntity();
            BeanUtils.copyProperties(progressPage, progressEntity);

            session.save(progressEntity);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Del(ProgressPage progressPage){

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ProgressEntity progressEntity=(ProgressEntity)session.load(ProgressEntity.class,progressPage.getId());
            session.delete(progressEntity);

            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Update(ProgressPage progressPage) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ProgressEntity progressEntity = (ProgressEntity) session.load(ProgressEntity.class, progressPage.getId());
            BeanUtils.copyProperties(progressPage, progressEntity);

            session.update(progressEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<ProgressPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<ProgressEntity> progressEntityList = session.createQuery("from ProgressEntity ").list();
        List<ProgressPage> progressPageList = new ArrayList<ProgressPage>();
        if (progressEntityList != null && progressEntityList.size() > 0) {
            for (ProgressEntity progressEntity : progressEntityList) {
                ProgressPage progressPage = new ProgressPage();
                BeanUtils.copyProperties(progressEntity, progressPage);
                progressPageList.add(progressPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return progressPageList;
    }

    public ProgressPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        ProgressPage progressPage = new ProgressPage();
        ProgressEntity progressEntity = (ProgressEntity) session.load(ProgressEntity.class,id);
        BeanUtils.copyProperties(progressEntity, progressPage);
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return progressPage;
    }

}
