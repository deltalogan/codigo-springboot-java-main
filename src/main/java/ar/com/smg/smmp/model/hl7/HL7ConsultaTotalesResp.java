package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Schema(name = "HL7ConsultaTotalesResp",
		description = "DTO de respuesta HL7 para consulta de totales.")
public class HL7ConsultaTotalesResp implements Serializable {
	@Serial private static final long serialVersionUID = 7752293056699677485L;
	@Schema(description = "Cabecera de la respuesta de consulta de totales.")
	private HL7ConsultaTotalesCab cabecera;
	@Schema(description = "Detalle de registros asociados a la respuesta de "
			+ "consulta de totales.")
	private List<HL7ConsultaTotalesDetalle> detalle;
	public HL7ConsultaTotalesResp() {
		super();
	}
}