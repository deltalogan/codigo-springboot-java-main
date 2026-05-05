package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7ConsultaTotales", description = "DTO de solicitud HL7 para consulta de totales.")
public class HL7ConsultaTotales implements Serializable {

	private static final long serialVersionUID = 5110793006941832829L;

	@Schema(description = "Número interno de la entidad integradora.", example = "1001")
	private Integer interNro;

	@Schema(description = "Identificador de terminal origen.", example = "TERM001")
	private String termId;

	@Schema(description = "Número de POS o identificador de punto de servicio.", example = "10")
	private Integer nropos;

	@Schema(description = "CUIT del prestador o emisor de la solicitud.", example = "30712345678")
	private String cuit;

	@Schema(description = "Código de prestación a consultar.", example = "420101")
	private String prestac;

	@Schema(description = "Fecha y hora de inicio del rango de consulta en formato HL7 adaptado. Admite valores compatibles con yyyy-MM-dd HH:mm:ss, yyyyMMdd o yyyy-MM-dd.", type = "string", example = "2026-04-01 00:00:00")
	@XmlJavaTypeAdapter(HL7DateAdapter.class)
	private Date desde;

	@Schema(description = "Fecha y hora de fin del rango de consulta en formato HL7 adaptado. Admite valores compatibles con yyyy-MM-dd HH:mm:ss, yyyyMMdd o yyyy-MM-dd.", type = "string", example = "2026-04-30 23:59:59")
	@XmlJavaTypeAdapter(HL7DateAdapter.class)
	private Date hasta;

	public HL7ConsultaTotales() {
		super();
	}

	public Integer getInterNro() {
		return interNro;
	}

	public void setInterNro(Integer interNro) {
		this.interNro = interNro;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public Integer getNropos() {
		return nropos;
	}

	public void setNropos(Integer nropos) {
		this.nropos = nropos;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public Date getDesde() {
		return (desde != null ? (Date) desde.clone() : null);
	}

	public void setDesde(Date desde) {
		this.desde = (desde != null ? (Date) desde.clone() : null);
	}

	public Date getHasta() {
		return (hasta != null ? (Date) hasta.clone() : null);
	}

	public void setHasta(Date hasta) {
		this.hasta = (hasta != null ? (Date) hasta.clone() : null);
	}

	public String getPrestac() {
		return prestac;
	}

	public void setPrestac(String prestac) {
		this.prestac = prestac;
	}
}