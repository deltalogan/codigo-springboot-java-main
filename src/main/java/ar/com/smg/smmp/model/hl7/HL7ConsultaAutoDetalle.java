package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7ConsultaAutoDetalle", description = "Detalle de respuesta HL7 para consulta de autorizaciones automáticas.")
public class HL7ConsultaAutoDetalle implements Serializable {

	@Serial
	private static final long serialVersionUID = -8897985909658520002L;

	@Schema(description = "Número de transacción asociado al ítem de la respuesta.", example = "456789")
	private Integer transac;

	@Schema(description = "Cantidad asociada al ítem.", example = "1")
	private Integer canti;

	@Schema(description = "Código de rechazo o resultado del ítem.", example = "0")
	private Integer recha;

	@Schema(description = "Descripción del resultado o rechazo del ítem.", example = "Ítem procesado correctamente")
	private String denoItem;

	@Schema(description = "Valor de copago asociado al ítem.", example = "250.00")
	private BigDecimal valorCopa;

	public HL7ConsultaAutoDetalle() {
		super();
	}

}