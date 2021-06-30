package com.whpu.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.whpu.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    //操作数据的类，封装了增删改查操作 需要数据源参数
    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    @Override
    public User login(String name, String pwd) throws SQLException { //异常：抛出后，由调用者处理异常
        // ?表占位符
        String sql = "SELECT * FROM USER WHERE username = ? AND PASSWORD = ?";

        User user = qr.query(sql, new BeanHandler<User>(User.class), name, pwd);
        return user;
    }

    @Override
    public Boolean add(String name, String pwd, String phone, int status) throws SQLException {

        String sql = "INSERT INTO USER(username,PASSWORD)\n" +
            "     VALUE('阿布','123')";
        qr.query(sql, new BeanHandler<User>(User.class), name, pwd, phone, status);
        return true;
    }
}
