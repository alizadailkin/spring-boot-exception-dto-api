package com.ilkinali.excemption_managment.Handler;

import lombok.Data;

@Data
public class ApiEror <E> {

    private Integer status;

    private Exception <E> exception;
}
