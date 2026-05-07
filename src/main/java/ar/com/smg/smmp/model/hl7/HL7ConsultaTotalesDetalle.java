package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7ConsultaTotalesDetalle", description = "Detalle de respuesta HL7 para consulta de totales.")
public class HL7ConsultaTotalesDetalle implements Serializable {

	@Serial
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

}