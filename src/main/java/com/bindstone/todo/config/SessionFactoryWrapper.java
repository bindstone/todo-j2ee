package com.bindstone.todo.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

@ApplicationScoped
public class SessionFactoryWrapper {

    private final SqlSessionFactory factory;

    public SessionFactoryWrapper() throws IOException {
        System.out.println("Creating Session Factory...");
        Reader reader = Resources.getResourceAsReader("META-INF/configuration.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(reader);
        System.out.println("Factory = " + factory);
    }

    public SqlSession getSession(Connection con) {
        return factory.openSession(con);
    }

}