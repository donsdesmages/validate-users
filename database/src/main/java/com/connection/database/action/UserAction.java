package com.connection.database.action;
import com.connection.database.db.entity.UserEntity;
import com.connection.database.db.repository.UserRepository;

import com.connection.database.service.UserService;
import com.connection.database.util.Constant;
import com.connection.database.util.ConstantLogg;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class UserAction implements UserActionInterface {

    private final UserRepository userRepositoryImpl;
    private final UserService userService;

    @Override
    public void save(UserEntity userEntity) {
        userRepositoryImpl.save(userEntity);
    }

    @Override
    public Optional<UserEntity> getUsersById(Long id) {
        return userRepositoryImpl.findById(id);
    }

    @Override
    public void deleteUsersByEmail(@RequestParam String email) {
        userRepositoryImpl.deleteUserByEmail(email);
    }

    @Override
    public UserEntity functionValidDataUpdateUser(@RequestBody UserEntity userEntity) {
        String status = userService.validate(userEntity.getPassword(), userEntity.getEmail());
        if (status.equals(Constant.OK_STATUS)) {
            log.info(ConstantLogg.DATA_SAVED);
            return userRepositoryImpl.save(userEntity);
        } else {
            log.error(ConstantLogg.DATA_NOT_SAVED);
            return userEntity;
        }
    }
}
