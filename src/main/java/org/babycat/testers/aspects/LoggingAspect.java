package org.babycat.testers.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;


import static org.babycat.testers.aspects.AspectMessage.*;

// I Don't like Project scanning. why? this is slow, very too slow.
// But I know. this is working in SATA HDD. :/
// But IntelliJ IDEA is a GOD :)
@Aspect
@Component
public class LoggingAspect {
    @Around(value = "execution(* org.babycat.testers.components.LoginComponent.Run(..))")
    public static Object LoginRunAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.printf(StartMessage(joinPoint.getSignature().getName(), "Around"));
        Object result = null;
        try {
            result = joinPoint.proceed();
        }
        catch (Exception e) {
            System.err.println(ErrorMessage(joinPoint.getSignature().getName(), e.getMessage(), e.getCause(), "Around"));
        }
        finally {
            System.out.println(CompleteMessage(joinPoint.getSignature().getName(), "Around"));
        }
        return result;
    }
}
