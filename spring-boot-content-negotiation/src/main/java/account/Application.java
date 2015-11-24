package account;

import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Configuration
    static class WebConfig extends WebMvcConfigurerAdapter {

        @Autowired
        private ThymeleafViewResolver thymeleafViewResolver;

        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
            registry.viewResolver(this.thymeleafViewResolver);
            registry.enableContentNegotiation(new MappingJackson2JsonView());
        }
    }

}
