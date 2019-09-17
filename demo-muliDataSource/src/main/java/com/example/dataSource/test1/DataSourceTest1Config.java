package com.example.dataSource.test1;

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
@MapperScan(basePackages = "com.example.dataSource.test1.dao",sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSourceTest1Config {
    /**
     * 配置数据源
     * @return
     */
    @Bean("dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     *配置sqlSession的工厂
     * @param dataSource
     * @return
     */
    @Bean("sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return  sqlSessionFactoryBean.getObject();
    }

    /**
     *sqlSession工具类
     * @param sqlSessionFactory
     * @return
     */
    @Bean("sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean("dataSourceTransactionManager1")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource1") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
