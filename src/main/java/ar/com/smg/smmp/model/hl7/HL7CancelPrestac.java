package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7CancelPrestac", description = "DTO de solicitud HL7 para cancelación de prestación.")
public class HL7CancelPrestac implements Serializable {

	private static final long serialVersionUID = -7549246129265897344L;

	@Schema(description = "Modo de operación de la solicitud HL7.", example = "A")
	private String modo;

	@Schema(description = "Credencial o identificador del beneficiario.", example = "1234567890")
	private String creden;

	@Schema(description = "Tipo de operación o mensaje.", example = "1")
	private Integer tipo;

	@Schema(description = "Fecha y hora de alta de la transacción en formato HL7 adaptado. Admite valores compatibles con yyyy-MM-dd HH:mm:ss, yyyyMMdd o yyyy-MM-dd.", type = "string", example = "2026-04-30 10:15:30")
	@XmlJavaTypeAdapter(HL7DateAdapter.class)
	private Date alta;

	@Schema(description = "Indicador de procesamiento manual.", example = "N")
	private String manual;

	@Schema(description = "Identificador de ticket externo asociado a la operación.", example = "12345")
	private Integer ticketExt;

	@Schema(description = "Código de cancelación a nivel cabecera.", example = "0")
	private Integer cancelCab;

	@Schema(description = "Identificador de terminal origen.", example = "TERM001")
	private String termId;

	@Schema(description = "Número interno de la entidad integradora.", example = "1001")
	private Integer interNro;

	@Schema(description = "CUIT del prestador o emisor de la solicitud.", example = "30712345678")
	private String cuit;

	@Schema(description = "Modo de cancelación informado en la solicitud.", example = "TOTAL")
	private String cancelModo;

	@Schema(description = "Código de error externo informado por el sistema origen.", example = "0")
	private Integer errorExt;

	@Schema(description = "Parámetro adicional 1 utilizado por la integración.", example = "VALOR1")
	private String param1;

	@Schema(description = "Parámetro adicional 2 utilizado por la integración.", example = "VALOR2")
	private String param2;

	public HL7CancelPrestac() {
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Date getAlta() {
		return (alta != null ? (Date) alta.clone() : null);
	}

	public void setAlta(Date alta) {
		this.alta = (alta != null ? (Date) alta.clone() : null);
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

	public Integer getCancelCab() {
		return cancelCab;
	}

	public void setCancelCab(Integer cancelCab) {
		this.cancelCab = cancelCab;
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

	public String getCancelModo() {
		return cancelModo;
	}

	public void setCancelModo(String cancelModo) {
		this.cancelModo = cancelModo;
	}

	public Integer getErrorExt() {
		return errorExt;
	}

	public void setErrorExt(Integer errorExt) {
		this.errorExt = errorExt;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}
}