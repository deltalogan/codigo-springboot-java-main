package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Schema(name = "HL7CancelPrestacCab",
		description = "Cabecera de respuesta HL7 para cancelación de prestación.")
public class HL7CancelPrestacCab implements Serializable {
	@Serial private static final long serialVersionUID = -4507793412475511777L;
	@Schema(description = "Identificador de transacción de alta.",
			example = "TX202604300001")
	private String transacAlta;
	@Schema(
			description =
					"Número de transacción generado o informado por el procesamiento.",
			example = "456789")
	private Integer transac;
	@Schema(description = "Código de rechazo a nivel cabecera.", example = "0")
	private Integer rechaCabecera;
	@Schema(description = "Descripción del rechazo o resultado a nivel cabecera.",
			example = "Operación procesada correctamente")
	private String rechaCabeDeno;
	@Schema(description = "Apellido y nombre del beneficiario.",
			example = "JUAN PEREZ")
	private String apeNom;
	@Schema(description = "Indicador de condición gravada.", example = "N")
	private String gravado;
	@Schema(
			description = "Código de plan asociado al beneficiario.", example = "210")
	private String planCodi;
	@Schema(
			description = "Indicador relacionado con cobertura PMI.", example = "1")
	private Integer pmi;
	@Schema(description = "Sexo informado del beneficiario.", example = "M")
	private String sexo;
	@Schema(description = "Edad del beneficiario.", example = "35")
	private Integer edad;
	@Schema(description = "Indicador o código de ley aplicable.", example = "N")
	private String leyimp;
	public HL7CancelPrestacCab() {
		super();
	}
}