package com.ilkinali.excemption_managment.Controller;

import com.ilkinali.excemption_managment.Dto.DtoEmployee;
import com.ilkinali.excemption_managment.Entity.RootEntity;
import com.ilkinali.excemption_managment.Service.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImp extends RestBaseController implements IEmployeeController {



    @Autowired
    private EmployeeServiceImpl employeeService;
    @GetMapping("/list/{id}")
    @Override
    public RootEntity<DtoEmployee> findeployeebyid(@PathVariable(value = "id")Long id) {


        return ok((employeeService.findeployeebyid(id)));



    }


    @GetMapping("/list/all")
    @Override
    public List<DtoEmployee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/save")
    @Override
    public DtoEmployee saveEmployee(@RequestBody DtoEmployee dtoEmployee) {
        return employeeService.saveEmployee(dtoEmployee);
    }
}
