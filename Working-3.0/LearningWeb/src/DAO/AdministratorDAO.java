package DAO;

import Entity.AdministratorEntity;
import Entity.AdministratorEntity;
import Entity.AdministratorEntity;
import Page.AdministratorPage;
import Page.AdministratorPage;
import Util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class AdministratorDAO{
    /*
    增加
     */
    public boolean Add(AdministratorPage administratorPage) {

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AdministratorEntity administratorEntity = new AdministratorEntity();

            administratorEntity.setUsername(administratorPage.getUsername());
            administratorEntity.setPassword(administratorPage.getPassword());

            /*BeanUtils.copyProperties(administratorPage, administratorEntity);*/

            session.save(administratorEntity);
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
/*
删除
 */
    public boolean Del(AdministratorPage administratorPage){

        Session session = null;
        boolean flag = false;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AdministratorEntity administratorEntity=(AdministratorEntity)session.load(AdministratorEntity.class,administratorPage.getId());
            session.delete(administratorEntity);

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
/*
更改
 */
    public boolean Update(AdministratorPage administratorPage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AdministratorEntity administratorEntity = (AdministratorEntity) session.load(AdministratorEntity.class, administratorPage.getId());

            administratorEntity.setUsername(administratorPage.getUsername());
            administratorEntity.setPassword(administratorPage.getPassword());
            /*BeanUtils.copyProperties(administratorPage, administratorEntity);*/

            session.update(administratorEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            flag = false;
        } finally {
            HibernateUtils.closeSession(session);
        }
        return flag;
    }
/*
获取表中所有信息
 */
    public List<AdministratorPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<AdministratorEntity> administratorEntityList = session.createQuery("from AdministratorEntity ").list();
        List<AdministratorPage> administratorPageList = new ArrayList<AdministratorPage>();
        if (administratorEntityList != null && administratorEntityList.size() > 0) {
            for (AdministratorEntity administratorEntity : administratorEntityList) {
                AdministratorPage administratorPage = new AdministratorPage();
                administratorPage.setId(administratorEntity.getId());
                administratorPage.setUsername(administratorEntity.getUsername());
                administratorPage.setPassword(administratorEntity.getPassword());
                /*BeanUtils.copyProperties(administratorEntity, administratorPage);*/

                administratorPageList.add(administratorPage);
            }
        }

        HibernateUtils.closeSession(session);
        return administratorPageList;
    }
/*
根据主键获得表中一条数据
 */
    public AdministratorPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        AdministratorPage administratorPage = new AdministratorPage();
        AdministratorEntity administratorEntity = (AdministratorEntity) session.load(AdministratorEntity.class,id);
        administratorPage.setId(administratorEntity.getId());
        administratorPage.setUsername(administratorEntity.getUsername());
        administratorPage.setPassword(administratorEntity.getPassword());
        /*BeanUtils.copyProperties(administratorEntity, administratorPage);*/


        HibernateUtils.closeSession(session);
        return administratorPage;
    }
    /*
    根据一列的某一属性值得到一条数据
     */
               /*第一个参数是列的名称，第二个参数是列的值*/
    public AdministratorPage GetByColumn(String column,String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from AdministratorEntity where "+ column +" = "+ "'"+key+"'";
        List<AdministratorEntity> s=session.createQuery(hql).list();
        AdministratorPage administratorPage = null;
        if(s.size()>0){
            administratorPage = new AdministratorPage();
            administratorPage.setId(s.get(0).getId());
            administratorPage.setPassword(s.get(0).getPassword());
            administratorPage.setUsername(s.get(0).getUsername());
        }
        HibernateUtils.closeSession(session);
        return administratorPage;
    }
    /*
    根据一列的某一属性值得到很多条数据
     */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<AdministratorPage> GetAllByColumn(String column,String key){
        Session session = HibernateUtils.getSession();
        String hql = "from AdministratorEntity where "+ column +" = "+ "'"+key+"'";
        List<AdministratorEntity> administratorEntityList=session.createQuery(hql).list();
        List<AdministratorPage> administratorPageList = new ArrayList();
        if (administratorEntityList != null && administratorEntityList.size() > 0){
            for(AdministratorEntity administratorEntity : administratorEntityList){
                AdministratorPage administratorPage = new AdministratorPage();
                administratorPage.setId(administratorEntity.getId());
                administratorPage.setUsername(administratorEntity.getUsername());
                administratorPage.setPassword(administratorEntity.getPassword());
                /*BeanUtils.copyProperties(administratorEntity, administratorPage);*/
                administratorPageList.add(administratorPage);
            }
        }
        HibernateUtils.closeSession(session);
        return administratorPageList;
    }


}
