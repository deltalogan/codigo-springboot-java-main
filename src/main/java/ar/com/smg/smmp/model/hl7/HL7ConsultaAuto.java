package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Schema(name = "HL7ConsultaAuto",
		description =
				"DTO de solicitud HL7 para consulta de autorizaciones automáticas.")
public class HL7ConsultaAuto implements Serializable {
	@Serial private static final long serialVersionUID = -8550926980204607394L;
	@Schema(description = "Modo de operación de la solicitud HL7.", example = "C")
	private String modo;
	@Schema(description = "Credencial o identificador del beneficiario.",
			example = "1234567890")
	private String creden;
	@Schema(description = "Indicador de procesamiento manual.", example = "N")
	private String manual;
	@Schema(
			description = "Identificador de terminal origen.", example = "TERM001")
	private String termId;
	@Schema(description = "Número interno de la entidad integradora.",
			example = "1001")
	private Integer interNro;
	@Schema(description = "CUIT del prestador o emisor de la solicitud.",
			example = "30712345678")
	private String cuit;
	@Schema(
			description = "Número de transacción a consultar.", example = "456789")
	private Integer transac;
	@Schema(description = "Texto o código de consulta asociado a la operación.",
			example = "AUTORIZACIONES")
	private String consulta;
	public HL7ConsultaAuto() {
		super();
	}
}