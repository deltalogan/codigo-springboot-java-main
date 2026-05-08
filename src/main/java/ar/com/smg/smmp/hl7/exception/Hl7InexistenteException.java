package ar.com.smg.smmp.hl7.exception;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(name = "Hl7InexistenteException",
        description = "Excepción de ejecución que indica que no se encontró la "
                + "entidad o transacción HL7 solicitada.")
public class Hl7InexistenteException extends RuntimeException {
    public Hl7InexistenteException() {
        super("Hl7 inexistente.");
    }
    public Hl7InexistenteException(String message) {
        super(message);
    }
}