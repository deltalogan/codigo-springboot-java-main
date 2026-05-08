package ar.com.smg.smmp.hl7.exception;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(name = "HL7DuplicateException",
        description = "Excepción de ejecución que indica que ya existe un registro "
                + "HL7 duplicado para la operación solicitada.")
public class HL7DuplicateException extends RuntimeException {
    public HL7DuplicateException(String message) {
        super(message);
    }
}