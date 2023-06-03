package com.connection.database.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class UserDataDto {
    private int id;
    private String email;
    private String password;
}
