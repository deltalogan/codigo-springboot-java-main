package ar.com.smg.payroll.application;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ar.com.smg.payroll.domain.Employee;
import ar.com.smg.payroll.exception.EmployeeNotFoundException;
import ar.com.smg.payroll.persistence.mapper.EmployeeMapper;
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock private EmployeeMapper mapper;
    @InjectMocks private EmployeeService service;
    @Test
    void all_deberiaRetornarListaDeEmpleados() {
        when(mapper.findAll())
                .thenReturn(List.of(new Employee("Bilbo", "burglar")));
        List<Employee> employees = service.all();
        assertEquals(1, employees.size());
        verify(mapper).findAll();
    }
    @Test
    void one_cuandoExiste_deberiaRetornarEmpleado() {
        Employee emp = new Employee("Frodo", "ring bearer");
        when(mapper.findById(1L)).thenReturn(Optional.of(emp));
        Employee result = service.one(1L);
        assertEquals("Frodo", result.getName());
    }
    @Test
    void one_cuandoNoExiste_deberiaLanzarEmployeeNotFoundException() {
        when(mapper.findById(999L)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class, () -> service.one(999L));
    }
    @Test
    void newEmployee_deberiaGuardarYRetornar() {
        Employee newEmp = new Employee("Sam", "gardener");
        when(mapper.save(newEmp)).thenReturn(newEmp);
        Employee result = service.newEmployee(newEmp);
        assertNotNull(result);
        verify(mapper).save(newEmp);
    }
}