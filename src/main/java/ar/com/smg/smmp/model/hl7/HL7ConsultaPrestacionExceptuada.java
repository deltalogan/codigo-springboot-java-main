package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7ConsultaPrestacionExceptuada", description = "DTO con información de prestación exceptuada para consultas HL7.")
public class HL7ConsultaPrestacionExceptuada implements Serializable {

	private static final long serialVersionUID = -5557766027648614931L;

	@Schema(description = "Código nomenclador de la prestación exceptuada.", example = "420101")
	private Integer nomen;

	@Schema(description = "Código o descripción breve de la prestación exceptuada.", example = "CONSULTA")
	private String prestac;

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

}