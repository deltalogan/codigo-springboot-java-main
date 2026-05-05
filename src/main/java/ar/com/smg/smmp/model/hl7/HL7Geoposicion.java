package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7Geoposicion", description = "DTO con información de geoposición asociada a una transacción HL7.")
public class HL7Geoposicion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(description = "Identificador interno del registro de geoposición.", example = "1")
	private int id;

	@Schema(description = "Número de transacción asociada a la geoposición.", example = "456789")
	private Integer transac;

	@Schema(description = "Latitud informada para la ubicación.", example = "-31.4201")
	private String latitud;

	@Schema(description = "Longitud informada para la ubicación.", example = "-64.1888")
	private String longitud;

	@Schema(description = "URL asociada a la ubicación o recurso relacionado.", example = "https://example.com/ubicacion/456789")
	private String url;

	@Schema(description = "Altitud informada para la ubicación.", example = "430")
	private String altitud;

	@Schema(description = "Velocidad informada en la captura de geoposición.", example = "0")
	private String velocidad;

	@Schema(description = "Rumbo informado en la captura de geoposición.", example = "180")
	private String rumbo;

	@Schema(description = "Precisión informada para la ubicación.", example = "10")
	private String precision;

	@Schema(description = "Fecha y hora de captura de la geoposición.", type = "string", format = "date-time", example = "2026-04-30T10:15:30")
	private Date timestamp;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getTransac() {
		return transac;
	}
	public void setTransac(Integer transac) {
		this.transac = transac;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAltitud() {
		return altitud;
	}
	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}
	public String getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}
	public String getRumbo() {
		return rumbo;
	}
	public void setRumbo(String rumbo) {
		this.rumbo = rumbo;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}