package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableDiscoveryClient
@SpringBootApplication (exclude = {HibernateJpaAutoConfiguration.class, GsonAutoConfiguration.class, SolrAutoConfiguration.class})
@EnableJpaRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
