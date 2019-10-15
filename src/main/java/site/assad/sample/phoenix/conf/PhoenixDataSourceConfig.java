package site.assad.sample.phoenix.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 配置 phoenix 数据源
 * @author Al-assad
 * @since 2019/10/15
 */

@Configuration
@MapperScan(basePackages = "site.assad.sample.phoenix.mapper", sqlSessionTemplateRef = "phoenixSqlSessionTemplate")
public class PhoenixDataSourceConfig {
    
    @Bean(name = "phoenixDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.phoenix")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "phoenixSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("phoenixDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    
    @Bean(name = "phoenixSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("phoenixSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean(name = "phoenixTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("phoenixDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    
}
