package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7RegProdResp", description = "DTO de respuesta HL7 para registro de producto o prestación.")
public class HL7RegProdResp implements Serializable {

	private static final long serialVersionUID = -98638691839448658L;

	@Schema(description = "Cabecera de la respuesta de registro.")
	private HL7RegProdCab cabecera;

	@Schema(description = "Detalle de registros asociados a la respuesta de registro.")
	private List<HL7RegProdDetalle> detalle;

	public HL7RegProdResp() {
		super();
	}

	public HL7RegProdCab getCabecera() {
		return cabecera;
	}

	public void setCabecera(HL7RegProdCab cabecera) {
		this.cabecera = cabecera;
	}

	public List<HL7RegProdDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<HL7RegProdDetalle> detalle) {
		this.detalle = detalle;
	}
}