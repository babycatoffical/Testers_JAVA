package org.babycat.testers.logger;

import static java.lang.management.ManagementFactory.getRuntimeMXBean;

/**
 * The Logger of a debugging platform system.
 * @author babycat_offical
 * @since 2026-03-02
 * @version 0.0.1
 * */
public class DLogger {
    boolean isDebug = getRuntimeMXBean().
            getInputArguments().toString().contains("jdwp");
}
