package ar.com.smg.payroll.persistence.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ar.com.smg.payroll.domain.Employee;

public interface EmployeeMapper {
    @Select("SELECT * FROM EMPLOYEES WHERE id = #{id}")
    Optional<Employee> findById(@Param("id") Long id);

    @Select("SELECT * FROM EMPLOYEES")
    List<Employee> findAll();

    @Select("INSERT INTO EMPLOYEES(name, role) values (#{employee.name}, #{employee.role})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Employee save(@Param("id") Employee employee);

    @Select("DELETE FROM EMPLOYEES WHERE id = #{id}")
    Employee deleteById(@Param("id") Long id);

    @SuppressWarnings("unused")
    @Select("UPDATE EMPLOYEES SET name=#{employee.name}, role=#{employee.role} WHERE id = #{id}")
    Employee update(@Param("id") Long id, Employee employee);
}