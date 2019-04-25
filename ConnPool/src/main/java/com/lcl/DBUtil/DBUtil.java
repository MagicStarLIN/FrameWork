package com.lcl.DBUtil;

import com.lcl.connpool.ConnPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static ConnPool connPool = new ConnPool();

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection GetConnection() throws SQLException {
        return connPool.getConnection();
    }

    /**
     * 关闭连接
     * @param connection
     * @param st
     * @param rs
     * @throws SQLException
     */
    public static void close(Connection connection, Statement st, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (connection != null) {
            connection.close();
        }

    }
}
