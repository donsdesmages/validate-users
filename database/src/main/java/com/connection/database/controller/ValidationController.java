package com.connection.database.controller;

import com.connection.database.action.UserAction;
import com.connection.database.db.entity.UserEntity;

import com.connection.database.exception.BadEmailException;
import com.connection.database.model.DefaultResponseDto;
import com.connection.database.model.UserDataDto;
import com.connection.database.post.PostUsers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/validation")
@RequiredArgsConstructor
public class ValidationController {

    private final UserAction userAction;
    private final PostUsers postUsersInDataBase;

    @PostMapping("/registration")
    public ResponseEntity<DefaultResponseDto> functionPost(@RequestBody UserDataDto userDataDto) {
        return postUsersInDataBase.functionSaveUserData(userDataDto);
    }

    @GetMapping(name = "{id}")
    public Optional<UserEntity> getUsersDataById(Long id) {
        return userAction.getUsersById(id);
    }

    @DeleteMapping()
    public void deleteUsers(@RequestParam String email) {
        userAction.deleteUsersByEmail(email);
    }

    @PutMapping ("/edit/{id}")
    public UserEntity updateDataUsers(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        userEntity.setId(id);
        return userAction.functionValidDataUpdateUser(userEntity);
    }
}
