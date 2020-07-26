package app.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
public class H2Config {

    @Value("${hibernate.properties.dialect}")
    private String dialect;

    @Value("${hibernate.properties.showSQL}")
    private String showSQL;

    @Value("${hibernate.properties.formatSQL}")
    private String formatSQL;

    @Value("${spring.basePackage}")
    private String basePackage;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalSessionFactoryBean entityManagerFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props=new Properties();
        props.setProperty(Environment.DIALECT, dialect);
        props.setProperty(Environment.SHOW_SQL, showSQL);
        props.setProperty(Environment.FORMAT_SQL, formatSQL);
        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan(basePackage);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public Hibernate5Module datatypeHibernateModule() {
        return new Hibernate5Module();
    }

}
