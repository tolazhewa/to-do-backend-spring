package com.tolazhewa.todobackendspring.models;

import lombok.Builder;

@Builder
public class User {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
}
