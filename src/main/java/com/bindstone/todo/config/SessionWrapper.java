package com.bindstone.todo.config;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.ibatis.session.SqlSession;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class SessionWrapper {

    @Inject
    SessionFactoryWrapper factory;

    @Resource (mappedName="java:/jdbc/datasources/todoDS")
    DataSource ds;

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

    public <T> T selectOne(String statement, Map<String, Object> map) {
        try {
            SqlSession s = factory.getSession(ds.getConnection());
            T result = s.selectOne(statement, map);
            s.close();
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int insertOne(String statement, Object obj) {
        try {
            SqlSession s = factory.getSession(ds.getConnection());
            int result = s.insert(statement, obj);
            s.close();
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int updateOne(String statement, Object obj) {
        try {
            SqlSession s = factory.getSession(ds.getConnection());
            int result = s.update(statement, obj);
            s.close();
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int deleteOne(String statement, Object obj) {
        try {
            SqlSession s = factory.getSession(ds.getConnection());
            int result = s.delete(statement, obj);
            s.close();
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}