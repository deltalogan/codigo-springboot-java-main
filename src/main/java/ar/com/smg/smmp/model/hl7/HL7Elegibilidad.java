package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Schema(name = "HL7Elegibilidad",
		description = "DTO de solicitud HL7 para consulta de elegibilidad.")
public class HL7Elegibilidad implements Serializable {
	@Serial private static final long serialVersionUID = -3138891198846369145L;
	@Setter
	@Getter
	@Schema(description = "Modo de operación de la solicitud HL7.", example = "A")
	private String modo;
	@Setter
	@Getter
	@Schema(description = "Credencial o identificador del beneficiario.",
			example = "1234567890")
	private String creden;
	@Schema(description = "Fecha y hora de alta de la transacción en formato HL7 "
			+ "adaptado.Admite valores compatibles con yyyy-MM-dd "
			+ "HH:mm:ss,yyyyMMdd o yyyy-MM-dd.",
			type = "string", example = "2026-04-30 10:15:30")
	@XmlJavaTypeAdapter(HL7DateAdapter.class)
	private Date alta;
	@Setter
	@Getter
	@Schema(description = "Fecha diferencial informada en la solicitud.",
			example = "20260430")
	private String fecdif;
	@Setter
	@Getter
	@Schema(description = "Indicador de procesamiento manual.", example = "N")
	private String manual;
	@Setter
	@Getter
	@Schema(
			description = "Identificador de ticket externo asociado a la operación.",
			example = "12345")
	private Integer ticketExt;
	@Setter
	@Getter
	@Schema(
			description = "Identificador de terminal origen.", example = "TERM001")
	private String termId;
	@Setter
	@Getter
	@Schema(description = "Número interno de la entidad integradora.",
			example = "1001")
	private Integer interNro;
	@Setter
	@Getter
	@Schema(description = "CUIT del prestador o emisor de la solicitud.",
			example = "30712345678")
	private String cuit;
	@Setter
	@Getter
	@Schema(description = "Matrícula de origen informada en la solicitud.",
			example = "MN12345")
	private String oriMatri;
	@Setter
	@Getter
	@Schema(description = "Indicador o número de autorización.", example = "1")
	private Integer autoriz;
	@Setter
	@Getter
	@Schema(description =
			"Código de rechazo externo informado por el sistema origen.",
			example = "0")
	private Integer rechaExt;
	public HL7Elegibilidad() {
		super();
	}
	@SuppressWarnings("unused")
	public Date getAlta() {
		return (alta != null ? (Date) alta.clone() : null);
	}
	@SuppressWarnings("unused")
	public void setAlta(Date alta) {
		this.alta = (alta != null ? (Date) alta.clone() : null);
	}
}