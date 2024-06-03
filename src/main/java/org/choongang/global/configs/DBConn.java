package org.choongang.global.configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBConn {
    private static SqlSessionFactory factory;
     static {
         try {
             String env = System.getenv("mode");
             env = env == null || !env.equals("prod") ? "dev" : env;
             System.out.println(env);
             Reader reader = Resources.getResourceAsReader("org/choongang/global/configs/mybatis-configs.xml");
            // factory = new SqlSessionFactoryBuilder().build(reader);
             factory = new SqlSessionFactoryBuilder().build(reader, env);

         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     public static SqlSession getSession(boolean autoCommit){
         return factory.openSession(autoCommit);
     }
     public static SqlSession getSession(){
         return getSession(true);
     }

}
