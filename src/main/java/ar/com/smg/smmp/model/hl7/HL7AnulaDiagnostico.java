package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7AnulaDiagnostico", description = "DTO de solicitud HL7 para anulación de diagnóstico.")
public class HL7AnulaDiagnostico implements Serializable {

	@Serial
	private static final long serialVersionUID = 5830944862603589202L;

	@Schema(description = "Modo de operación de la solicitud HL7.", example = "A")
	private String modo;

	@Schema(description = "Credencial o identificador del beneficiario.", example = "1234567890")
	private String creden;

	@Schema(description = "Indicador de procesamiento manual.", example = "N")
	private String manual;

	@Schema(description = "Identificador de terminal origen.", example = "TERM001")
	private String termId;

	@Schema(description = "Número interno de la entidad integradora.", example = "1001")
	private Integer interNro;

	@Schema(description = "CUIT del prestador o emisor de la solicitud.", example = "30712345678")
	private String cuit;

	@Schema(description = "Número de ticket a anular.", example = "456789")
	private Integer ticketAnula;

	public HL7AnulaDiagnostico() {
		super();
	}

}