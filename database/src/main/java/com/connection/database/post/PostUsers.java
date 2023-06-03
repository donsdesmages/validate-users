package com.connection.database.post;

import com.connection.database.action.UserAction;
import com.connection.database.db.entity.UserEntity;
import com.connection.database.model.DefaultResponseDto;
import com.connection.database.model.UserDataDto;
import com.connection.database.service.UserService;
import com.connection.database.util.ConstantLogg;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static com.connection.database.util.Constant.*;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PostUsers {

    private final UserService userService;
    private final UserAction userAction;
    private final UserEntity userEntity;

    public ResponseEntity<DefaultResponseDto> functionSaveUserData(@RequestBody UserDataDto userDataDto) {
        String status = userService.validate(userDataDto.getPassword(), userDataDto.getEmail());
        if (status.equals(OK_STATUS)) {
            userEntity.setEmail(userDataDto.getEmail());
            userEntity.setPassword(userDataDto.getPassword());
            userAction.save(userEntity);
            log.info(ConstantLogg.DATA_SAVED);
            return validDataOk();
        }
        log.error(ConstantLogg.DATA_NOT_SAVED);
        return exceptionDontValidData();
    }

    public ResponseEntity<DefaultResponseDto> validDataOk() {
        return ResponseEntity
            .ok(DefaultResponseDto
                .builder()
                .body(DATA_OK)
                .date(LocalDateTime.now()).build());
    }

    public ResponseEntity<DefaultResponseDto> exceptionDontValidData() {
        return ResponseEntity.badRequest()
            .body(DefaultResponseDto.builder()
                .errorMessage(ConstantLogg.DATA_NOT_SAVED)
                .date(LocalDateTime.now()).build());
    }
}
