package DAO;

import Entity.AdministratorEntity;
import Entity.AdministratorEntity;
import Page.AdministratorPage;
import Util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class AdministratorDAO{
    public void Add(AdministratorPage administratorPage) {

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
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Del(AdministratorPage administratorPage){

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AdministratorEntity administratorEntity=(AdministratorEntity)session.load(AdministratorEntity.class,administratorPage.getId());
            session.delete(administratorEntity);

            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Update(AdministratorPage administratorPage) {
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
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

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
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return administratorPageList;
    }

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

        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return administratorPage;
    }





}
