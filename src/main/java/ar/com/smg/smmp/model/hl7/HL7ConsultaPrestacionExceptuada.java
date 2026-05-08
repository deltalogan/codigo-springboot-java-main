package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Schema(name = "HL7ConsultaPrestacionExceptuada",
		description =
				"DTO con información de prestación exceptuada para consultas HL7.")
public class HL7ConsultaPrestacionExceptuada implements Serializable {
	@Serial private static final long serialVersionUID = -5557766027648614931L;
	@Schema(description = "Código nomenclador de la prestación exceptuada.",
			example = "420101")
	private Integer nomen;
	@Schema(
			description = "Código o descripción breve de la prestación exceptuada.",
			example = "CONSULTA")
	private String prestac;
}