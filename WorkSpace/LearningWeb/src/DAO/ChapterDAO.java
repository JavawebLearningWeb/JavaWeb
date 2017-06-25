package DAO;

import Entity.ChapterEntity;
import Entity.ChapterEntity;
import Page.ChapterPage;
import Page.ChapterPage;
import Util.HibernateUtils;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79333 on 2017/6/24.
 */
public class ChapterDAO {
    public void Add(ChapterPage chapterPage) {

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ChapterEntity chapterEntity = new ChapterEntity();
            BeanUtils.copyProperties(chapterPage, chapterEntity);

            session.save(chapterEntity);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Del(ChapterPage chapterPage){

        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ChapterEntity chapterEntity=(ChapterEntity)session.load(ChapterEntity.class,chapterPage.getId());
            session.delete(chapterEntity);

            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void Update(ChapterPage chapterPage) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            ChapterEntity chapterEntity = (ChapterEntity) session.load(ChapterEntity.class, chapterPage.getId());
            BeanUtils.copyProperties(chapterPage, chapterEntity);

            session.update(chapterEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
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
                BeanUtils.copyProperties(chapterEntity, chapterPage);
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
        BeanUtils.copyProperties(chapterEntity, chapterPage);
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
        return chapterPage;
    }


}
