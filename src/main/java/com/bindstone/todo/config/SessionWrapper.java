package com.bindstone.todo.config;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.ibatis.session.SqlSession;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class SessionWrapper {
    /**
    @Inject
    SessionFactoryWrapper factory;

    @Resource (mappedName="java:/jdbc/datasources/todoDS")
    DataSource ds;

    public <T> T selectOne(String statement) {
        try {
            SqlSession s = factory.getSession(ds.getConnection());
            T result = s.selectOne(statement);
            s.close();
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public <T> List<T> selectList(String statement) {
        try {
            SqlSession s = factory.getSession(ds.getConnection());
            List<T> result = s.selectList(statement);
            s.close();
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    **/
}