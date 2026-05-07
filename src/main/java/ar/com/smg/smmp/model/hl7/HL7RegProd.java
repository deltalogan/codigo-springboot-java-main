package ar.com.smg.smmp.model.hl7;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "HL7RegProd", description = "DTO de solicitud HL7 para registro de producto o prestación.")
public class HL7RegProd implements Serializable {

	@Serial
	private static final long serialVersionUID = 4991377569526175748L;

	@Setter
    @Getter
    @Schema(description = "Modo de operación de la solicitud HL7.", example = "A")
	private String modo;

	@Setter
    @Getter
    @Schema(description = "Credencial o identificador del beneficiario.", example = "1234567890")
	private String creden;

	@Setter
    @Getter
    @Schema(description = "Tipo de operación o mensaje.", example = "1")
	private Integer tipo;

	@Schema(description = "Fecha y hora de alta de la transacción en formato HL7 adaptado. Admite valores compatibles con yyyy-MM-dd HH:mm:ss, yyyyMMdd o yyyy-MM-dd.", type = "string", example = "2026-04-30 10:15:30")
	@XmlJavaTypeAdapter(HL7DateAdapter.class)
	private Date alta;

	@Setter
    @Getter
    @Schema(description = "Fecha diferencial informada en la solicitud.", example = "20260430")
	private String fecdif;

	@Setter
    @Getter
    @Schema(description = "Indicador de procesamiento manual.", example = "N")
	private String manual;

	@Setter
    @Getter
    @Schema(description = "Identificador de ticket externo asociado a la operación.", example = "12345")
	private Integer ticketExt;

	@Setter
    @Getter
    @Schema(description = "Identificador de terminal origen.", example = "TERM001")
	private String termId;

	@Setter
    @Getter
    @Schema(description = "Número interno de la entidad integradora.", example = "1001")
	private Integer interNro;

	@Setter
    @Getter
    @Schema(description = "CUIT del prestador o emisor de la solicitud.", example = "30712345678")
	private String cuit;

	@Setter
    @Getter
    @Schema(description = "Matrícula de origen informada en la solicitud.", example = "MN12345")
	private String oriMatri;

	@Setter
    @Getter
    @Schema(description = "Indicador o número de autorización.", example = "1")
	private Integer autoriz;

	@Setter
    @Getter
    @Schema(description = "Código ICD informado en la solicitud.", example = "J189")
	private String icd;

	@Setter
    @Getter
    @Schema(description = "Código de rechazo externo informado por el sistema origen.", example = "0")
	private Integer rechaExt;

	@Setter
    @Getter
    @Schema(description = "Parámetro adicional 1 utilizado por la integración.", example = "VALOR1")
	private String param1;

	@Setter
    @Getter
    @Schema(description = "Parámetro adicional 2 utilizado por la integración.", example = "VALOR2")
	private String param2;

	@Setter
    @Getter
    @Schema(description = "Parámetro adicional 3 utilizado por la integración.", example = "VALOR3")
	private String param3;

	@Setter
    @Getter
    @Schema(description = "Tipo de efector informado en la solicitud.", example = "PRESTADOR")
	private String tipoEfector;

	@Setter
    @Getter
    @Schema(description = "Identificador del efector.", example = "EF001")
	private String idEfector;

	@Setter
    @Getter
    @Schema(description = "Tipo de prescriptor informado en la solicitud.", example = "MEDICO")
	private String tipoPrescr;

	@Setter
    @Getter
    @Schema(description = "Identificador del prescriptor.", example = "MP12345")
	private String idPrescr;

	@Setter
    @Getter
    @Schema(description = "Identificador único de mensaje.", example = "MSG-20260430-0001")
	private String msgId;

	@Setter
    @Getter
    @Schema(description = "Código de aceptación del ACK.", example = "AA")
	private String ackacept;

	@Setter
    @Getter
    @Schema(description = "Código de aplicación del ACK.", example = "CA")
	private String ackackapl;

	@Setter
    @Getter
    @Schema(description = "Texto o código de consulta asociado a la operación.", example = "REGISTRO")
	private String consulta;

	@Setter
    @Getter
    @Schema(description = "Código de rechazo agregado a nivel cabecera.", example = "0")
	private Integer agRechaCabe;

	@Setter
    @Getter
    @Schema(description = "Código de rechazo agregado.", example = "0")
	private Integer agRecha;

	@Setter
    @Getter
    @Schema(description = "Tipo de mensaje HL7 informado.", example = "ORM")
	private String tipoMensaje;

	@Setter
    @Getter
    @Schema(description = "Indicador de origen o compatibilidad con PowerBuilder.", example = "false")
	private Boolean powerBuilder;

	public HL7RegProd() {
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