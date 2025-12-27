package com.ilkinali.excemption_managment.Controller;

import com.ilkinali.excemption_managment.Dto.DtoEmployee;
import com.ilkinali.excemption_managment.Entity.RootEntity;

import java.util.List;

public interface IEmployeeController {

    public RootEntity<DtoEmployee> findeployeebyid(Long id);
    public List<DtoEmployee> getAllEmployees();
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee);
}
