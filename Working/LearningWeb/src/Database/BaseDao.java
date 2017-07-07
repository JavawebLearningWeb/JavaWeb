package Database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by Administrator on 2017/6/27.
 */
public class BaseDao {
    DataSource dataSource;
    public BaseDao(){
        try {
            Context context=new InitialContext();
            dataSource=(DataSource) context.lookup("java:comp/env/jdbc/learningweb");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Exception:"+e);
        }
    }
    public Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }
}
