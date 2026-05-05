package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7ConsultaTransaccionResp", description = "DTO de respuesta HL7 para consulta de transacción.")
public class HL7ConsultaTransaccionResp implements Serializable{

	private static final long serialVersionUID = -9056664733362225747L;

	@Schema(description = "Número de transacción.", example = "456789")
	private Integer transac;

	@Schema(description = "Tipo de transacción informado en la respuesta.", example = "AUT")
	private String tranTipo;

	@Schema(description = "Identificador de terminal asociado a la transacción.", example = "TERM001")
	private String termId;

	@Schema(description = "Código de lugar asociado a la transacción.", example = "1")
	private Integer lugar;

	@Schema(description = "Código de prepaga asociado a la transacción.", example = "210")
	private Integer prepaga;

	@Schema(description = "Dato de contrato o contraparte informado en la transacción.", example = "CONTRATO01")
	private String contra;

	@Schema(description = "Identificador o código de integración asociado.", example = "INT001")
	private String inte;

	@Schema(description = "Credencial o identificador del beneficiario.", example = "1234567890")
	private String creden;

	@Schema(description = "Dato de lectura asociado a la transacción.", example = "MANUAL")
	private String lectura;

	@Schema(description = "Fecha y hora de la transacción.", type = "string", format = "date-time", example = "2026-04-30T10:15:30")
	private Date fecha;

	@Schema(description = "Código nomenclador asociado a la prestación.", example = "420101")
	private Integer nomen;

	@Schema(description = "Código de prestación asociado a la transacción.", example = "CONSULTA")
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

	@Schema(description = "Código ICD asociado a la transacción.", example = "J189")
	private String icd;

	@Schema(description = "Indicador de urgencia.", example = "N")
	private String urgen;

	@Schema(description = "Categoría asociada a la transacción.", example = "2")
	private Integer cate;

	@Schema(description = "Descripción del copago.", example = "COPAGO FIJO")
	private String descriCopa;

	@Schema(description = "Valor del copago.", example = "250")
	private Integer valorCopa;

	@Schema(description = "Indicador o modalidad de pago de copago.", example = "EFECTIVO")
	private String pagoCopa;

	@Schema(description = "Indicador asociado a insumo.", example = "0")
	private Integer insu;

	@Schema(description = "Dato de consulta clínica asociado a la transacción.", example = "CONSULTA GENERAL")
	private String consClin;

	@Schema(description = "Código de plan asociado al beneficiario.", example = "210")
	private String planCodi;

	@Schema(description = "Código de grupo médico.", example = "15")
	private Integer mediGrupo;

	@Schema(description = "Código de cobertura.", example = "1")
	private Integer cober;

	@Schema(description = "Código de error de cobertura.", example = "0")
	private Integer erroCober;

	@Schema(description = "Código de grupo asociado a la transacción.", example = "5")
	private Integer grupo;

	@Schema(description = "Fecha desde la cual aplica un tope.", type = "string", format = "date-time", example = "2026-04-01T00:00:00")
	private Date topeDesde;

	@Schema(description = "Valor real asociado a la transacción.", example = "1000")
	private Integer realValor;

	@Schema(description = "Código de convenio.", example = "20")
	private Integer conve;

	@Schema(description = "Código de rechazo asociado a la transacción.", example = "0")
	private Integer recha;

	@Schema(description = "Número de transacción de referencia.", example = "456700")
	private Integer transacRef;

	@Schema(description = "Código de oficina.", example = "3")
	private Integer ofi;

	@Schema(description = "Código o número de expediente.", example = "1200")
	private Integer expe;

	@Schema(description = "Fecha y hora de baja asociada a la transacción.", type = "string", format = "date-time", example = "2026-04-30T12:00:00")
	private Date bajaBecha;

	@Schema(description = "Número de transacción relacionada.", example = "456701")
	private Integer transacRela;

	@Schema(description = "Identificador de ticket externo.", example = "12345")
	private Integer ticketExt;

	@Schema(description = "Número interno de la entidad integradora.", example = "1001")
	private Integer interNro;

	@Schema(description = "Identificador de ticket externo del ítem.", example = "1")
	private Integer ticketItemExt;

	@Schema(description = "Código o característica asociada a la transacción.", example = "A")
	private String cara;

	@Schema(description = "Número de pieza asociado a la transacción.", example = "1")
	private Integer pieza;

	@Schema(description = "Estado actual de la transacción.", example = "ACTIVA")
	private String estado;

	@Schema(description = "Usuario asociado a la operación.", example = "usuario.api")
	private String usuario;


	public Integer getTransac() {
		return transac;
	}
	public void setTransac(Integer transac) {
		this.transac = transac;
	}
	public String getTranTipo() {
		return tranTipo;
	}
	public void setTranTipo(String tranTipo) {
		this.tranTipo = tranTipo;
	}
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}
	public Integer getLugar() {
		return lugar;
	}
	public void setLugar(Integer lugar) {
		this.lugar = lugar;
	}
	public Integer getPrepaga() {
		return prepaga;
	}
	public void setPrepaga(Integer prepaga) {
		this.prepaga = prepaga;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public String getInte() {
		return inte;
	}
	public void setInte(String inte) {
		this.inte = inte;
	}
	public String getCreden() {
		return creden;
	}
	public void setCreden(String creden) {
		this.creden = creden;
	}
	public String getLectura() {
		return lectura;
	}
	public void setLectura(String lectura) {
		this.lectura = lectura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getNomen() {
		return nomen;
	}
	public void setNomen(Integer nomen) {
		this.nomen = nomen;
	}
	public String getPrestac() {
		return prestac;
	}
	public void setPrestac(String prestac) {
		this.prestac = prestac;
	}
	public Integer getCanti() {
		return canti;
	}
	public void setCanti(Integer canti) {
		this.canti = canti;
	}
	public Integer getOriPrestad() {
		return oriPrestad;
	}
	public void setOriPrestad(Integer oriPrestad) {
		this.oriPrestad = oriPrestad;
	}
	public String getOriMatriNaci() {
		return oriMatriNaci;
	}
	public void setOriMatriNaci(String oriMatriNaci) {
		this.oriMatriNaci = oriMatriNaci;
	}
	public String getOriMatriProv() {
		return oriMatriProv;
	}
	public void setOriMatriProv(String oriMatriProv) {
		this.oriMatriProv = oriMatriProv;
	}
	public Integer getSucur() {
		return sucur;
	}
	public void setSucur(Integer sucur) {
		this.sucur = sucur;
	}
	public Integer getAuto() {
		return auto;
	}
	public void setAuto(Integer auto) {
		this.auto = auto;
	}
	public String getIcd() {
		return icd;
	}
	public void setIcd(String icd) {
		this.icd = icd;
	}
	public String getUrgen() {
		return urgen;
	}
	public void setUrgen(String urgen) {
		this.urgen = urgen;
	}
	public Integer getCate() {
		return cate;
	}
	public void setCate(Integer cate) {
		this.cate = cate;
	}
	public String getDescriCopa() {
		return descriCopa;
	}
	public void setDescriCopa(String descriCopa) {
		this.descriCopa = descriCopa;
	}
	public Integer getValorCopa() {
		return valorCopa;
	}
	public void setValorCopa(Integer valorCopa) {
		this.valorCopa = valorCopa;
	}
	public String getPagoCopa() {
		return pagoCopa;
	}
	public void setPagoCopa(String pagoCopa) {
		this.pagoCopa = pagoCopa;
	}
	public Integer getInsu() {
		return insu;
	}
	public void setInsu(Integer insu) {
		this.insu = insu;
	}
	public String getConsClin() {
		return consClin;
	}
	public void setConsClin(String consClin) {
		this.consClin = consClin;
	}
	public String getPlanCodi() {
		return planCodi;
	}
	public void setPlanCodi(String planCodi) {
		this.planCodi = planCodi;
	}
	public Integer getMediGrupo() {
		return mediGrupo;
	}
	public void setMediGrupo(Integer mediGrupo) {
		this.mediGrupo = mediGrupo;
	}
	public Integer getCober() {
		return cober;
	}
	public void setCober(Integer cober) {
		this.cober = cober;
	}
	public Integer getErroCober() {
		return erroCober;
	}
	public void setErroCober(Integer erroCober) {
		this.erroCober = erroCober;
	}
	public Integer getGrupo() {
		return grupo;
	}
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}
	public Date getTopeDesde() {
		return topeDesde;
	}
	public void setTopeDesde(Date topeDesde) {
		this.topeDesde = topeDesde;
	}
	public Integer getRealValor() {
		return realValor;
	}
	public void setRealValor(Integer realValor) {
		this.realValor = realValor;
	}
	public Integer getConve() {
		return conve;
	}
	public void setConve(Integer conve) {
		this.conve = conve;
	}
	public Integer getRecha() {
		return recha;
	}
	public void setRecha(Integer recha) {
		this.recha = recha;
	}
	public Integer getTransacRef() {
		return transacRef;
	}
	public void setTransacRef(Integer transacRef) {
		this.transacRef = transacRef;
	}
	public Integer getOfi() {
		return ofi;
	}
	public void setOfi(Integer ofi) {
		this.ofi = ofi;
	}
	public Integer getExpe() {
		return expe;
	}
	public void setExpe(Integer expe) {
		this.expe = expe;
	}
	public Date getBajaBecha() {
		return bajaBecha;
	}
	public void setBajaBecha(Date bajaBecha) {
		this.bajaBecha = bajaBecha;
	}
	public Integer getTransacRela() {
		return transacRela;
	}
	public void setTransacRela(Integer transacRela) {
		this.transacRela = transacRela;
	}
	public Integer getTicketExt() {
		return ticketExt;
	}
	public void setTicketExt(Integer ticketExt) {
		this.ticketExt = ticketExt;
	}
	public Integer getInterNro() {
		return interNro;
	}
	public void setInterNro(Integer interNro) {
		this.interNro = interNro;
	}
	public Integer getTicketItemExt() {
		return ticketItemExt;
	}
	public void setTicketItemExt(Integer ticketItemExt) {
		this.ticketItemExt = ticketItemExt;
	}
	public String getCara() {
		return cara;
	}
	public void setCara(String cara) {
		this.cara = cara;
	}
	public Integer getPieza() {
		return pieza;
	}
	public void setPieza(Integer pieza) {
		this.pieza = pieza;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}