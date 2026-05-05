package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7CancelPrestacDetalle", description = "Detalle de respuesta HL7 para cancelación de prestación.")
public class HL7CancelPrestacDetalle implements Serializable {

	private static final long serialVersionUID = 3123920367497366111L;

	@Schema(description = "Número de transacción asociado al ítem de la respuesta.", example = "456789")
	private Integer transac;

	@Schema(description = "Código de rechazo o resultado del ítem.", example = "0")
	private Integer recha;

	@Schema(description = "Descripción del resultado o rechazo del ítem.", example = "Ítem procesado correctamente")
	private String denoItem;

	public HL7CancelPrestacDetalle() {
		super();
	}

	public Integer getTransac() {
		return transac;
	}

	public void setTransac(Integer transac) {
		this.transac = transac;
	}

	public Integer getRecha() {
		return recha;
	}

	public void setRecha(Integer recha) {
		this.recha = recha;
	}

	public String getDenoItem() {
		return denoItem;
	}

	public void setDenoItem(String denoItem) {
		this.denoItem = denoItem;
	}
}