package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7AnulaDiagnosticoResp", description = "DTO de respuesta HL7 para anulación de diagnóstico.")
public class HL7AnulaDiagnosticoResp implements Serializable {

	@Serial
	private static final long serialVersionUID = 5230678094821829344L;

	@Schema(description = "Número de ticket asociado a la operación procesada.", example = "456789")
	private Integer ticket;

	@Schema(description = "Código de rechazo o resultado de la operación.", example = "0")
	private Integer recha;

	@Schema(description = "Descripción del resultado o rechazo.", example = "Operación procesada correctamente")
	private String deno;

	public HL7AnulaDiagnosticoResp() {
		super();
	}

}