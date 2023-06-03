package com.connection.database.util;

public class Constant {
    public static final String OK_STATUS = "OK";
    public static final String EXCEPTION_TEXT_EMAIL = "Ошибка в валидации 'email'";
    public static final String EXCEPTION_TEXT_PASSWORD = "Ошибка в валидации 'password'";

    public static final String VALID_DATA = "Вы успешно зарегистрировались. Данные сохранены!";
    public static final String DATA_OK = "Данные проверены и сохранены";

    public static final String EMAIL_REGULAR_EXPRESSION = "^[a-zA-Z0-9]{1,}"
        +"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"
        +"@" +"[a-zA-Z0-9]{1,}"
        + "((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"
        + "\\.[a-zA-Z]{2,}$";

    public static final String PASSWORD_REGULAR_EXPRESSION = "^[a-zA-Z0-9]*$";

}
