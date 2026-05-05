package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7RegProd", description = "DTO de solicitud HL7 para registro de producto o prestación.")
public class HL7RegProd implements Serializable {

	private static final long serialVersionUID = 4991377569526175748L;

	@Schema(description = "Modo de operación de la solicitud HL7.", example = "A")
	private String modo;

	@Schema(description = "Credencial o identificador del beneficiario.", example = "1234567890")
	private String creden;

	@Schema(description = "Tipo de operación o mensaje.", example = "1")
	private Integer tipo;

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

	@Schema(description = "Código ICD informado en la solicitud.", example = "J189")
	private String icd;

	@Schema(description = "Código de rechazo externo informado por el sistema origen.", example = "0")
	private Integer rechaExt;

	@Schema(description = "Parámetro adicional 1 utilizado por la integración.", example = "VALOR1")
	private String param1;

	@Schema(description = "Parámetro adicional 2 utilizado por la integración.", example = "VALOR2")
	private String param2;

	@Schema(description = "Parámetro adicional 3 utilizado por la integración.", example = "VALOR3")
	private String param3;

	@Schema(description = "Tipo de efector informado en la solicitud.", example = "PRESTADOR")
	private String tipoEfector;

	@Schema(description = "Identificador del efector.", example = "EF001")
	private String idEfector;

	@Schema(description = "Tipo de prescriptor informado en la solicitud.", example = "MEDICO")
	private String tipoPrescr;

	@Schema(description = "Identificador del prescriptor.", example = "MP12345")
	private String idPrescr;

	@Schema(description = "Identificador único de mensaje.", example = "MSG-20260430-0001")
	private String msgId;

	@Schema(description = "Código de aceptación del ACK.", example = "AA")
	private String ackacept;

	@Schema(description = "Código de aplicación del ACK.", example = "CA")
	private String ackackapl;

	@Schema(description = "Texto o código de consulta asociado a la operación.", example = "REGISTRO")
	private String consulta;

	@Schema(description = "Código de rechazo agregado a nivel cabecera.", example = "0")
	private Integer agRechaCabe;

	@Schema(description = "Código de rechazo agregado.", example = "0")
	private Integer agRecha;

	@Schema(description = "Tipo de mensaje HL7 informado.", example = "ORM")
	private String tipoMensaje;

	@Schema(description = "Indicador de origen o compatibilidad con PowerBuilder.", example = "false")
	private Boolean powerBuilder;

	public HL7RegProd() {
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

	public String getIcd() {
		return icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

	public Integer getRechaExt() {
		return rechaExt;
	}

	public void setRechaExt(Integer rechaExt) {
		this.rechaExt = rechaExt;
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

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getTipoEfector() {
		return tipoEfector;
	}

	public void setTipoEfector(String tipoEfector) {
		this.tipoEfector = tipoEfector;
	}

	public String getIdEfector() {
		return idEfector;
	}

	public void setIdEfector(String idEfector) {
		this.idEfector = idEfector;
	}

	public String getTipoPrescr() {
		return tipoPrescr;
	}

	public void setTipoPrescr(String tipoPrescr) {
		this.tipoPrescr = tipoPrescr;
	}

	public String getIdPrescr() {
		return idPrescr;
	}

	public void setIdPrescr(String idPrescr) {
		this.idPrescr = idPrescr;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getAckacept() {
		return ackacept;
	}

	public void setAckacept(String ackacept) {
		this.ackacept = ackacept;
	}

	public String getAckackapl() {
		return ackackapl;
	}

	public void setAckackapl(String ackackapl) {
		this.ackackapl = ackackapl;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public Integer getAgRechaCabe() {
		return agRechaCabe;
	}

	public void setAgRechaCabe(Integer agRechaCabe) {
		this.agRechaCabe = agRechaCabe;
	}

	public Integer getAgRecha() {
		return agRecha;
	}

	public void setAgRecha(Integer agRecha) {
		this.agRecha = agRecha;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public Boolean getPowerBuilder() {
		return powerBuilder;
	}

	public void setPowerBuilder(Boolean powerBuilder) {
		this.powerBuilder = powerBuilder;
	}
}