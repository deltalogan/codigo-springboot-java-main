package ar.com.smg.payroll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import ar.com.smg.payroll.config.PersistenceConfig;
import ar.com.smg.payroll.domain.Employee;
import ar.com.smg.payroll.persistence.mapper.EmployeeMapper;
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = PersistenceConfig.class)
class EmployeeMapperIntegrationTest {
    @Autowired private EmployeeMapper employeeMapper;
    @Test
    void whenRecordsInDatabase_shouldReturnEmployeeWithGivenId() {
        Employee employee = employeeMapper.findById(1L).orElseThrow(
                () -> new AssertionError("Debe existir un empleado con ID 1"));
        assertEquals(1L, employee.getId());
        assertEquals("Bilbo Baggins", employee.getName());
        assertEquals("burglar", employee.getRole());
    }
}