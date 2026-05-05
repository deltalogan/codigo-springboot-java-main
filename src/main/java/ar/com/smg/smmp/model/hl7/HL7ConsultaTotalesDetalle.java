package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7ConsultaTotalesDetalle", description = "Detalle de respuesta HL7 para consulta de totales.")
public class HL7ConsultaTotalesDetalle implements Serializable {

	private static final long serialVersionUID = -6381630996816775715L;

	@Schema(description = "Código nomenclador asociado al ítem.", example = "420101")
	private Integer nomen;

	@Schema(description = "Código de prestación asociado al ítem.", example = "CONSULTA")
	private String prestac;

	@Schema(description = "Cantidad total informada para el ítem.", example = "12")
	private Integer canti;

	@Schema(description = "Descripción del nomenclador.", example = "CONSULTA MÉDICA")
	private String nomenDeno;

	@Schema(description = "Descripción de la prestación.", example = "CONSULTA AMBULATORIA")
	private String prestacDeno;

	public HL7ConsultaTotalesDetalle() {
		super();
	}

	public Integer getNomen() {
		return nomen;
	}

	public void setNomen(Integer nomen) {
		this.nomen = nomen;
	}

	public String getPrestac() {
		return prestac;
	}

	public void setPrestac(String prestac) {
		this.prestac = prestac;
	}

	public Integer getCanti() {
		return canti;
	}

	public void setCanti(Integer canti) {
		this.canti = canti;
	}

	public String getNomenDeno() {
		return nomenDeno;
	}

	public void setNomenDeno(String nomenDeno) {
		this.nomenDeno = nomenDeno;
	}

	public String getPrestacDeno() {
		return prestacDeno;
	}

	public void setPrestacDeno(String prestacDeno) {
		this.prestacDeno = prestacDeno;
	}
}