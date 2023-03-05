package com.example.usertest;

import com.example.usertest.exeption.SameInfoException;
import com.example.usertest.exeption.WrongEmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserTest {
    private static final String login = "login123";
    private static final String loginAndEmail = "login123";
    private static final String email ="email@gmail.ru";
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
    @Test
    public void shouldThrowWrongEmailException(String login, String email) {
        Assertions.assertThrows(WrongEmailException.class, () -> new User(login, email));

    }
@Test
    public void shouldThrowSameInfoException(){
        Assertions.assertThrows(SameInfoException.class, () -> new User(login,loginAndEmail));



    }

}