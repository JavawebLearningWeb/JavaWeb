package DAO;

import Entity.AddcourseEntity;
import Page.AddcoursePage;
import Page.CoursePage;
import Util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/26.
 */
public class AddcourseDAO {

    public boolean IsOk(AddcoursePage addcoursePage){
        boolean flag = true;
        CourseDAO courseDAO = new CourseDAO();
        AddcourseDAO addcourseDAO = new AddcourseDAO();
        List<CoursePage> coursePageList = new ArrayList<>();
        coursePageList = courseDAO.GetAll();
        for(int i=0;i<coursePageList.size();i++){
            CoursePage s = new CoursePage();
            s = coursePageList.get(i);
            if(s.getTeacherid().equals(addcoursePage.getTeacherid())&&s.getName().equals(addcoursePage.getCourse()))
                return false;
        }
        return true;
    }

    public boolean Add(AddcoursePage addcoursePage) {

        if(!IsOk(addcoursePage))
            return false;
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
            addcourseEntity.setPrecourseid1(addcoursePage.getPrecourseid1());
            addcourseEntity.setPrecourseid2(addcoursePage.getPrecourseid2());
            addcourseEntity.setPrecourseid3(addcoursePage.getPrecourseid3());
            addcourseEntity.setPrecourseid4(addcoursePage.getPrecourseid4());

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
        if(!IsOk(addcoursePage))
            return false;
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
            addcourseEntity.setPrecourseid1(addcoursePage.getPrecourseid1());
            addcourseEntity.setPrecourseid2(addcoursePage.getPrecourseid2());
            addcourseEntity.setPrecourseid3(addcoursePage.getPrecourseid3());
            addcourseEntity.setPrecourseid4(addcoursePage.getPrecourseid4());
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
                addcoursePage.setPrecourseid1(addcourseEntity.getPrecourseid1());
                addcoursePage.setPrecourseid2(addcourseEntity.getPrecourseid2());
                addcoursePage.setPrecourseid3(addcourseEntity.getPrecourseid3());
                addcoursePage.setPrecourseid4(addcourseEntity.getPrecourseid4());
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
        addcoursePage.setPrecourseid1(addcourseEntity.getPrecourseid1());
        addcoursePage.setPrecourseid2(addcourseEntity.getPrecourseid2());
        addcoursePage.setPrecourseid3(addcourseEntity.getPrecourseid3());
        addcoursePage.setPrecourseid4(addcourseEntity.getPrecourseid4());
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
            addcoursePage.setPrecourseid1(s.get(0).getPrecourseid1());
            addcoursePage.setPrecourseid2(s.get(0).getPrecourseid2());
            addcoursePage.setPrecourseid3(s.get(0).getPrecourseid3());
            addcoursePage.setPrecourseid4(s.get(0).getPrecourseid4());
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
                addcoursePage.setPrecourseid1(addcourseEntity.getPrecourseid1());
                addcoursePage.setPrecourseid2(addcourseEntity.getPrecourseid2());
                addcoursePage.setPrecourseid3(addcourseEntity.getPrecourseid3());
                addcoursePage.setPrecourseid4(addcourseEntity.getPrecourseid4());
                /*BeanUtils.copyProperties(addcourseEntity, addcoursePage);*/
                addcoursePageList.add(addcoursePage);
            }
        }
        HibernateUtils.closeSession(session);
        return addcoursePageList;
    }
}
