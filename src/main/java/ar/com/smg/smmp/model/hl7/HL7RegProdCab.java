package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "HL7RegProdCab", description = "Cabecera de respuesta HL7 para registro de producto o prestación.")
public class HL7RegProdCab implements Serializable {

	@Serial
	private static final long serialVersionUID = 630526773617124844L;

	@Schema(description = "Identificador de transacción de alta.", example = "TX202604300001")
	private String transacAlta;

	@Schema(description = "Número de transacción generado o informado por el procesamiento.", example = "456789")
	private Integer transac;

	@Schema(description = "Código de rechazo a nivel cabecera.", example = "0")
	private Integer rechaCabecera;

	@Schema(description = "Descripción del rechazo o resultado a nivel cabecera.", example = "Operación procesada correctamente")
	private String rechaCabeDeno;

	@Schema(description = "Apellido y nombre del beneficiario.", example = "JUAN PEREZ")
	private String apeNom;

	@Schema(description = "Indicador de condición gravada.", example = "N")
	private String gravado;

	@Schema(description = "Código de plan asociado al beneficiario.", example = "210")
	private String planCodi;

	@Schema(description = "Indicador relacionado con cobertura PMI.", example = "1")
	private Integer pmi;

	@Schema(description = "Sexo informado del beneficiario.", example = "M")
	private String sexo;

	@Schema(description = "Sexo utilizado para autorización automática.", example = "M")
	private String sexoAuto;

	@Schema(description = "Género utilizado para autorización automática.", example = "M")
	private String generoAuto;

	@Schema(description = "Edad del beneficiario.", example = "35")
	private Integer edad;

	@Schema(description = "Indicador o código de ley aplicable.", example = "N")
	private String leyimp;

	@Schema(description = "Descripción asociada al código ICD.", example = "DIAGNOSTICO INFORMADO")
	private String icdDeno;

	@Schema(description = "Nombre del prestador informado en la respuesta.", example = "SANATORIO CENTRAL")
	private String nomPrestad;

	@Schema(description = "Número o código de sucursal asociado a la operación.", example = "10")
	private Integer sucursal;

	@Schema(description = "Indicador o número de autorización.", example = "1")
	private Integer autoriz;

	public HL7RegProdCab() {
		super();
	}

}