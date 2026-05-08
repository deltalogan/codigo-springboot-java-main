package ar.com.smg.smmp.model.hl7;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Schema(name = "HL7ConsultaTransaccionResp",
		description = "DTO de respuesta HL7 para consulta de transacción.")
public class HL7ConsultaTransaccionResp implements Serializable {
	@Serial private static final long serialVersionUID = -9056664733362225747L;
	@Schema(description = "Número de transacción.", example = "456789")
	private Integer transac;
	@Schema(description = "Tipo de transacción informado en la respuesta.",
			example = "AUT")
	private String tranTipo;
	@Schema(description = "Identificador de terminal asociado a la transacción.",
			example = "TERM001")
	private String termId;
	@Schema(
			description = "Código de lugar asociado a la transacción.", example = "1")
	private Integer lugar;
	@Schema(description = "Código de prepaga asociado a la transacción.",
			example = "210")
	private Integer prepaga;
	@Schema(description =
			"Dato de contrato o contraparte informado en la transacción.",
			example = "CONTRATO01")
	private String contra;
	@Schema(description = "Identificador o código de integración asociado.",
			example = "INT001")
	private String inte;
	@Schema(description = "Credencial o identificador del beneficiario.",
			example = "1234567890")
	private String creden;
	@Schema(description = "Dato de lectura asociado a la transacción.",
			example = "MANUAL")
	private String lectura;
	@Schema(description = "Fecha y hora de la transacción.", type = "string",
			format = "date-time", example = "2026-04-30T10:15:30")
	private Date fecha;
	@Schema(description = "Código nomenclador asociado a la prestación.",
			example = "420101")
	private Integer nomen;
	@Schema(description = "Código de prestación asociado a la transacción.",
			example = "CONSULTA")
	private String prestac;
	@Schema(description = "Cantidad asociada a la transacción.", example = "1")
	private Integer canti;
	@Schema(description = "Código de prestador de origen.", example = "100")
	private Integer oriPrestad;
	@Schema(description = "Matrícula nacional de origen.", example = "MN12345")
	private String oriMatriNaci;
	@Schema(description = "Matrícula provincial de origen.", example = "MP67890")
	private String oriMatriProv;
	@Schema(description = "Código o número de sucursal.", example = "10")
	private Integer sucur;
	@Schema(description = "Indicador o número de autorización.", example = "1")
	private Integer auto;
	@Schema(
			description = "Código ICD asociado a la transacción.", example = "J189")
	private String icd;
	@Schema(description = "Indicador de urgencia.", example = "N")
	private String urgen;
	@Schema(description = "Categoría asociada a la transacción.", example = "2")
	private Integer cate;
	@Schema(description = "Descripción del copago.", example = "COPAGO FIJO")
	private String descriCopa;
	@Schema(description = "Valor del copago.", example = "250")
	private Integer valorCopa;
	@Schema(description = "Indicador o modalidad de pago de copago.",
			example = "EFECTIVO")
	private String pagoCopa;
	@Schema(description = "Indicador asociado a insumo.", example = "0")
	private Integer insu;
	@Schema(description = "Dato de consulta clínica asociado a la transacción.",
			example = "CONSULTA GENERAL")
	private String consClin;
	@Schema(
			description = "Código de plan asociado al beneficiario.", example = "210")
	private String planCodi;
	@Schema(description = "Código de grupo médico.", example = "15")
	private Integer mediGrupo;
	@Schema(description = "Código de cobertura.", example = "1")
	private Integer cober;
	@Schema(description = "Código de error de cobertura.", example = "0")
	private Integer erroCober;
	@Schema(
			description = "Código de grupo asociado a la transacción.", example = "5")
	private Integer grupo;
	@Schema(description = "Fecha desde la cual aplica un tope.", type = "string",
			format = "date-time", example = "2026-04-01T00:00:00")
	private Date topeDesde;
	@Schema(
			description = "Valor real asociado a la transacción.", example = "1000")
	private Integer realValor;
	@Schema(description = "Código de convenio.", example = "20")
	private Integer conve;
	@Schema(description = "Código de rechazo asociado a la transacción.",
			example = "0")
	private Integer recha;
	@Schema(
			description = "Número de transacción de referencia.", example = "456700")
	private Integer transacRef;
	@Schema(description = "Código de oficina.", example = "3")
	private Integer ofi;
	@Schema(description = "Código o número de expediente.", example = "1200")
	private Integer expe;
	@Schema(description = "Fecha y hora de baja asociada a la transacción.",
			type = "string", format = "date-time", example = "2026-04-30T12:00:00")
	private Date bajaBecha;
	@Schema(
			description = "Número de transacción relacionada.", example = "456701")
	private Integer transacRela;
	@Schema(description = "Identificador de ticket externo.", example = "12345")
	private Integer ticketExt;
	@Schema(description = "Número interno de la entidad integradora.",
			example = "1001")
	private Integer interNro;
	@Schema(
			description = "Identificador de ticket externo del ítem.", example = "1")
	private Integer ticketItemExt;
	@Schema(description = "Código o característica asociada a la transacción.",
			example = "A")
	private String cara;
	@Schema(
			description = "Número de pieza asociado a la transacción.", example = "1")
	private Integer pieza;
	@Schema(description = "Estado actual de la transacción.", example = "ACTIVA")
	private String estado;
	@Schema(
			description = "Usuario asociado a la operación.", example = "usuario.api")
	private String usuario;
}