package ar.com.smg.payroll.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import ar.com.smg.payroll.application.EmployeeService;
import ar.com.smg.payroll.domain.Employee;
import ar.com.smg.smmp.hl7.application.Hl7Service;

@WebMvcTest(EmployeeController.class)
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = {
        org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration.class
})
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("unused")
    @MockBean
    private EmployeeService service;

    @SuppressWarnings("unused")
    @MockBean
    private Hl7Service hl7Service; // evita cargar PersistenceConfig / DataSource

    @Test
    void getAllEmployees_deberiaRetornar200() throws Exception {
        when(service.all())
                .thenReturn(List.of(new Employee("Bilbo", "burglar")));

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getEmployeeById_deberiaRetornar200() throws Exception {
        when(service.one(any(Long.class)))
                .thenReturn(new Employee("Bilbo", "burglar"));

        mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void createEmployee_deberiaRetornar200() throws Exception {
        Employee emp = new Employee("Frodo", "hero");

        when(service.newEmployee(any()))
                .thenReturn(emp);

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Frodo\",\"role\":\"hero\"}"))
                .andExpect(status().isOk());
    }
}