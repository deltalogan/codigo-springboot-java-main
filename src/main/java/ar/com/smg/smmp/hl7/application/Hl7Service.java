package ar.com.smg.smmp.hl7.application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.com.smg.smmp.hl7.exception.HL7DuplicateException;
import ar.com.smg.smmp.hl7.exception.Hl7InexistenteException;
import ar.com.smg.smmp.hl7.exception.SMMPRuntimeException;
import ar.com.smg.smmp.hl7.persistence.mapper.ds1.Hl7Mapper;
import ar.com.smg.smmp.model.hl7.*;
@Service
public class Hl7Service {
    private final Hl7Mapper mapper;
    public Hl7Service(Hl7Mapper mapper) {
        this.mapper = mapper;
    }
    public HL7ElegibilidadResp elegibilidad(HL7Elegibilidad hl7Elegibilidad) {
        if (hl7Elegibilidad == null) {
            throw new SMMPRuntimeException("hl7Elegibilidad no puede ser nulo");
        }
        return mapper.elegibilidad(hl7Elegibilidad);
    }
    public HL7AnulaDiagnosticoResp anulaDiagnostico(
            HL7AnulaDiagnostico hl7AnulaDiagnostico) {
        if (hl7AnulaDiagnostico == null) {
            throw new SMMPRuntimeException("hl7AnulaDiagnostico no puede ser nulo");
        }
        return mapper.anulaDiagnostico(hl7AnulaDiagnostico);
    }
    @SuppressWarnings("unchecked")
    public HL7InfoDiagnosticoResp informaDiagnostico(
            HL7InfoDiagnostico hl7InfoDiagnostico) {
        if (hl7InfoDiagnostico == null) {
            throw new SMMPRuntimeException("hl7InfoDiagnostico no puede ser nulo");
        }
        HL7InfoDiagnosticoResp resp = new HL7InfoDiagnosticoResp();
        List<Object> resultMaps = mapper.informaDiagnostico(hl7InfoDiagnostico);
        if (!resultMaps.isEmpty()) {
            resp.setCabecera(
                    (HL7InfoDiagnosticoCab) findMultipleResultMapHeader(resultMaps));
            if (resultMaps.size() > 1) {
                resp.setDetalle((List<HL7InfoDiagnosticoDetalle>) resultMaps.get(1));
            }
        }
        return resp;
    }
    @SuppressWarnings("unchecked")
    public HL7ConsultaAutoResp consultaAuto(HL7ConsultaAuto hl7ConsultaAuto) {
        if (hl7ConsultaAuto == null) {
            throw new SMMPRuntimeException("hl7ConsultaAuto no puede ser nulo");
        }
        HL7ConsultaAutoResp resp = new HL7ConsultaAutoResp();
        List<Object> resultMaps = mapper.consultaAuto(hl7ConsultaAuto);
        if (!resultMaps.isEmpty()) {
            resp.setCabecera(
                    (HL7ConsultaAutoCab) findMultipleResultMapHeader(resultMaps));
            if (resultMaps.size() > 1) {
                resp.setDetalle((List<HL7ConsultaAutoDetalle>) resultMaps.get(1));
            }
        }
        return resp;
    }
    @SuppressWarnings("unchecked")
    public HL7ConsultaTotalesResp consultaTotales(
            HL7ConsultaTotales hl7ConsultaTotales) {
        if (hl7ConsultaTotales == null) {
            throw new SMMPRuntimeException("hl7ConsultaTotales no puede ser nulo");
        }
        HL7ConsultaTotalesResp resp = new HL7ConsultaTotalesResp();
        List<Object> resultMaps = mapper.consultaTotales(hl7ConsultaTotales);
        if (!resultMaps.isEmpty()) {
            resp.setCabecera(
                    (HL7ConsultaTotalesCab) findMultipleResultMapHeader(resultMaps));
            if (resultMaps.size() > 1) {
                resp.setDetalle((List<HL7ConsultaTotalesDetalle>) resultMaps.get(1));
            }
        }
        return resp;
    }
    @SuppressWarnings("unchecked")
    public HL7CancelPrestacResp cancelacionPrestaciones(
            HL7CancelPrestac hl7CancelPrestac) {
        if (hl7CancelPrestac == null) {
            throw new SMMPRuntimeException("hl7CancelPrestac no puede ser nulo");
        }
        HL7CancelPrestacResp resp = new HL7CancelPrestacResp();
        List<Object> resultMaps = mapper.cancelacionPrestaciones(hl7CancelPrestac);
        if (!resultMaps.isEmpty()) {
            resp.setCabecera(
                    (HL7CancelPrestacCab) findMultipleResultMapHeader(resultMaps));
            if (resultMaps.size() > 1) {
                resp.setDetalle((List<HL7CancelPrestacDetalle>) resultMaps.get(1));
            }
        }
        return resp;
    }
    @SuppressWarnings("unchecked")
    public HL7RegProdResp registracionProd(HL7RegProd hl7RegProd) {
        if (hl7RegProd == null) {
            throw new SMMPRuntimeException("hl7RegProd no puede ser nulo");
        }
        HL7RegProdResp resp = new HL7RegProdResp();
        List<Object> resultMaps = mapper.registracionProd(hl7RegProd);
        if (!resultMaps.isEmpty()) {
            resp.setCabecera((HL7RegProdCab) findMultipleResultMapHeader(resultMaps));
            if (resultMaps.size() > 1) {
                resp.setDetalle((List<HL7RegProdDetalle>) resultMaps.get(1));
            }
        }
        return resp;
    }
    @Transactional(readOnly = true)
    public HL7Geoposicion consultaGeoposicion(Integer codigoTx) {
        if (codigoTx == null) {
            throw new SMMPRuntimeException(
                    "hl7ConsultaGeoposicion no puede ser nulo");
        }
        HL7Geoposicion geo = mapper.consultaGeoposicion(codigoTx);
        if (geo == null) {
            throw new Hl7InexistenteException();
        }
        return geo;
    }
    @Transactional
    public HL7Geoposicion informaGeoposicion(HL7Geoposicion hl7Geoposicion) {
        if (hl7Geoposicion == null) {
            throw new SMMPRuntimeException("hl7Geoposicion no puede ser nulo");
        }
        Integer trx = hl7Geoposicion.getTransac();
        if (mapper.consultaTransaccion(trx) == null) {
            throw new Hl7InexistenteException("No se encuentra la transacción.");
        }
        if (mapper.consultaGeoposicion(trx) != null) {
            throw new HL7DuplicateException(
                    "La transacción ya tiene una geoposición asociada.");
        }
        mapper.informaGeoposicion(hl7Geoposicion);
        return mapper.consultaGeoposicion(trx);
    }
    public List<HL7ConsultaPrestacionExceptuada> consultaPrestacionExceptuada(
            HL7ConsultaPrestacionExceptuada param) {
        if (param == null) {
            throw new SMMPRuntimeException(
                    "HL7ConsultaPrestacionExceptuada no puede ser nulo");
        }
        List<HL7ConsultaPrestacionExceptuada> list =
                mapper.consultaPrestacionesExceptuadas(param);
        if (list == null) {
            throw new Hl7InexistenteException();
        }
        return list;
    }
    public ArrayList<Object> reimprimirComprobante(Integer codigoTx) {
        if (codigoTx == null) {
            throw new SMMPRuntimeException("codigoTx no puede ser nulo");
        }
        List<Object> reimprimirComprobante = mapper.impresionTransac(codigoTx);
        return wrapperComprobante(reimprimirComprobante);
    }
    @SuppressWarnings("unchecked")
    private ArrayList<Object> wrapperComprobante(
            List<Object> reimprimirComprobante) {
        ArrayList<Object> comprobantesWrapped = new ArrayList<>();
        if (reimprimirComprobante == null || reimprimirComprobante.size() < 2) {
            return comprobantesWrapped;
        }
        List<Object> cabComprobanteList =
                (List<Object>) reimprimirComprobante.get(0);
        List<Object> regProdDetalle = (List<Object>) reimprimirComprobante.get(1);
        for (Object o : cabComprobanteList) {
            Map<String, Object> comprobante = new HashMap<>();
            comprobante.put("comprobante", o);
            comprobante.put("codigos", regProdDetalle);
            comprobantesWrapped.add(comprobante);
        }
        return comprobantesWrapped;
    }
    @SuppressWarnings("unchecked")
    private Object findMultipleResultMapHeader(List<Object> resultMaps) {
        if (resultMaps == null || resultMaps.isEmpty()) {
            return null;
        }
        if (resultMaps.size() == 1) {
            return resultMaps.get(0);
        }
        List<Object> headerList = (List<Object>) resultMaps.get(0);
        if (headerList != null && !headerList.isEmpty()) {
            return headerList.get(0);
        }
        return null;
    }
}