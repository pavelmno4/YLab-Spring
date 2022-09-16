package com.edu.ulab.app.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private final Long id;
    private String fullName;
    private String title;
    private int age;
}
