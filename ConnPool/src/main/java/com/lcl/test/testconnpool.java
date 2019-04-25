package com.lcl.test;

import com.lcl.DBUtil.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class testconnpool {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.GetConnection();
        if (conn != null) {
            System.out.println("我特么拿了一个连接");
            DBUtil.close(conn,null,null);

        }
    }
}
