package ar.com.smg.smmp.hl7.exception;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(name = "SMMPRuntimeException",
        description = "Excepción de ejecución genérica del módulo SMMP para "
                + "errores de procesamiento no controlados específicamente.")
public class SMMPRuntimeException extends RuntimeException {
    public SMMPRuntimeException(String message) {
        super(message);
    }
    @SuppressWarnings("unused")
    public SMMPRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}