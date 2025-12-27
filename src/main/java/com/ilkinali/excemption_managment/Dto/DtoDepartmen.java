package com.ilkinali.excemption_managment.Dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoDepartmen {

    private long id;
    private String name;
    private String location;

    public DtoDepartmen(long id) {
    }
}
