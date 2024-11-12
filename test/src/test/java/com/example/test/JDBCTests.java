package com.example.test;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
public class JDBCTests {


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testSqlSessionAndConnection() throws SQLException {
        SqlSession session = null;
        Connection connection = null;

        try {
            // SqlSession 생성
            session = sqlSessionFactory.openSession();
            // DataSource로부터 Connection을 얻음
            connection = DataSourceUtils.getConnection(dataSource);

            // 로그 찍기
            log.info("SqlSession: " + session);
            log.info("Connection: " + connection);

            // 커넥션이 정상적으로 연결되었는지 확인
            assertNotNull(session);
            assertNotNull(connection);

        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
