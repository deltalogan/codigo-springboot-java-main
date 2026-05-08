package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Schema(name = "HL7InfoDiagnosticoDetalle",
		description = "Detalle de respuesta HL7 para información de diagnóstico.")
public class HL7InfoDiagnosticoDetalle implements Serializable {
	@Serial private static final long serialVersionUID = 6960851513300147992L;
	@Schema(
			description = "Número de transacción asociado al ítem de la respuesta.",
			example = "456789")
	private Integer transac;
	@Schema(
			description = "Código de rechazo o resultado del ítem.", example = "0")
	private Integer rechaItem;
	@Schema(description = "Descripción del resultado o rechazo del ítem.",
			example = "Ítem procesado correctamente")
	private String denoItem;
	@Schema(description = "Código ICD informado en el detalle.", example = "J189")
	private String icd;
	public HL7InfoDiagnosticoDetalle() {
		super();
	}
}