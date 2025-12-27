package com.ilkinali.excemption_managment.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {

    private long id;
    private String name;
    private DtoDepartmen dtoDepartmen;
}
