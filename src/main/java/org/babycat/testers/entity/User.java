package org.babycat.testers.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class User {
    private Long Id;
    private String name;
}
