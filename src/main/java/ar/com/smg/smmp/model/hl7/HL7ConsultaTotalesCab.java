package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7ConsultaTotalesCab", description = "Cabecera de respuesta HL7 para consulta de totales.")
public class HL7ConsultaTotalesCab implements Serializable {

	private static final long serialVersionUID = -6098485481875496509L;

	@Schema(description = "Fecha y hora de la transacción informada en la respuesta, en formato HL7 adaptado. Admite valores compatibles con yyyy-MM-dd HH:mm:ss, yyyyMMdd o yyyy-MM-dd.", type = "string", example = "2026-04-30 10:15:30")
	@XmlJavaTypeAdapter(HL7DateAdapter.class)
	private Date tranFecha;

	@Schema(description = "Número de transacción generado o informado por el procesamiento.", example = "456789")
	private Integer transac;

	@Schema(description = "Código de respuesta del procesamiento.", example = "0")
	private Integer respues;

	@Schema(description = "Descripción del código de respuesta.", example = "Operación procesada correctamente")
	private String respuesDeno;

	@Schema(description = "Indicador o código de ley aplicable.", example = "N")
	private String leyimp;

	public HL7ConsultaTotalesCab() {
		super();
	}

	public Integer getTransac() {
		return transac;
	}

	public void setTransac(Integer transac) {
		this.transac = transac;
	}

	public Date getTranFecha() {
		return (tranFecha != null ? (Date) tranFecha.clone() : null);
	}

	public void setTranFecha(Date tranFecha) {
		this.tranFecha = (tranFecha != null ? (Date) tranFecha.clone() : null);
	}

	public Integer getRespues() {
		return respues;
	}

	public void setRespues(Integer respues) {
		this.respues = respues;
	}

	public String getRespuesDeno() {
		return respuesDeno;
	}

	public void setRespuesDeno(String respuesDeno) {
		this.respuesDeno = respuesDeno;
	}

	public String getLeyimp() {
		return leyimp;
	}

	public void setLeyimp(String leyimp) {
		this.leyimp = leyimp;
	}
}