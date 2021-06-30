package com.whpu.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.whpu.entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    @Override
    public List<Student> selectAllStu() throws SQLException {
        String sql = "select * from student";
        return qr.query(sql,new BeanListHandler<Student>(Student.class));
    }

}
