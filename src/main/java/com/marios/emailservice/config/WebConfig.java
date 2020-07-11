package com.marios.emailservice.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableEncryptableProperties
public class WebConfig implements WebMvcConfigurer {
    
//    @Autowired
//    private Environment env;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")
                .allowedOrigins("*");
    }
    
//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(env.getProperty("spring.mail.host"));
//        mailSender.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.mail.port"))));
//
//        mailSender.setUsername(env.getProperty("spring.mail.username"));
//        mailSender.setPassword(env.getProperty("spring.mail.password"));
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", env.getProperty("spring.mail.properties.mail.transport.protocol"));
//        props.put("mail.smtp.auth", env.getProperty("spring.mail.properties.mail.smtp.auth"));
//        props.put("mail.smtp.starttls.enable", env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
//        props.put("mail.debug", env.getProperty("spring.mail.properties.mail.debug"));
//
//        return mailSender;
//    }
}
