package org.babycat.testers.components.interfaces;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.scheduling.config.Task;

public interface BasicComponent {
    void Run();

    default Task RunInThread() {
        throw new NotImplementedException("I'm sorry. this Class is not support \"RunInThread\" Method.");
    }
}
