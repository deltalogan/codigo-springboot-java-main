package ar.com.smg.payroll.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entidad de dominio Employee.
 * Utiliza Lombok para reducir boilerplate.
 */
@Getter
@Setter
@NoArgsConstructor  // Reemplaza el constructor vacío con @SuppressWarnings
@Entity
@Schema(name = "Employee", description = "Entidad de dominio que representa un empleado.")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Identificador único del empleado.", example = "1")
  private Long id;

  @Schema(description = "Nombre del empleado.", example = "Bilbo Baggins")
  private String name;

  @Schema(description = "Rol o puesto del empleado.", example = "burglar")
  private String role;

  /**
   * Constructor para crear un Employee (usado en tests y lógica de negocio).
   */
  public Employee(String name, String role) {
    this.name = name;
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee employee)) return false;

    return Objects.equals(this.id, employee.id) &&
            Objects.equals(this.name, employee.name) &&
            Objects.equals(this.role, employee.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, role);
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", role='" + role + '\'' +
            '}';
  }
}