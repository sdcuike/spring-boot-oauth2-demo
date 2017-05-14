package com.sdcuike.practice.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by beaver on 2017/4/11.
 */
@Configuration
public class DatasourceConfig {
    
    @Configuration
    @MapperScan(sqlSessionFactoryRef = "sqlSessionFactoryBeanTest",
            basePackages = "com.sdcuike.practice",
            annotationClass = UseDataSourceTest.class)
    public class TestDatasourceConfig {
        @Bean(name = "datasourceTest")
        @ConfigurationProperties(prefix = "datasource.test")
        public DataSource dataSourceTest() {
            return DataSourceBuilder.create().build();
        }
        
        @Bean(name = "txManagerTest")
        public PlatformTransactionManager txManagerTest() {
            return new DataSourceTransactionManager(dataSourceTest());
        }
        
        @Bean(name = "sqlSessionFactoryBeanTest")
        public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
            
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
            sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("/mybatis/mybatis-conf.xml"));
    
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
           
            sqlSessionFactoryBean
                    .setMapperLocations(resolver.getResources( "classpath*:/mybatis/mapper/**/*.xml"));
            
            sqlSessionFactoryBean.setDataSource(dataSourceTest());
            return sqlSessionFactoryBean.getObject();
        }
    }
    
    public @interface UseDataSourceTest {
    }
    
}
