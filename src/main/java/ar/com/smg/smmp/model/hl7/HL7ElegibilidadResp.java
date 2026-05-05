package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7ElegibilidadResp", description = "DTO de respuesta HL7 para consulta de elegibilidad.")
public class HL7ElegibilidadResp implements Serializable {

	private static final long serialVersionUID = -6500989855869348394L;

	@Schema(description = "Identificador de transacción de alta.", example = "TX202604300001")
	private String transacAlta;

	@Schema(description = "Número de transacción generado o informado por el procesamiento.", example = "456789")
	private Integer transac;

	@Schema(description = "Código de rechazo a nivel cabecera.", example = "0")
	private Integer rechaCabecera;

	@Schema(description = "Descripción del rechazo de cabecera.", example = "Operación procesada correctamente")
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

	public HL7ElegibilidadResp() {
		super();
	}

	public String getTransacAlta() {
		return transacAlta;
	}

	public void setTransacAlta(String transacAlta) {
		this.transacAlta = transacAlta;
	}

	public Integer getTransac() {
		return transac;
	}

	public void setTransac(Integer transac) {
		this.transac = transac;
	}

	public Integer getRechaCabecera() {
		return rechaCabecera;
	}

	public void setRechaCabecera(Integer rechaCabecera) {
		this.rechaCabecera = rechaCabecera;
	}

	public String getRechaCabeDeno() {
		return rechaCabeDeno;
	}

	public void setRechaCabeDeno(String rechaCabeDeno) {
		this.rechaCabeDeno = rechaCabeDeno;
	}

	public String getApeNom() {
		return apeNom;
	}

	public void setApeNom(String apeNom) {
		this.apeNom = apeNom;
	}

	public String getGravado() {
		return gravado;
	}

	public void setGravado(String gravado) {
		this.gravado = gravado;
	}

	public String getPlanCodi() {
		return planCodi;
	}

	public void setPlanCodi(String planCodi) {
		this.planCodi = planCodi;
	}

	public Integer getPmi() {
		return pmi;
	}

	public void setPmi(Integer pmi) {
		this.pmi = pmi;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexoAuto() {
		return sexoAuto;
	}

	public void setSexoAuto(String sexoAuto) {
		this.sexoAuto = sexoAuto;
	}

	public String getGeneroAuto() {
		return generoAuto;
	}

	public void setGeneroAuto(String generoAuto) {
		this.generoAuto = generoAuto;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getLeyimp() {
		return leyimp;
	}

	public void setLeyimp(String leyimp) {
		this.leyimp = leyimp;
	}

	public String getIcdDeno() {
		return icdDeno;
	}

	public void setIcdDeno(String icdDeno) {
		this.icdDeno = icdDeno;
	}
}