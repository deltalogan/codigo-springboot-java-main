package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7InfoDiagnostico", description = "DTO de solicitud HL7 para consulta o registro de información de diagnóstico.")
public class HL7InfoDiagnostico implements Serializable {

	@Serial
	private static final long serialVersionUID = -576280222852124841L;

	@Schema(description = "Modo de operación de la solicitud HL7.", example = "A")
	private String modo;

	@Schema(description = "Credencial o identificador del beneficiario.", example = "1234567890")
	private String creden;

	@Schema(description = "Indicador de procesamiento manual.", example = "N")
	private String manual;

	@Schema(description = "Número de ticket asociado a la operación.", example = "456789")
	private Integer ticket;

	@Schema(description = "Identificador de terminal origen.", example = "TERM001")
	private String termId;

	@Schema(description = "Número interno de la entidad integradora.", example = "1001")
	private Integer interNro;

	@Schema(description = "CUIT del prestador o emisor de la solicitud.", example = "30712345678")
	private String cuit;

	@Schema(description = "Código o descripción de diagnóstico informada en la solicitud.", example = "J189")
	private String diag;

	public HL7InfoDiagnostico() {
		super();
	}

}