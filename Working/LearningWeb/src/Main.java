import DAO.LearnDAO;
import DAO.ProgressDAO;
import DAO.RelationDAO;
import Page.LearnPage;
import Page.ProgressPage;
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


        ProgressDAO progressDAO=new ProgressDAO();
        ProgressPage progressPage=new ProgressPage();
        progressPage.setChapterid("4");
        progressPage.setCourseid("1");
        progressPage.setExamscore(String.valueOf(100));
        progressPage.setStudentid("1");
        progressDAO.Add(progressPage);
    }
}