package org.babycat.testers.components;

import lombok.RequiredArgsConstructor;
import org.babycat.testers.components.interfaces.BasicComponent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginComponent implements BasicComponent {

    private static String UserName;
    private static String Password;
    private static String Email;

    /**
     * Well, this is still not working now.
     * */
    @Override
    public void Run() {

    }
}