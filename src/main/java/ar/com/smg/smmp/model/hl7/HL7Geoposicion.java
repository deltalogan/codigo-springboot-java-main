package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Schema(name = "HL7Geoposicion",
		description =
				"DTO con información de geoposición asociada a una transacción HL7.")
public class HL7Geoposicion implements Serializable {
	@Serial private static final long serialVersionUID = 1L;
	@Schema(description = "Identificador interno del registro de geoposición.",
			example = "1")
	private int id;
	@Schema(description = "Número de transacción asociada a la geoposición.",
			example = "456789")
	private Integer transac;
	@Schema(description = "Latitud informada para la ubicación.",
			example = "-31.4201")
	private String latitud;
	@Schema(description = "Longitud informada para la ubicación.",
			example = "-64.1888")
	private String longitud;
	@Schema(description = "URL asociada a la ubicación o recurso relacionado.",
			example = "https://example.com/ubicacion/456789")
	private String url;
	@Schema(description = "Altitud informada para la ubicación.", example = "430")
	private String altitud;
	@Schema(description = "Velocidad informada en la captura de geoposición.",
			example = "0")
	private String velocidad;
	@Schema(description = "Rumbo informado en la captura de geoposición.",
			example = "180")
	private String rumbo;
	@Schema(
			description = "Precisión informada para la ubicación.", example = "10")
	private String precision;
	@Schema(description = "Fecha y hora de captura de la geoposición.",
			type = "string", format = "date-time", example = "2026-04-30T10:15:30")
	private Date timestamp;
}