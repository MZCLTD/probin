package com.mz.probin.config;

import com.mz.probin.constants.Constants;
import com.mz.probin.mfiles.web.rest.MFilesHttpComponentsRestTemplate;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by emmanuel on 7/13/16.
 */
@Configuration
@EnableTransactionManagement()
@ComponentScan(
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
        },
        basePackages = { "com.mz.probin" }
)
public class SpringRootConfig {

        @Bean(name = "dataSource")
        public DataSource dataSource() {
                BasicDataSource basicDataSource = new BasicDataSource();
                basicDataSource.setPassword("root");
                basicDataSource.setUsername("root");
                basicDataSource.setUrl("jdbc:mysql://localhost:3306/mfiles_db");
                basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
                basicDataSource.setInitialSize(2);
                basicDataSource.setMaxActive(5);
                basicDataSource.setRemoveAbandoned(true);

                return basicDataSource;
        }

        @Autowired
        @Bean(name = "sessionFactory")
        public SessionFactory sessionFactory(DataSource dataSource) {
                LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
                sessionFactoryBuilder.scanPackages("com.mz.probin.entities");
                sessionFactoryBuilder.addProperties(getHibernateProperties());

                return sessionFactoryBuilder.buildSessionFactory();
        }

        private Properties getHibernateProperties() {
                Properties properties = new Properties();
                //properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                properties.put("hibernate.hbm2ddl.auto", "update");
                return properties;
        }

        @Autowired
        @Bean(name = "transactionManager")
        public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
                return new HibernateTransactionManager(sessionFactory);
        }

        @Bean
        public MFilesHttpComponentsRestTemplate mFilesHttpComponentsRestTemplate() {
                return new MFilesHttpComponentsRestTemplate(Constants.HOST);
        }

}
