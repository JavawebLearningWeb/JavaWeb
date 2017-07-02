package DAO;

import Entity.ProgressEntity;
import Entity.ProgressEntity;
import Entity.ProgressEntity;
import Page.ProgressPage;
import Page.ProgressPage;
import Page.ProgressPage;
import Page.ProgressPage;
import Util.HibernateUtils;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class ProgressDAO {
    public boolean IsOk(ProgressPage progressPage){
        boolean flag = true;
        ProgressDAO progressDAO = new ProgressDAO();
        List<ProgressPage> progressPageList = new ArrayList<>();
        progressPageList = progressDAO.GetAll();
        for(int i=0;i<progressPageList.size();i++){
            ProgressPage s = new ProgressPage();
            s = progressPageList.get(i);
            if(s.getCourseid().equals(progressPage.getCourseid()))
                if(s.getStudentid().equals(progressPage.getStudentid()))
                    if(s.getChapterid().equals(progressPage.getChapterid()))
                        return false;
        }
        return true;
    }
    
    public boolean Add(ProgressPage progressPage) {
        if(!IsOk(progressPage))
            return false;
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ProgressEntity progressEntity = new ProgressEntity();
            progressEntity.setChapterid(progressPage.getChapterid());
            progressEntity.setCourseid(progressPage.getCourseid());
            progressEntity.setExamscore(progressPage.getExamscore());
            progressEntity.setStudentid(progressPage.getStudentid());
            /*BeanUtils.copyProperties(progressPage, progressEntity);*/

            session.save(progressEntity);
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

    public boolean Del(ProgressPage progressPage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ProgressEntity progressEntity=(ProgressEntity)session.load(ProgressEntity.class,progressPage.getId());
            session.delete(progressEntity);

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

    public boolean Update(ProgressPage progressPage) {
        if(!IsOk(progressPage))
            return false;
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ProgressEntity progressEntity = (ProgressEntity) session.load(ProgressEntity.class, progressPage.getId());
            progressEntity.setChapterid(progressPage.getChapterid());
            progressEntity.setCourseid(progressPage.getCourseid());
            progressEntity.setExamscore(progressPage.getExamscore());
            progressEntity.setStudentid(progressPage.getStudentid());
            /*BeanUtils.copyProperties(progressPage, progressEntity);*/

            session.update(progressEntity);
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

    public List<ProgressPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<ProgressEntity> progressEntityList = session.createQuery("from ProgressEntity ").list();
        List<ProgressPage> progressPageList = new ArrayList<ProgressPage>();
        if (progressEntityList != null && progressEntityList.size() > 0) {
            for (ProgressEntity progressEntity : progressEntityList) {
                ProgressPage progressPage = new ProgressPage();
                progressPage.setId(progressEntity.getId());
                progressPage.setChapterid(progressEntity.getChapterid());
                progressPage.setCourseid(progressEntity.getCourseid());
                progressPage.setExamscore(progressEntity.getExamscore());
                progressPage.setStudentid(progressEntity.getStudentid());
                /*BeanUtils.copyProperties(progressEntity, progressPage);*/
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
        progressPage.setId(progressEntity.getId());
        progressPage.setChapterid(progressEntity.getChapterid());
        progressPage.setCourseid(progressEntity.getCourseid());
        progressPage.setExamscore(progressEntity.getExamscore());
        progressPage.setStudentid(progressEntity.getStudentid());
        /*BeanUtils.copyProperties(progressEntity, progressPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return progressPage;
    }


    /*
  根据一列的某一属性值得到一条数据
   */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public ProgressPage GetByColumn(String column,String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from ProgressEntity where "+ column +" = "+ "'"+key+"'";
        List<ProgressEntity> s=session.createQuery(hql).list();
        ProgressPage progressPage = null;
        if(s.size()>0){
            progressPage = new ProgressPage();
            progressPage.setId(s.get(0).getId());
            progressPage.setChapterid(s.get(0).getChapterid());
            progressPage.setCourseid(s.get(0).getCourseid());
            progressPage.setExamscore(s.get(0).getExamscore());
            progressPage.setStudentid(s.get(0).getStudentid());
        }
        HibernateUtils.closeSession(session);
        return progressPage;
    }

    public ProgressPage GetByColumn(String column1, String key1,String column2 ,String key2) {
        Session session = HibernateUtils.getSession();
        String hql = "from ProgressEntity where "+ column1 +" = "+ "'"+key1+"' and"+ column2 + "='"+ key2 + "'";
        List<ProgressEntity> s=session.createQuery(hql).list();
        ProgressPage progressPage = null;
        if(s.size()>0){
            progressPage = new ProgressPage();
            progressPage.setId(s.get(0).getId());
            progressPage.setChapterid(s.get(0).getChapterid());
            progressPage.setCourseid(s.get(0).getCourseid());
            progressPage.setExamscore(s.get(0).getExamscore());
            progressPage.setStudentid(s.get(0).getStudentid());
        }
        HibernateUtils.closeSession(session);
        return progressPage;
    }

    /*
    根据一列的某一属性值得到很多条数据
     */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<ProgressPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from ProgressEntity where "+ column +" = "+ "'"+key+"'";
        List<ProgressEntity> progressEntityList=session.createQuery(hql).list();
        List<ProgressPage> progressPageList = new ArrayList();
        if (progressEntityList != null && progressEntityList.size() > 0){
            for(ProgressEntity progressEntity : progressEntityList){
                ProgressPage progressPage = new ProgressPage();
                progressPage.setId(progressEntity.getId());
                progressPage.setChapterid(progressEntity.getChapterid());
                progressPage.setCourseid(progressEntity.getCourseid());
                progressPage.setExamscore(progressEntity.getExamscore());
                progressPage.setStudentid(progressEntity.getStudentid());
                /*BeanUtils.copyProperties(progressEntity, progressPage);*/
                progressPageList.add(progressPage);
            }
        }
        HibernateUtils.closeSession(session);
        return progressPageList;
    }

    public List<ProgressPage> GetAllByColumn(String column1, String key1,String column2 ,String key2){
        Session session = HibernateUtils.getSession();
        String hql = "from ProgressEntity where "+ column1 +" = "+ "'"+key1+"' and "+ column2 + " = '"+ key2 + "'";
        List<ProgressEntity> progressEntityList=session.createQuery(hql).list();
        List<ProgressPage> progressPageList = new ArrayList();
        if (progressEntityList != null && progressEntityList.size() > 0){
            for(ProgressEntity progressEntity : progressEntityList){
                ProgressPage progressPage = new ProgressPage();
                progressPage.setId(progressEntity.getId());
                progressPage.setChapterid(progressEntity.getChapterid());
                progressPage.setCourseid(progressEntity.getCourseid());
                progressPage.setExamscore(progressEntity.getExamscore());
                progressPage.setStudentid(progressEntity.getStudentid());
                /*BeanUtils.copyProperties(progressEntity, progressPage);*/
                progressPageList.add(progressPage);
            }
        }
        HibernateUtils.closeSession(session);
        return progressPageList;
    }

}
