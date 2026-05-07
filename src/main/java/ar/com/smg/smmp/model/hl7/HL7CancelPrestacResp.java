package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7CancelPrestacResp", description = "DTO de respuesta HL7 para cancelación de prestación.")
public class HL7CancelPrestacResp implements Serializable {

	@Serial
	private static final long serialVersionUID = -7672990450470615625L;

	@Schema(description = "Cabecera de la respuesta de cancelación de prestación.")
	private HL7CancelPrestacCab cabecera;

	@Schema(description = "Detalle de registros asociados a la respuesta de cancelación.")
	private List<HL7CancelPrestacDetalle> detalle;

	public HL7CancelPrestacResp() {
		super();
	}

}