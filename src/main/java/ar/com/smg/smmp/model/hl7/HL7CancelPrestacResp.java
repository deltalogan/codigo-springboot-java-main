package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7CancelPrestacResp", description = "DTO de respuesta HL7 para cancelación de prestación.")
public class HL7CancelPrestacResp implements Serializable {

	private static final long serialVersionUID = -7672990450470615625L;

	@Schema(description = "Cabecera de la respuesta de cancelación de prestación.")
	private HL7CancelPrestacCab cabecera;

	@Schema(description = "Detalle de registros asociados a la respuesta de cancelación.")
	private List<HL7CancelPrestacDetalle> detalle;

	public HL7CancelPrestacResp() {
		super();
	}

	public HL7CancelPrestacCab getCabecera() {
		return cabecera;
	}

	public void setCabecera(HL7CancelPrestacCab cabecera) {
		this.cabecera = cabecera;
	}

	public List<HL7CancelPrestacDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<HL7CancelPrestacDetalle> detalle) {
		this.detalle = detalle;
	}
}