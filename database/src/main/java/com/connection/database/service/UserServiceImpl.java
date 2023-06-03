package com.connection.database.service;

import com.connection.database.exception.BadEmailException;
import com.connection.database.exception.BadPasswordException;
import com.connection.database.util.ConstantLogg;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import static com.connection.database.util.Constant.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserServiceImpl userService;

    @Override
    @Transactional
    public String validate(String password, String email) {
        try {
            emailValidator(email);
            passwordValidator(password);
            log.info(ConstantLogg.DATA_VALID);
        } catch (BadEmailException e) {
            log.error(ConstantLogg.EMAIL_IS_NOT_VALID);
            return EXCEPTION_TEXT_EMAIL;
        } catch (BadPasswordException e) {
            log.error(ConstantLogg.PASSWORD_IS_NOT_VALID);
            return EXCEPTION_TEXT_PASSWORD;
        }
        return OK_STATUS;
    }

    public void emailValidator(String email) throws BadEmailException {
        if (!email.isEmpty()) {
            if (email.matches(EMAIL_REGULAR_EXPRESSION)) {
                return;
            }
            log.error(ConstantLogg.EMAIL_IS_NOT_VALID);
            throw new BadEmailException();
        }
        log.error(ConstantLogg.EMAIL_IS_NOT_VALID);
        throw new BadEmailException();
    }

    public void passwordValidator(String password) throws BadPasswordException {
        if (password != null) {
            if ((password.matches(PASSWORD_REGULAR_EXPRESSION))
                && (password.length() > 7)) {
                return;
            }
            log.error(ConstantLogg.PASSWORD_IS_NOT_VALID);
            throw new BadPasswordException();
        }
        log.error(ConstantLogg.PASSWORD_IS_NOT_VALID);
        throw new BadPasswordException();
    }
}

