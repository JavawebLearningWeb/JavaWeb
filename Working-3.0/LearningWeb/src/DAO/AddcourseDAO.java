package DAO;

import Entity.AddcourseEntity;
import Page.AddcoursePage;
import Util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/26.
 */
public class AddcourseDAO {
    public boolean Add(AddcoursePage addcoursePage) {

        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AddcourseEntity addcourseEntity = new AddcourseEntity();
            addcourseEntity.setResult(addcoursePage.getResult());
            addcourseEntity.setTeacherid(addcoursePage.getTeacherid());
            /*BeanUtils.copyProperties(addcoursePage, addcourseEntity);*/
            addcourseEntity.setCourse(addcoursePage.getCourse());

            session.save(addcourseEntity);
            session.getTransaction().commit();
            flag=true;
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            flag = false;
        }finally {
            HibernateUtils.closeSession(session);
        }
        return flag;
    }

    public boolean Del(AddcoursePage addcoursePage){
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AddcourseEntity addcourseEntity=(AddcourseEntity)session.load(AddcourseEntity.class,addcoursePage.getId());
            session.delete(addcourseEntity);

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

    public boolean Update(AddcoursePage addcoursePage) {
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            AddcourseEntity addcourseEntity = (AddcourseEntity) session.load(AddcourseEntity.class, addcoursePage.getId());
            addcourseEntity.setResult(addcoursePage.getResult());
            addcourseEntity.setTeacherid(addcoursePage.getTeacherid());
            /*BeanUtils.copyProperties(addcoursePage, addcourseEntity);*/
            addcourseEntity.setCourse(addcoursePage.getCourse());
            session.update(addcourseEntity);
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

    public List<AddcoursePage> GetAll(){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();

        List<AddcourseEntity> addcourseEntityList = session.createQuery("from AddcourseEntity ").list();
        List<AddcoursePage> addcoursePageList = new ArrayList<AddcoursePage>();
        if (addcourseEntityList != null && addcourseEntityList.size() > 0) {
            for (AddcourseEntity addcourseEntity : addcourseEntityList) {
                AddcoursePage addcoursePage = new AddcoursePage();
                addcoursePage.setId(addcourseEntity.getId());
                addcoursePage.setResult(addcourseEntity.getResult());
                addcoursePage.setTeacherid(addcourseEntity.getTeacherid());
                /*BeanUtils.copyProperties(addcourseEntity, addcoursePage);*/
                addcoursePage.setCourse(addcourseEntity.getCourse());
                addcoursePageList.add(addcoursePage);
            }
        }
        HibernateUtils.closeSession(session);
        return addcoursePageList;
    }

    public AddcoursePage GetById(String id){
        Session session = null;
        session = HibernateUtils.getSession();
        session.beginTransaction();
        AddcoursePage addcoursePage = new AddcoursePage();
        AddcourseEntity addcourseEntity = (AddcourseEntity) session.load(AddcourseEntity.class,id);
        addcoursePage.setId(addcourseEntity.getId());
        addcoursePage.setResult(addcourseEntity.getResult());
        addcoursePage.setTeacherid(addcourseEntity.getTeacherid());
        addcoursePage.setCourse(addcourseEntity.getCourse());
        /*BeanUtils.copyProperties(addcourseEntity, addcoursePage);*/
        HibernateUtils.closeSession(session);
        return addcoursePage;
    }
    /*
    返回Page类 第一个参数是column的名称，第二个参数是column具体的值
     */
    public AddcoursePage GetByColumn(String column, String key) {

        Session session = HibernateUtils.getSession();
        String hql = "from AddcourseEntity where "+ column +" = "+ "'"+key+"'";
        List<AddcourseEntity> s=session.createQuery(hql).list();
        AddcoursePage addcoursePage = null;
        if(s.size()>0){
            addcoursePage = new AddcoursePage();
            addcoursePage.setId(s.get(0).getId());
            addcoursePage.setResult(s.get(0).getResult());
            addcoursePage.setTeacherid(s.get(0).getTeacherid());
            addcoursePage.setCourse(s.get(0).getCourse());
        }
        HibernateUtils.closeSession(session);
        return addcoursePage;

    }

    /*
    返回List<Page>类（上面方法的重载） 第一个参数是column的名称，第二个参数是column具体的值
     */
    public List<AddcoursePage> GetAllByColumn(String column, String key){
        Session session = HibernateUtils.getSession();
        String hql = "from AddcourseEntity where "+ column +" = "+ "'"+key+"'";
        List<AddcourseEntity> addcourseEntityList=session.createQuery(hql).list();
        List<AddcoursePage> addcoursePageList = new ArrayList();
        if (addcourseEntityList != null && addcourseEntityList.size() > 0){
            for(AddcourseEntity addcourseEntity : addcourseEntityList){
                AddcoursePage addcoursePage = new AddcoursePage();
                addcoursePage.setId(addcourseEntity.getId());
                addcoursePage.setTeacherid(addcourseEntity.getTeacherid());
                addcoursePage.setResult(addcourseEntity.getResult());
                addcoursePage.setCourse(addcourseEntity.getCourse());
                /*BeanUtils.copyProperties(addcourseEntity, addcoursePage);*/
                addcoursePageList.add(addcoursePage);
            }
        }
        HibernateUtils.closeSession(session);
        return addcoursePageList;
    }
}
