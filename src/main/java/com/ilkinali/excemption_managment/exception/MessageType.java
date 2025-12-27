package com.ilkinali.excemption_managment.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    No_Record_Exist("1001","Not Found"),
    General_Exception("1002","General_Exception");


    private String code;

    private String message;


    MessageType(String code, String message) {
        this.code = code;
        this.message = message;

    }
}
