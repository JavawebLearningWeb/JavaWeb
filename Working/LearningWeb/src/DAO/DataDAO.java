package DAO;

import Entity.DataEntity;
import Entity.DataEntity;
import Entity.DataEntity;
import Page.DataPage;
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
    public boolean Add(DataPage dataPage) {
        boolean flag = false;
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

    public boolean Del(DataPage dataPage){
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            DataEntity dataEntity=(DataEntity)session.load(DataEntity.class,dataPage.getId());
            session.delete(dataEntity);

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

    public boolean Update(DataPage dataPage) {
        boolean flag = false;
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

    /*
    根据一列的某一属性值得到一条数据
     */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public DataPage GetByColumn(String column,String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from DataEntity where "+ column +" = "+ "'"+key+"'";
        List<DataEntity> s=session.createQuery(hql).list();
        DataPage dataPage = null;
        if(s.size()>0){
            dataPage = new DataPage();
            dataPage.setId(s.get(0).getId());
            dataPage.setChapterid(s.get(0).getChapterid());
            dataPage.setAddress(s.get(0).getAddress());
            dataPage.setName(s.get(0).getName());
            dataPage.setKind(s.get(0).getKind());
        }
        HibernateUtils.closeSession(session);
        return dataPage;
    }


    /*
    根据一列的某一属性值得到很多条数据
     */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<DataPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from DataEntity where "+ column +" = "+ "'"+key+"'";
        List<DataEntity> dataEntityList=session.createQuery(hql).list();
        List<DataPage> dataPageList = new ArrayList();
        if (dataEntityList != null && dataEntityList.size() > 0){
            for(DataEntity dataEntity : dataEntityList){
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
        HibernateUtils.closeSession(session);
        return dataPageList;
    }

}
