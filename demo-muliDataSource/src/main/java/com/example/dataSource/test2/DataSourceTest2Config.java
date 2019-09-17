package com.example.dataSource.test2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.dataSource.test2.dao",sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DataSourceTest2Config {
    /**
     * 配置数据源
     * @return
     */
    @Bean("dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     *配置sqlSession的工厂
     * @param dataSource
     * @return
     */
    @Bean("sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return  sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean("dataSourceTransactionManager2")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource2") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
