package pl.JerzyGajewski.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@ComponentScan("pl.JerzyGajewski")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
@Bean
public LocalEntityManagerFactoryBean entityManagerFactory(){
LocalEntityManagerFactoryBean localEntityManagerFactoryBean =new LocalEntityManagerFactoryBean();
localEntityManagerFactoryBean.setPersistenceUnitName("test");
return localEntityManagerFactoryBean;
}

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager =
                new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }
}
