package ar.com.smg.payroll.controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ar.com.smg.payroll.application.EmployeeService;
import ar.com.smg.payroll.domain.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@Tag(name = "Employees", description = "Servicios para la gestión de empleados")
class EmployeeController {
    private final EmployeeService service;
    EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @Operation(summary = "Listar empleados",
            description = "Obtiene la lista completa de empleados")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Lista de empleados obtenida correctamente",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = Employee.class))))
                    ,
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @GetMapping("/employees")
    List<Employee>
    all() {
        return service.all();
    }
    @Operation(summary = "Crear empleado", description = "Crea un nuevo empleado")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Empleado creado correctamente",
                            content =
                            @Content(schema = @Schema(implementation = Employee.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PostMapping("/employees")
    Employee
    newEmployee(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del empleado a crear", required = true,
            content = @Content(schema = @Schema(implementation = Employee.class)))
                @RequestBody Employee newEmployee) {
        return service.newEmployee(newEmployee);
    }
    @Operation(summary = "Obtener empleado por ID",
            description = "Obtiene un empleado a partir de su identificador")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Empleado obtenido correctamente",
                            content =
                            @Content(schema = @Schema(implementation = Employee.class)))
                    ,
                    @ApiResponse(
                            responseCode = "404", description = "Empleado no encontrado"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @GetMapping("/employees/{id}")
    Employee
    one(@Parameter(description = "Identificador del empleado", example = "1",
            required = true) @PathVariable Long id) {
        return service.one(id);
    }
    @Operation(summary = "Actualizar empleado",
            description = "Reemplaza la información de un empleado existente")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Empleado actualizado correctamente",
                            content =
                            @Content(schema = @Schema(implementation = Employee.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(
                            responseCode = "404", description = "Empleado no encontrado"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PutMapping("/employees/{id}")
    Employee
    replaceEmployee(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos actualizados del empleado", required = true,
                    content = @Content(schema = @Schema(implementation = Employee.class)))
            @RequestBody Employee newEmployee,
            @Parameter(description = "Identificador del empleado", example = "1",
                    required = true) @PathVariable Long id) {
        return service.replaceEmployee(newEmployee, id);
    }
    @Operation(summary = "Eliminar empleado",
            description = "Elimina un empleado a partir de su identificador")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Empleado eliminado correctamente")
                    ,
                    @ApiResponse(
                            responseCode = "404", description = "Empleado no encontrado"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @DeleteMapping("/employees/{id}")
    void
    deleteEmployee(@Parameter(description = "Identificador del empleado",
            example = "1", required = true) @PathVariable Long id) {
        service.deleteEmployee(id);
    }
}