package ar.com.smg.payroll.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.smg.payroll.domain.Employee;
import ar.com.smg.payroll.exception.EmployeeNotFoundException;
import ar.com.smg.payroll.persistence.mapper.EmployeeMapper;

@Service
public class EmployeeService {
    private final EmployeeMapper mapper;

    EmployeeService(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    public List<Employee> all() {
        return mapper.findAll();
    }

    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return mapper.save(newEmployee);
    }

    public Employee one(@PathVariable Long id) {

        return mapper.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return mapper.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return mapper.save(employee);
                })
                .orElseGet(() -> mapper.save(newEmployee));
    }

    public void deleteEmployee(@PathVariable Long id) {
        mapper.deleteById(id);
    }
}
