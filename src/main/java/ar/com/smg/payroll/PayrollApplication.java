package ar.com.smg.payroll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"ar.com.smg.payroll", "ar.com.smg.smmp.hl7"})
public class PayrollApplication {
    public static void main(String... args) {
        SpringApplication.run(PayrollApplication.class, args);
    }
}