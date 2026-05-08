package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Schema(name = "HL7InfoDiagnosticoResp",
		description = "DTO de respuesta HL7 para información de diagnóstico.")
public class HL7InfoDiagnosticoResp implements Serializable {
	@Serial private static final long serialVersionUID = -5993765646351085372L;
	@Schema(
			description = "Cabecera de la respuesta de información de diagnóstico.")
	private HL7InfoDiagnosticoCab cabecera;
	@Schema(description = "Detalle de registros asociados a la respuesta de "
			+ "información de diagnóstico.")
	private List<HL7InfoDiagnosticoDetalle> detalle;
	public HL7InfoDiagnosticoResp() {
		super();
	}
}