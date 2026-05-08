package ar.com.smg.smmp.hl7.application;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ar.com.smg.smmp.hl7.exception.*;
import ar.com.smg.smmp.hl7.persistence.mapper.ds1.Hl7Mapper;
import ar.com.smg.smmp.model.hl7.*;
@ExtendWith(MockitoExtension.class)
class Hl7ServiceTest {
    @Mock private Hl7Mapper mapper;
    @InjectMocks private Hl7Service service;
    private HL7Elegibilidad elegibilidad;
    private HL7AnulaDiagnostico anulaDiagnostico;
    private HL7InfoDiagnostico informaDiagnostico;
    private HL7ConsultaAuto consultaAuto;
    private HL7ConsultaTotales consultaTotales;
    private HL7CancelPrestac cancelacion;
    private HL7RegProd registracion;
    private HL7Geoposicion geoposicion;
    @BeforeEach
    void setUp() {
        elegibilidad = new HL7Elegibilidad();
        anulaDiagnostico = new HL7AnulaDiagnostico();
        informaDiagnostico = new HL7InfoDiagnostico();
        consultaAuto = new HL7ConsultaAuto();
        consultaTotales = new HL7ConsultaTotales();
        cancelacion = new HL7CancelPrestac();
        registracion = new HL7RegProd();
        geoposicion = new HL7Geoposicion();
    }
    @Test
    void elegibilidad_deberiaLlamarMapperYRetornarRespuesta() {
        HL7ElegibilidadResp expected = new HL7ElegibilidadResp();
        when(mapper.elegibilidad(elegibilidad)).thenReturn(expected);
        HL7ElegibilidadResp result = service.elegibilidad(elegibilidad);
        assertNotNull(result);
        verify(mapper).elegibilidad(elegibilidad);
    }
    @Test
    void elegibilidad_conInputNull_deberiaLanzarSMMPRuntimeException() {
        assertThrows(SMMPRuntimeException.class, () -> service.elegibilidad(null));
    }
    @Test
    void anulaDiagnostico_deberiaLlamarMapper() {
        HL7AnulaDiagnosticoResp expected = new HL7AnulaDiagnosticoResp();
        when(mapper.anulaDiagnostico(anulaDiagnostico)).thenReturn(expected);
        HL7AnulaDiagnosticoResp result = service.anulaDiagnostico(anulaDiagnostico);
        assertNotNull(result);
        verify(mapper).anulaDiagnostico(anulaDiagnostico);
    }
    @Test
    void informaDiagnostico_deberiaParsearCabeceraYDetalleCorrectamente() {
        List<Object> resultMaps = new ArrayList<>();
        resultMaps.add(List.of(new HL7InfoDiagnosticoCab()));
        resultMaps.add(List.of(new HL7InfoDiagnosticoDetalle()));
        when(mapper.informaDiagnostico(informaDiagnostico)).thenReturn(resultMaps);
        HL7InfoDiagnosticoResp resp =
                service.informaDiagnostico(informaDiagnostico);
        assertNotNull(resp.getCabecera());
        assertNotNull(resp.getDetalle());
        assertEquals(1, resp.getDetalle().size());
    }
    @Test
    void consultaAuto_deberiaParsearMultipleResultMap() {
        List<Object> resultMaps = List.of(List.of(new HL7ConsultaAutoCab()),
                List.of(new HL7ConsultaAutoDetalle()));
        when(mapper.consultaAuto(any())).thenReturn(resultMaps);
        HL7ConsultaAutoResp resp = service.consultaAuto(consultaAuto);
        assertNotNull(resp);
    }
    @Test
    void consultaTotales_deberiaParsearCabeceraYDetalle() {
        List<Object> resultMaps = List.of(List.of(new HL7ConsultaTotalesCab()),
                List.of(new HL7ConsultaTotalesDetalle()));
        when(mapper.consultaTotales(any())).thenReturn(resultMaps);
        HL7ConsultaTotalesResp resp = service.consultaTotales(consultaTotales);
        assertNotNull(resp);
    }
    @Test
    void cancelacionPrestaciones_deberiaParsearRespuesta() {
        List<Object> resultMaps = List.of(List.of(new HL7CancelPrestacCab()),
                List.of(new HL7CancelPrestacDetalle()));
        when(mapper.cancelacionPrestaciones(any())).thenReturn(resultMaps);
        HL7CancelPrestacResp resp = service.cancelacionPrestaciones(cancelacion);
        assertNotNull(resp);
    }
    @Test
    void registracionProd_deberiaParsearRespuesta() {
        List<Object> resultMaps =
                List.of(List.of(new HL7RegProdCab()), List.of(new HL7RegProdDetalle()));
        when(mapper.registracionProd(any())).thenReturn(resultMaps);
        HL7RegProdResp resp = service.registracionProd(registracion);
        assertNotNull(resp);
    }
    @Test
    void consultaGeoposicion_cuandoExiste_deberiaRetornarGeoposicion() {
        HL7Geoposicion expected = new HL7Geoposicion();
        when(mapper.consultaGeoposicion(123)).thenReturn(expected);
        HL7Geoposicion result = service.consultaGeoposicion(123);
        assertNotNull(result);
    }
    @Test
    void
    consultaGeoposicion_cuandoNoExiste_deberiaLanzarHl7InexistenteException() {
        when(mapper.consultaGeoposicion(999)).thenReturn(null);
        assertThrows(
                Hl7InexistenteException.class, () -> service.consultaGeoposicion(999));
    }
    @Test
    void informaGeoposicion_transaccionNoExiste_deberiaLanzarExcepcion() {
        when(mapper.consultaTransaccion(isNull())).thenReturn(null);
        assertThrows(Hl7InexistenteException.class,
                () -> service.informaGeoposicion(geoposicion));
    }
    @Test
    void
    informaGeoposicion_yaExisteGeoposicion_deberiaLanzarHL7DuplicateException() {
        when(mapper.consultaTransaccion(isNull()))
                .thenReturn(new HL7ConsultaTransaccionResp());
        when(mapper.consultaGeoposicion(isNull())).thenReturn(new HL7Geoposicion());
        assertThrows(HL7DuplicateException.class,
                () -> service.informaGeoposicion(geoposicion));
    }
    @Test
    void informaGeoposicion_exitoso_deberiaGuardarYRetornar() {
        when(mapper.consultaTransaccion(isNull()))
                .thenReturn(new HL7ConsultaTransaccionResp());
        when(mapper.consultaGeoposicion(isNull()))
                .thenReturn(null)
                .thenReturn(new HL7Geoposicion());
        HL7Geoposicion result = service.informaGeoposicion(geoposicion);
        assertNotNull(result);
        verify(mapper).informaGeoposicion(geoposicion);
    }
    @Test
    void reimprimirComprobante_deberiaRetornarListaEnvueltaCorrectamente() {
        List<Object> mockResult =
                Arrays.asList(List.of(new Object()), List.of(new Object()));
        when(mapper.impresionTransac(100)).thenReturn(mockResult);
        ArrayList<Object> result = service.reimprimirComprobante(100);
        assertFalse(result.isEmpty());
    }
    @Test
    void consultaPrestacionExceptuada_conParamNull_deberiaLanzarExcepcion() {
        assertThrows(SMMPRuntimeException.class,
                () -> service.consultaPrestacionExceptuada(null));
    }
    @Test
    void consultaPrestacionExceptuada_deberiaRetornarLista() {
        List<HL7ConsultaPrestacionExceptuada> expected =
                List.of(new HL7ConsultaPrestacionExceptuada());
        when(mapper.consultaPrestacionesExceptuadas(any())).thenReturn(expected);
        List<HL7ConsultaPrestacionExceptuada> result =
                service.consultaPrestacionExceptuada(
                        new HL7ConsultaPrestacionExceptuada());
        assertEquals(1, result.size());
    }
}