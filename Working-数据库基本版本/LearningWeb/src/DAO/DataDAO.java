package DAO;

import Entity.DataEntity;
import Entity.DataEntity;
import Page.DataPage;
import Page.DataPage;
import Util.HibernateUtils;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class DataDAO  {
    public void Add(DataPage dataPage) {

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            DataEntity dataEntity = new DataEntity();
            dataEntity.setAddress(dataPage.getAddress());
            dataEntity.setChapterid(dataPage.getChapterid());
            dataEntity.setKind(dataPage.getKind());
            dataEntity.setName(dataPage.getName());
            /*BeanUtils.copyProperties(dataPage, dataEntity);*/

            session.save(dataEntity);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Del(DataPage dataPage){

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            DataEntity dataEntity=(DataEntity)session.load(DataEntity.class,dataPage.getId());
            session.delete(dataEntity);

            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Update(DataPage dataPage) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            DataEntity dataEntity = (DataEntity) session.load(DataEntity.class, dataPage.getId());
            dataEntity.setAddress(dataPage.getAddress());
            dataEntity.setChapterid(dataPage.getChapterid());
            dataEntity.setKind(dataPage.getKind());
            dataEntity.setName(dataPage.getName());
            /*BeanUtils.copyProperties(dataPage, dataEntity);*/

            session.update(dataEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<DataPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<DataEntity> dataEntityList = session.createQuery("from DataEntity ").list();
        List<DataPage> dataPageList = new ArrayList<DataPage>();
        if (dataEntityList != null && dataEntityList.size() > 0) {
            for (DataEntity dataEntity : dataEntityList) {
                DataPage dataPage = new DataPage();
                dataPage.setId(dataEntity.getId());
                dataPage.setAddress(dataEntity.getAddress());
                dataPage.setChapterid(dataEntity.getChapterid());
                dataPage.setKind(dataEntity.getKind());
                dataPage.setName(dataEntity.getName());
                /*BeanUtils.copyProperties(dataEntity, dataPage);*/
                dataPageList.add(dataPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return dataPageList;
    }

    public DataPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        DataEntity dataEntity = (DataEntity) session.load(DataEntity.class,id);
        DataPage dataPage = new DataPage();
        dataPage.setId(dataEntity.getId());
        dataPage.setAddress(dataEntity.getAddress());
        dataPage.setChapterid(dataEntity.getChapterid());
        dataPage.setKind(dataEntity.getKind());
        dataPage.setName(dataEntity.getName());
        /*BeanUtils.copyProperties(dataEntity, dataPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return dataPage;
    }

}
