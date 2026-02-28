package org.babycat.testers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDebuggersApplication {
    static void main(String[] args) {
        SpringApplication.run(SpringDebuggersApplication.class, args)
        .getBean(SpringDebuggersApplication.class).init();
    }

    private void init() {
        // ...Add some beans?
        // or delete this. I'm given a chance.
        // but you will delete .getBean data. ok? ;)
    }
}
