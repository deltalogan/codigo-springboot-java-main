package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7Elegibilidad", description = "DTO de solicitud HL7 para consulta de elegibilidad.")
public class HL7Elegibilidad implements Serializable {

	private static final long serialVersionUID = -3138891198846369145L;

	@Schema(description = "Modo de operación de la solicitud HL7.", example = "A")
	private String modo;

	@Schema(description = "Credencial o identificador del beneficiario.", example = "1234567890")
	private String creden;

	@Schema(description = "Fecha y hora de alta de la transacción en formato HL7 adaptado. Admite valores compatibles con yyyy-MM-dd HH:mm:ss, yyyyMMdd o yyyy-MM-dd.", type = "string", example = "2026-04-30 10:15:30")
	@XmlJavaTypeAdapter(HL7DateAdapter.class)
	private Date alta;

	@Schema(description = "Fecha diferencial informada en la solicitud.", example = "20260430")
	private String fecdif;

	@Schema(description = "Indicador de procesamiento manual.", example = "N")
	private String manual;

	@Schema(description = "Identificador de ticket externo asociado a la operación.", example = "12345")
	private Integer ticketExt;

	@Schema(description = "Identificador de terminal origen.", example = "TERM001")
	private String termId;

	@Schema(description = "Número interno de la entidad integradora.", example = "1001")
	private Integer interNro;

	@Schema(description = "CUIT del prestador o emisor de la solicitud.", example = "30712345678")
	private String cuit;

	@Schema(description = "Matrícula de origen informada en la solicitud.", example = "MN12345")
	private String oriMatri;

	@Schema(description = "Indicador o número de autorización.", example = "1")
	private Integer autoriz;

	@Schema(description = "Código de rechazo externo informado por el sistema origen.", example = "0")
	private Integer rechaExt;

	public HL7Elegibilidad() {
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

	public Date getAlta() {
		return (alta != null ? (Date) alta.clone() : null);
	}

	public void setAlta(Date alta) {
		this.alta = (alta != null ? (Date) alta.clone() : null);
	}

	public String getFecdif() {
		return fecdif;
	}

	public void setFecdif(String fecdif) {
		this.fecdif = fecdif;
	}

	public String getManual() {
		return manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}

	public Integer getTicketExt() {
		return ticketExt;
	}

	public void setTicketExt(Integer ticketExt) {
		this.ticketExt = ticketExt;
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

	public String getOriMatri() {
		return oriMatri;
	}

	public void setOriMatri(String oriMatri) {
		this.oriMatri = oriMatri;
	}

	public Integer getAutoriz() {
		return autoriz;
	}

	public void setAutoriz(Integer autoriz) {
		this.autoriz = autoriz;
	}

	public Integer getRechaExt() {
		return rechaExt;
	}

	public void setRechaExt(Integer rechaExt) {
		this.rechaExt = rechaExt;
	}
}