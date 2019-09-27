package DB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBPool {
    private static DataSource pool;
    static {
        Context env=null;
        try {
            env= (Context) new InitialContext().lookup("java:comp/env");
            pool= (DataSource) env.lookup("jdbc/information");
            if (pool==null){
                System.out.println("'DBPool' is an unknown DataSource");
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public static DataSource getPool(){
        return pool;
    }
}
