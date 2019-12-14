package be.steven.d.dog.recapjee.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * THIRD HAND APPLICATION
 *
 * @author d.Dog
 */
@SpringBootApplication
@EntityScan(basePackages = "be.steven.d.dog.recapjee.model")
@ComponentScan(basePackages = "be.steven.d.dog.recapjee.ctrl")
@EnableJpaRepositories(basePackages = "be.steven.d.dog.recapjee.repo")
public class RecapJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecapJeeApplication.class, args);
    }

    /**
     * @return Catches message source to be able to handle messages in Resource Bundle
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * @return Gets local validator factory bean to reveal validation error messages
     */
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
