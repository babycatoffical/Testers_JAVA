package org.babycat.testers.logger.config;

import org.babycat.testers.logger.DLogger;
import org.babycat.testers.logger.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LogConfiguration {
    @Bean("log")
    public Logger logger() {
        return new Logger();
    }

    @Bean("DebugLog")
    public DLogger dLogger() {
        return new DLogger();
    }
}
