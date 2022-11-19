package com.bridgelabz;

public class UserException extends RuntimeException{
    enum ExceptionType{
        SQLException,Null,ClassNotFound,NullList
    }

    ExceptionType type;

    public UserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
