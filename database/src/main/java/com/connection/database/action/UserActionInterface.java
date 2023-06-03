package com.connection.database.action;

import com.connection.database.db.entity.UserEntity;

import java.util.Optional;

public interface UserActionInterface {

    void save(UserEntity userEntity);

    void deleteUsersByEmail(String email);

    Optional<UserEntity> getUsersById(Long id);

    UserEntity functionValidDataUpdateUser(UserEntity userEntity);
}
