package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7AnulaDiagnostico", description = "DTO de solicitud HL7 para anulación de diagnóstico.")
public class HL7AnulaDiagnostico implements Serializable {

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

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public String getCreden() {
		return creden;
	}

	public void setCreden(String creden) {
		this.creden = creden;
	}

	public String getManual() {
		return manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public Integer getInterNro() {
		return interNro;
	}

	public void setInterNro(Integer interNro) {
		this.interNro = interNro;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public Integer getTicketAnula() {
		return ticketAnula;
	}

	public void setTicketAnula(Integer ticketAnula) {
		this.ticketAnula = ticketAnula;
	}
}