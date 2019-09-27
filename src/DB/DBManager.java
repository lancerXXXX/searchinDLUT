package DB;

import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    /**
     * 获得Connection对象
     * @return
     */
    public static Connection getConn(){
        Connection connection=null;
        try {
            connection=DBPool.getPool().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭Connection
     * @param connection
     */
    public static void close(Connection connection){
        if (null!=connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
