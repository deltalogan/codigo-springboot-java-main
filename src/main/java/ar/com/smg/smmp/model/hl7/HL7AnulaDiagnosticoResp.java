package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7AnulaDiagnosticoResp", description = "DTO de respuesta HL7 para anulación de diagnóstico.")
public class HL7AnulaDiagnosticoResp implements Serializable {

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

	public Integer getTicket() {
		return ticket;
	}

	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}

	public Integer getRecha() {
		return recha;
	}

	public void setRecha(Integer recha) {
		this.recha = recha;
	}

	public String getDeno() {
		return deno;
	}

	public void setDeno(String deno) {
		this.deno = deno;
	}
}