package ar.com.smg.smmp.hl7.persistence.mapper.ds1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ar.com.smg.smmp.model.hl7.*;

public interface Hl7Mapper {

    HL7ElegibilidadResp elegibilidad(HL7Elegibilidad hl7Elegibilidad);
    HL7AnulaDiagnosticoResp anulaDiagnostico(HL7AnulaDiagnostico hl7AnulaDiagnostico);
    List<Object> informaDiagnostico(HL7InfoDiagnostico hl7InfoDiagnostico);
    List<Object> consultaAuto(HL7ConsultaAuto hl7ConsultaAuto);
    List<Object> consultaTotales(HL7ConsultaTotales hl7ConsultaTotales);
    List<Object> cancelacionPrestaciones(HL7CancelPrestac hl7CancelPrestac);
    List<Object> registracionProd(HL7RegProd hl7RegProd);
    List<Object> impresionTransac(@Param("codigoTx") Integer codigoTx);
    HL7Geoposicion consultaGeoposicion(@Param("codigoTx") Integer codigoTx);
    @SuppressWarnings("UnusedReturnValue")
    HL7Geoposicion informaGeoposicion(HL7Geoposicion hl7Geoposicion);
    HL7ConsultaTransaccionResp consultaTransaccion(@Param("trx") Integer trx);
    List<HL7ConsultaPrestacionExceptuada> consultaPrestacionesExceptuadas(HL7ConsultaPrestacionExceptuada consultaPrestacionExceptuada);
}