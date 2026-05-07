package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7ConsultaAutoResp", description = "DTO de respuesta HL7 para consulta de autorizaciones automáticas.")
public class HL7ConsultaAutoResp implements Serializable {

	@Serial
	private static final long serialVersionUID = -5237243510136151178L;

	@Schema(description = "Cabecera de la respuesta de consulta de autorizaciones automáticas.")
	private HL7ConsultaAutoCab cabecera;

	@Schema(description = "Detalle de registros asociados a la respuesta de consulta.")
	private List<HL7ConsultaAutoDetalle> detalle;

	public HL7ConsultaAutoResp() {
		super();
	}

}