package DAO;

import Entity.ChapterEntity;
import Entity.ChapterEntity;
import Entity.ChapterEntity;
import Page.ChapterPage;
import Page.ChapterPage;
import Page.ChapterPage;
import Util.HibernateUtils;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class ChapterDAO {
    public boolean Add(ChapterPage chapterPage) {

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ChapterEntity chapterEntity = new ChapterEntity();
            chapterEntity.setName(chapterPage.getName());
            chapterEntity.setCourseid(chapterPage.getCourseid());
            chapterEntity.setNumber(chapterPage.getNumber());
/*            BeanUtils.copyProperties(chapterPage, chapterEntity);*/

            session.save(chapterEntity);
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

    public boolean Del(ChapterPage chapterPage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ChapterEntity chapterEntity=(ChapterEntity)session.load(ChapterEntity.class,chapterPage.getId());
            session.delete(chapterEntity);

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

    public boolean Update(ChapterPage chapterPage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ChapterEntity chapterEntity = (ChapterEntity) session.load(ChapterEntity.class, chapterPage.getId());

            chapterEntity.setName(chapterPage.getName());
            chapterEntity.setCourseid(chapterPage.getCourseid());
            chapterEntity.setNumber(chapterPage.getNumber());
            /*BeanUtils.copyProperties(chapterPage, chapterEntity);*/

            session.update(chapterEntity);
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

    public List<ChapterPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<ChapterEntity> chapterEntityList = session.createQuery("from ChapterEntity ").list();
        List<ChapterPage> chapterPageList = new ArrayList<ChapterPage>();
        if (chapterEntityList != null && chapterEntityList.size() > 0) {
            for (ChapterEntity chapterEntity : chapterEntityList) {
                ChapterPage chapterPage = new ChapterPage();
                chapterPage.setId(chapterEntity.getId());
                chapterPage.setName(chapterEntity.getName());
                chapterPage.setCourseid(chapterEntity.getCourseid());
                chapterPage.setNumber(chapterEntity.getNumber());
                /*BeanUtils.copyProperties(chapterEntity, chapterPage);*/
                chapterPageList.add(chapterPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return chapterPageList;
    }

    public ChapterPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        ChapterPage chapterPage = new ChapterPage();
        ChapterEntity chapterEntity = (ChapterEntity) session.load(ChapterEntity.class,id);
        chapterPage.setId(chapterEntity.getId());
        chapterPage.setName(chapterEntity.getName());
        chapterPage.setCourseid(chapterEntity.getCourseid());
        chapterPage.setNumber(chapterEntity.getNumber());
        /*BeanUtils.copyProperties(chapterEntity, chapterPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return chapterPage;
    }
    
    
    /*
       根据一列的某一属性值得到一条数据
        */
               /*第一个参数是列的名称，第二个参数是列的值*/
    public ChapterPage GetByColumn(String column,String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from ChapterEntity where "+ column +" = "+ "'"+key+"'";
        List<ChapterEntity> s=session.createQuery(hql).list();
        ChapterPage chapterPage = null;
        if(s.size()>0){
            chapterPage = new ChapterPage();
            chapterPage.setId(s.get(0).getId());
            chapterPage.setName(s.get(0).getName());
            chapterPage.setCourseid(s.get(0).getCourseid());
            chapterPage.setNumber(s.get(0).getNumber());
        }
        HibernateUtils.closeSession(session);
        return chapterPage;
    }
    
    
    /*
    根据一列的某一属性值得到很多条数据
     */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<ChapterPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from ChapterEntity where "+ column +" = "+ "'"+key+"'";
        List<ChapterEntity> chapterEntityList=session.createQuery(hql).list();
        List<ChapterPage> chapterPageList = new ArrayList();
        if (chapterEntityList != null && chapterEntityList.size() > 0){
            for(ChapterEntity chapterEntity : chapterEntityList){
                ChapterPage chapterPage = new ChapterPage();
                chapterPage.setId(chapterEntity.getId());
                chapterPage.setName(chapterEntity.getName());
                chapterPage.setCourseid(chapterEntity.getCourseid());
                chapterPage.setNumber(chapterEntity.getNumber());
                /*BeanUtils.copyProperties(chapterEntity, chapterPage);*/
                chapterPageList.add(chapterPage);
            }
        }
        HibernateUtils.closeSession(session);
        return chapterPageList;
    }

}
