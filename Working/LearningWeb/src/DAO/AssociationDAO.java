package DAO;

import Entity.AssociationEntity;
import Page.AssociationPage;
import Util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/29.
 */
public class AssociationDAO {
    public boolean Add(AssociationPage associationPage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AssociationEntity associationEntity = new AssociationEntity();

            associationEntity.setChapterid(associationPage.getChapterid());

            associationEntity.setProchapterid(associationPage.getProchapterid());
            /*BeanUtils.copyProperties(associationPage, associationEntity);*/

            session.save(associationEntity);
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

    public boolean Del(AssociationPage associationPage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AssociationEntity associationEntity=(AssociationEntity)session.load(AssociationEntity.class,associationPage.getId());
            session.delete(associationEntity);

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

    public boolean Update(AssociationPage associationPage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AssociationEntity associationEntity = (AssociationEntity) session.load(AssociationEntity.class, associationPage.getId());

            associationEntity.setChapterid(associationPage.getChapterid());
            associationEntity.setProchapterid(associationPage.getProchapterid());

            /*BeanUtils.copyProperties(associationPage, associationEntity);*/

            session.update(associationEntity);
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

    public List<AssociationPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<AssociationEntity> associationEntityList = session.createQuery("from AssociationEntity ").list();
        List<AssociationPage> associationPageList = new ArrayList<AssociationPage>();
        if (associationEntityList != null && associationEntityList.size() > 0) {
            for (AssociationEntity associationEntity : associationEntityList) {
                AssociationPage associationPage = new AssociationPage();
                associationPage.setId(associationEntity.getId());

                associationPage.setChapterid(associationEntity.getChapterid());
                associationPage.setProchapterid(associationEntity.getProchapterid());

                /*BeanUtils.copyProperties(associationEntity, associationPage);*/
                associationPageList.add(associationPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return associationPageList;
    }

    public AssociationPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        AssociationPage associationPage = new AssociationPage();
        AssociationEntity associationEntity = (AssociationEntity) session.load(AssociationEntity.class,id);
        associationPage.setId(associationEntity.getId());

        associationPage.setChapterid(associationEntity.getChapterid());
        associationPage.setProchapterid(associationEntity.getProchapterid());

        /*BeanUtils.copyProperties(associationEntity, associationPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return associationPage;
    }


    /*
  根据一列的某一属性值得到一条数据
   */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public AssociationPage GetByColumn(String column, String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from AssociationEntity where "+ column +" = "+ "'"+key+"'";
        List<AssociationEntity> s=session.createQuery(hql).list();
        AssociationPage associationPage = null;
        if(s.size()>0){
            associationPage = new AssociationPage();
            associationPage.setId(s.get(0).getId());

            associationPage.setChapterid(s.get(0).getChapterid());
            associationPage.setProchapterid(s.get(0).getProchapterid());

        }
        HibernateUtils.closeSession(session);
        return associationPage;
    }

    /*
  根据一列的某一属性值得到很多条数据
   */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<AssociationPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from AssociationEntity where "+ column +" = "+ "'"+key+"'";
        List<AssociationEntity> associationEntityList=session.createQuery(hql).list();
        List<AssociationPage> associationPageList = new ArrayList();
        if (associationEntityList != null && associationEntityList.size() > 0){
            for(AssociationEntity associationEntity : associationEntityList){
                AssociationPage associationPage = new AssociationPage();
                associationPage.setId(associationEntity.getId());
                associationPage.setChapterid(associationEntity.getChapterid());
                associationPage.setProchapterid(associationEntity.getProchapterid());
                /*BeanUtils.copyProperties(associationEntity, associationPage);*/
                associationPageList.add(associationPage);
            }
        }
        HibernateUtils.closeSession(session);
        return associationPageList;
    }
}
