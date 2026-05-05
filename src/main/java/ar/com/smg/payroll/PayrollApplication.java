package ar.com.smg.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal de la aplicación Spring Boot.
 * <p>
 * Se amplió el ComponentScan para incluir el paquete HL7 SMMP
 * que está fuera del paquete base original del template.
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "ar.com.smg.payroll",           // Paquete original del template (Employee, etc.)
        "ar.com.smg.smmp.hl7"           // ← Paquete agregado para la migración HL7 SMMP
})
public class PayrollApplication {

    public static void main(String... args) {
        SpringApplication.run(PayrollApplication.class, args);
    }
}