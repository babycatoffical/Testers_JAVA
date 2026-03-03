package org.babycat.testers.components.configs;

import org.babycat.testers.components.LoginComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MasterConfig {
    /**
     * This component is untitled and still not working.
     * */


    @Bean(name = "inComponent")
    public LoginComponent getUntitledClassOne() {
        return new LoginComponent();
    }




}