import DAO.LearnDAO;
import DAO.RelationDAO;
import Page.LearnPage;
import Page.RelationPage;
import Util.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ycbhci on 2017/6/26.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {


        RelationDAO relationDAO=new RelationDAO();
        ArrayList<RelationPage> list= (ArrayList<RelationPage>) relationDAO.GetAllByColumn("frontcourseid","2");
        if (list.size()==0)
        {
            System.out.print("空操作");
        }
        System.out.print("nihao");
        LearnDAO learnDAO=new LearnDAO();
        ArrayList<LearnPage> learnPages= (ArrayList<LearnPage>) learnDAO.GetAllByColumn("studentid","1");
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}