# spring-phoenix-mybatis-sample

Apache Phoenix5.0.0 + mybatis + spring 的示例代码



### 各组件版本

- Spring-Boot： 2.1.5.RELEASE
- Apache Phoenix：5.0.0
- Hadoop：2.7.4



### 数据源配置说明

数据源使用了 Spring-Boot 默认的 `HikariDataSource` ，主要工作在于对 `phoenix` 配置一个数据源，并将该数据源关联到 `SqlSessionTemplate` 的一个单例上。

这部分的代码如下：

```java
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
```



### 