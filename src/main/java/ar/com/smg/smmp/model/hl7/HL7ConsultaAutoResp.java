package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7ConsultaAutoResp", description = "DTO de respuesta HL7 para consulta de autorizaciones automáticas.")
public class HL7ConsultaAutoResp implements Serializable {

	private static final long serialVersionUID = -5237243510136151178L;

	@Schema(description = "Cabecera de la respuesta de consulta de autorizaciones automáticas.")
	private HL7ConsultaAutoCab cabecera;

	@Schema(description = "Detalle de registros asociados a la respuesta de consulta.")
	private List<HL7ConsultaAutoDetalle> detalle;

	public HL7ConsultaAutoResp() {
		super();
	}

	public HL7ConsultaAutoCab getCabecera() {
		return cabecera;
	}

	public void setCabecera(HL7ConsultaAutoCab cabecera) {
		this.cabecera = cabecera;
	}

	public List<HL7ConsultaAutoDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<HL7ConsultaAutoDetalle> detalle) {
		this.detalle = detalle;
	}
}