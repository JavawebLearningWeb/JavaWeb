package DAO;

import Entity.LearnEntity;
import Page.LearnPage;
import Page.TeacherPage;
import Util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/29.
 */
public class LearnDAO {

    public boolean IsOk(LearnPage learnPage){
        boolean flag = true;
        LearnDAO learnDAO = new LearnDAO();
        List<LearnPage> learnPageList = new ArrayList<>();
        learnPageList = learnDAO.GetAll();
        for(int i=0;i<learnPageList.size();i++){
            LearnPage s = new LearnPage();
            s = learnPageList.get(i);
            if(s.getCourseid().equals(learnPage.getCourseid())&&s.getStudentid().equals(learnPage.getStudentid()))
                return false;
        }
        return true;
    }

    public boolean Add(LearnPage learnPage) {
        if(!IsOk(learnPage))
            return false;
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            LearnEntity learnEntity = new LearnEntity();

            learnEntity.setCourseid(learnPage.getCourseid());

            learnEntity.setStudentid(learnPage.getStudentid());
            /*BeanUtils.copyProperties(learnPage, learnEntity);*/

            session.save(learnEntity);
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

    public boolean Del(LearnPage learnPage){

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            LearnEntity learnEntity=(LearnEntity)session.load(LearnEntity.class,learnPage.getId());
            session.delete(learnEntity);

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

    public boolean Update(LearnPage learnPage) {
        if(!IsOk(learnPage))
            return false;
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            LearnEntity learnEntity = (LearnEntity) session.load(LearnEntity.class, learnPage.getId());

            learnEntity.setCourseid(learnPage.getCourseid());

            learnEntity.setStudentid(learnPage.getStudentid());
            /*BeanUtils.copyProperties(learnPage, learnEntity);*/

            session.update(learnEntity);
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

    public List<LearnPage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<LearnEntity> learnEntityList = session.createQuery("from LearnEntity ").list();
        List<LearnPage> learnPageList = new ArrayList<LearnPage>();
        if (learnEntityList != null && learnEntityList.size() > 0) {
            for (LearnEntity learnEntity : learnEntityList) {
                LearnPage learnPage = new LearnPage();
                learnPage.setId(learnEntity.getId());

                learnPage.setCourseid(learnEntity.getCourseid());

                learnPage.setStudentid(learnEntity.getStudentid());
                /*BeanUtils.copyProperties(learnEntity, learnPage);*/
                learnPageList.add(learnPage);
            }
        }
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return learnPageList;
    }

    public LearnPage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        LearnPage learnPage = new LearnPage();
        LearnEntity learnEntity = (LearnEntity) session.load(LearnEntity.class,id);
        learnPage.setId(learnEntity.getId());

        learnPage.setCourseid(learnEntity.getCourseid());

        learnPage.setStudentid(learnEntity.getStudentid());
        /*BeanUtils.copyProperties(learnEntity, learnPage);*/
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return learnPage;
    }


    /*
  根据一列的某一属性值得到一条数据
   */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public LearnPage GetByColumn(String column,String key) {
        Session session = HibernateUtils.getSession();
        String hql = "from LearnEntity where "+ column +" = "+ "'"+key+"'";
        List<LearnEntity> s=session.createQuery(hql).list();
        LearnPage learnPage = null;
        if(s.size()>0){
            learnPage = new LearnPage();
            learnPage.setId(s.get(0).getId());

            learnPage.setCourseid(s.get(0).getCourseid());

            learnPage.setStudentid(s.get(0).getStudentid());
        }
        HibernateUtils.closeSession(session);
        return learnPage;
    }

    /*
  根据一列的某一属性值得到很多条数据
   */
    /*第一个参数是列的名称，第二个参数是列的值*/
    public List<LearnPage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from LearnEntity where "+ column +" = "+ "'"+key+"'";
        List<LearnEntity> learnEntityList=session.createQuery(hql).list();
        List<LearnPage> learnPageList = new ArrayList();
        if (learnEntityList != null && learnEntityList.size() > 0){
            for(LearnEntity learnEntity : learnEntityList){
                LearnPage learnPage = new LearnPage();
                learnPage.setId(learnEntity.getId());
                learnPage.setCourseid(learnEntity.getCourseid());
                learnPage.setStudentid(learnEntity.getStudentid());
                /*BeanUtils.copyProperties(learnEntity, learnPage);*/
                learnPageList.add(learnPage);
            }
        }
        HibernateUtils.closeSession(session);
        return learnPageList;
    }
}
