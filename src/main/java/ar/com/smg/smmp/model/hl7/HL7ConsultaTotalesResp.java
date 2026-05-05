package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7ConsultaTotalesResp", description = "DTO de respuesta HL7 para consulta de totales.")
public class HL7ConsultaTotalesResp implements Serializable {

	private static final long serialVersionUID = 7752293056699677485L;

	@Schema(description = "Cabecera de la respuesta de consulta de totales.")
	private HL7ConsultaTotalesCab cabecera;

	@Schema(description = "Detalle de registros asociados a la respuesta de consulta de totales.")
	private List<HL7ConsultaTotalesDetalle> detalle;

	public HL7ConsultaTotalesResp() {
		super();
	}

	public HL7ConsultaTotalesCab getCabecera() {
		return cabecera;
	}

	public void setCabecera(HL7ConsultaTotalesCab cabecera) {
		this.cabecera = cabecera;
	}

	public List<HL7ConsultaTotalesDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<HL7ConsultaTotalesDetalle> detalle) {
		this.detalle = detalle;
	}
}