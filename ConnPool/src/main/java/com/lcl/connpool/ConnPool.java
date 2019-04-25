package com.lcl.connpool;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 数据库连接池
 */
public class ConnPool implements DataSource {
    //使用linkedliset存放connection连接
    private static LinkedList<Connection> connpool = new LinkedList<Connection>();
    /**
     *     在静态代码块中解析加载配置文件db.properties
     *     加载驱动
     *     创建连接
     */
    static {
        //创建流读取配置文件
        InputStream in = ConnPool.class.getClassLoader().getResourceAsStream("db.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            String Driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String username = prop.getProperty("user");
            String password = prop.getProperty("password");
            //数据库连接初始化数量大小：15
            int InitSize = Integer.parseInt(prop.getProperty("InitSize"));
            //加载驱动创建连接
            Class.forName(Driver);

            for (int i = 0; i < InitSize; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                //添加至LinkedList
                System.out.println("已经创建了第"+(i+1)+"个连接");
                connpool.add(connection);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接
     */
    public Connection getConnection() throws SQLException{
        if (connpool.size() > 0) {
            final Connection conn = connpool.removeFirst();
            System.out.println("拿走了一个链接还剩下"+ connpool.size());
            return (Connection) Proxy.newProxyInstance(ConnPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                    if(!"close".equals(method.getName())){
                        return method.invoke(conn, args);
                    }else{
                        connpool.add(conn);
                        System.out.println("关闭连接，实际还给了连接池");
                        System.out.println("池中连接数为 " + connpool.size());
                        return null;
                    }
                }
            });

        } else {
            throw new RuntimeException("服务器繁忙");
        }
    }








    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

