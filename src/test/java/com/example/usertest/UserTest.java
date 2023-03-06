package com.example.usertest;

import com.example.usertest.exeption.SameInfoException;
import com.example.usertest.exeption.WrongEmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class UserTest {
    private static final String login = "login123";
    private static final String loginAndEmail = "login123";
    private static final String email ="email@gmail.ru";
    private static final String WrongEmail ="emailgmailru";

    public static Stream<Arguments> paramsForTestWithWrongEmail() {
        return Stream.of(
                Arguments.of(login,WrongEmail)
        );
    }

    @Test
    public void shouldReturnLoginAndEmail() throws Exception {
        User user = new User(login, email);
        String resultLogin= user.getLogin();
        String resultEmail = user.getEmail();
        Assertions.assertEquals(login, resultLogin);
        Assertions.assertEquals(email,resultEmail);
    }
    @Test
    public void shouldReturnNulls() {
        User user = new User();
        String resultLogin = user.getLogin();
        String resultEmail = user.getEmail();
        Assertions.assertNull(resultEmail);
        Assertions.assertNull(resultLogin);
    }
    @ParameterizedTest
    @MethodSource("paramsForTestWithWrongEmail")
    public void shouldThrowWrongEmailException(String login, String email) {
        Assertions.assertThrows(WrongEmailException.class, () -> new User(login, email));

    }
@Test
    public void shouldThrowSameInfoException(){
        Assertions.assertThrows(SameInfoException.class, () -> new User(login,loginAndEmail));



    }

}