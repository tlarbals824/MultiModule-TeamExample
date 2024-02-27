package com.sim.domainmodule.domain.user.exception;

public class UserException extends RuntimeException{
    public UserException(){
        super("User not found");
    }
}
