package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7InfoDiagnosticoCab", description = "Cabecera de respuesta HL7 para información de diagnóstico.")
public class HL7InfoDiagnosticoCab implements Serializable {

	@Serial
	private static final long serialVersionUID = -5526154572254688656L;

	@Schema(description = "Número o identificador de ticket asociado a la operación.", example = "456789")
	private String ticket;

	@Schema(description = "Código de rechazo o resultado de la operación.", example = "0")
	private Integer recha;

	@Schema(description = "Descripción del resultado o rechazo.", example = "Operación procesada correctamente")
	private String deno;

	@Schema(description = "Nombre del prestador informado en la respuesta.", example = "SANATORIO CENTRAL")
	private String nomPrestad;

	public HL7InfoDiagnosticoCab() {
		super();
	}

}