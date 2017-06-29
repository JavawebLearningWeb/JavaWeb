package DAO;

import Entity.RelationEntity;
import Page.RelationPage;
import Util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/29.
 */
public class RelationDAO {

    public boolean Add(RelationPage relationPage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            RelationEntity relationEntity = new RelationEntity();

            relationEntity.setCourseid(relationPage.getCourseid());

            relationEntity.setFrontcourseid(relationPage.getFrontcourseid());
            /*BeanUtils.copyProperties(relationPage, relationEntity);*/

            session.save(relationEntity);
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

    public boolean Del(RelationPage relationPage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            RelationEntity relationEntity=(RelationEntity)session.load(RelationEntity.class,relationPage.getId());
            session.delete(relationEntity);

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

    public boolean Update(RelationPage relationPage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            RelationEntity relationEntity = (RelationEntity) session.load(RelationEntity.class, relationPage.getId());

            relationEntity.setCourseid(relationPage.getCourseid());
            relationEntity.setFrontcourseid(relationPage.getFrontcourseid());

            /*BeanUtils.copyProperties(relationPage, relationEntity);*/

            session.update(relationEntity);
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

    public List<RelationPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<RelationEntity> relationEntityList = session.createQuery("from RelationEntity ").list();
        List<RelationPage> relationPageList = new ArrayList<RelationPage>();
        if (relationEntityList != null && relationEntityList.size() > 0) {
            for (RelationEntity relationEntity : relationEntityList) {
                RelationPage relationPage = new RelationPage();
                relationPage.setId(relationEntity.getId());

                relationPage.setCourseid(relationEntity.getCourseid());
                relationPage.setFrontcourseid(relationEntity.getFrontcourseid());

                /*BeanUtils.copyProperties(relationEntity, relationPage);*/
                relationPageList.add(relationPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return relationPageList;
    }

    public RelationPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        RelationPage relationPage = new RelationPage();
        RelationEntity relationEntity = (RelationEntity) session.load(RelationEntity.class,id);
        relationPage.setId(relationEntity.getId());

        relationPage.setCourseid(relationEntity.getCourseid());
        relationPage.setFrontcourseid(relationEntity.getFrontcourseid());

        /*BeanUtils.copyProperties(relationEntity, relationPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return relationPage;
    }


    /*
  根据一列的某一属性值得到一条数据
   */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public RelationPage GetByColumn(String column, String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from RelationEntity where "+ column +" = "+ "'"+key+"'";
        List<RelationEntity> s=session.createQuery(hql).list();
        RelationPage relationPage = null;
        if(s.size()>0){
            relationPage = new RelationPage();
            relationPage.setId(s.get(0).getId());

            relationPage.setCourseid(s.get(0).getCourseid());
            relationPage.setFrontcourseid(s.get(0).getFrontcourseid());

        }
        HibernateUtils.closeSession(session);
        return relationPage;
    }

    /*
  根据一列的某一属性值得到很多条数据
   */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<RelationPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from RelationEntity where "+ column +" = "+ "'"+key+"'";
        List<RelationEntity> relationEntityList=session.createQuery(hql).list();
        List<RelationPage> relationPageList = new ArrayList();
        if (relationEntityList != null && relationEntityList.size() > 0){
            for(RelationEntity relationEntity : relationEntityList){
                RelationPage relationPage = new RelationPage();
                relationPage.setId(relationEntity.getId());
                relationPage.setCourseid(relationEntity.getCourseid());
                relationPage.setFrontcourseid(relationEntity.getFrontcourseid());
                /*BeanUtils.copyProperties(relationEntity, relationPage);*/
                relationPageList.add(relationPage);
            }
        }
        HibernateUtils.closeSession(session);
        return relationPageList;
    }
}
