package com.ilkinali.excemption_managment.Service;

import com.ilkinali.excemption_managment.Dto.DtoDepartmen;
import com.ilkinali.excemption_managment.Dto.DtoEmployee;
import com.ilkinali.excemption_managment.Entity.Employee;

import java.util.List;

public interface IEmployeeService {

    public DtoEmployee findeployeebyid(Long id);
    public List<DtoEmployee> getAllEmployees();
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee);

}
