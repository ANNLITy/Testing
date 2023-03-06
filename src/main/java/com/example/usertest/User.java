package com.example.usertest;

import com.example.usertest.exeption.SameInfoException;
import com.example.usertest.exeption.WrongEmailException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class User {
    public User(String login, String email) throws SameInfoException, WrongEmailException {
        if (Objects.equals(login, email)) {
            throw new SameInfoException("Значения login и email идентичны");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new WrongEmailException("Неправильное значение поля email");
        }
        this.login=login;
        this.email=email;
    }

    private String login;
    private String email;
}
