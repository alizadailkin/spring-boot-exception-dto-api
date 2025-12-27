package com.ilkinali.excemption_managment.Service;

import com.ilkinali.excemption_managment.Controller.RestBaseController;
import com.ilkinali.excemption_managment.Dto.DtoDepartmen;
import com.ilkinali.excemption_managment.Entity.Department;

import com.ilkinali.excemption_managment.Dto.DtoEmployee;
import com.ilkinali.excemption_managment.Entity.Employee;
import com.ilkinali.excemption_managment.Repository.EmployeeRepository;

import com.ilkinali.excemption_managment.exception.BaseException;
import com.ilkinali.excemption_managment.exception.ErrorMessage;
import com.ilkinali.excemption_managment.exception.MessageType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl extends RestBaseController implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public DtoEmployee findeployeebyid(Long id) {

        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartmen dtoDepartmen = new DtoDepartmen(id);

        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()) {

            throw new BaseException(new ErrorMessage(MessageType.No_Record_Exist,id.toString() ));
        }
        Employee employee = optional.get();
        Department department = employee.getDepartment();
        BeanUtils.copyProperties(department, dtoDepartmen);
        BeanUtils.copyProperties(employee, dtoEmployee);
        dtoEmployee.setDtoDepartmen(dtoDepartmen);
        return dtoEmployee;
    }

    @Override
    public List<DtoEmployee> getAllEmployees() {

        List<DtoEmployee> dtoEmployeelist = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        DtoDepartmen dtoDepartmen= new DtoDepartmen();
        if (employeeList != null && !employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
                DtoEmployee dtoEmployee = new DtoEmployee();
                Department department = employee.getDepartment();
                BeanUtils.copyProperties(employee, dtoEmployee);
                BeanUtils.copyProperties(department, dtoDepartmen);
                dtoEmployee.setDtoDepartmen(dtoDepartmen);
                dtoEmployeelist.add(dtoEmployee);
            }
        }
        return dtoEmployeelist;
    }

    @Override
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee) {
        // DTO'dan Entity'e dönüştür
        Employee employee = new Employee();
        BeanUtils.copyProperties(dtoEmployee, employee);

        // Entity'i kaydet
        Employee savedEmployee = employeeRepository.save(employee);

        // Kaydedilen Entity'i tekrar DTO'ya dönüştür
        DtoEmployee resultDto = new DtoEmployee();
        BeanUtils.copyProperties(savedEmployee, resultDto);

        return resultDto;
    }

}







