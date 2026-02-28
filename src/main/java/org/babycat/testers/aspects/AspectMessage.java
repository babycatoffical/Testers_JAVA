package org.babycat.testers.aspects;

import jakarta.annotation.Nullable;

import java.util.Objects;

public class AspectMessage {
    /**
     * Creates the Error message.
     * @param PointName The JoinPoint Name (joinPoint.getSignature.getName();)
     * @param Reason The Reason message
     * @param Cause The Cause message (It's Nullable.)
     * @param AOPType The AOP Type (It's Nullable.)
     * @return Returns an error message.
     * @author babycat_offical
     * @since 2026-02-27
     * */
    public static String ErrorMessage(
            String PointName,
            String Reason,
            @Nullable Throwable Cause,
            @Nullable String AOPType
    ) {

        return "*\n| [AOP.ERR] Component name: \"" +
                PointName + "\" run failure. \n| Details: " + Reason + "\n| Caused by:" +
                (!Objects.equals(Cause, null) ? Cause : "Unknown") + "\n| At " +
                (!Objects.equals(AOPType, null) ? AOPType : "Unknown")
                + "\n*";
    }

    /**
     * Creates Start Message
     * @param PointName the JoinPoint Name (joinpoint.getSignture.getName();)
     * @param AOPType The AOP Type (It's Nullable.)
     * @return Returns a start message.
     * @author babycat_offical
     * @since 2026-02-27
     * */
    public static String StartMessage(
            String PointName,
            @Nullable String AOPType
    ) {

        return "[AOP.LOG] Started Aspect component name: \""
                + PointName + "\" for " +
                (!Objects.equals(AOPType, null) ? AOPType : "Unknown");
    }

    /**
     * Returns Complete Message
     * @param PointName The JoinPoint Name (joinpoint.getSignture.getName();)
     * @param AOPType The AOP Type (It's Nullable.)
     * @return Returns Complete message.
     * @author babycat_offical
     * @since 2026-02-27
     * */
    public static String CompleteMessage(
            String PointName,
            @Nullable String AOPType
    ) {

        return "[AOP.LOG] Completed Aspect component name: \"" + PointName + "\" at " +
                (!Objects.equals(AOPType, null) ? AOPType : "Unknown");
    }


}
