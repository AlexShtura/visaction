package com.teachmeskills.visaction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/europe").setViewName("country/europe");
        registry.addViewController("/asia").setViewName("country/asia");
        registry.addViewController("/america").setViewName("country/america");
        registry.addViewController("/africa").setViewName("country/africa");
        registry.addViewController("/oceania").setViewName("country/oceania");
        registry.addViewController("/login").setViewName("security/login");
        registry.addViewController("/registration").setViewName("security/registration");

        registry.addViewController("/profile").setViewName("user/profile");
        registry.addViewController("/list-of-users/edit-user/{Id}").setViewName("user/edit-profile");

        registry.addViewController("/list-of-users").setViewName("admin/list-of-users");
        registry.addViewController("/list-of-users/edit-user/{Id}").setViewName("admin/edit-user");

        registry.addViewController("/list-of-countries").setViewName("country/list-of-countries");
        registry.addViewController("/list-of-countries/new-country").setViewName("country/new-country");
        registry.addViewController("/list-of-countries/edit-country/{Id}").setViewName("country/edit-country");
        registry.addViewController("/list-of-countries/delete-country/{Id}").setViewName("country/delete-country");

        registry.addViewController("/list-of-messages").setViewName("country/list-of-countries");
        registry.addViewController("/contact/new-message").setViewName("new-message");
        registry.addViewController("/list-of-countries/edit-country/{Id}").setViewName("country/edit-country");
        registry.addViewController("/list-of-countries/delete-country/{Id}").setViewName("country/delete-country");
        registry.addViewController("/403").setViewName("error/403");
    }
}
