package com.example.usertest.exeption;

public class WrongEmailException extends Exception {
    public WrongEmailException(String message){
        super(message);
    }
}
