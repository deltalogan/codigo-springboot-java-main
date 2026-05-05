package ar.com.smg.smmp.hl7.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import ar.com.smg.payroll.PayrollApplication;
import ar.com.smg.smmp.hl7.application.Hl7Service;
import ar.com.smg.smmp.hl7.exception.HL7DuplicateException;
import ar.com.smg.smmp.hl7.exception.Hl7InexistenteException;
import ar.com.smg.smmp.model.hl7.HL7AnulaDiagnosticoResp;
import ar.com.smg.smmp.model.hl7.HL7ConsultaPrestacionExceptuada;
import ar.com.smg.smmp.model.hl7.HL7ElegibilidadResp;
import ar.com.smg.smmp.model.hl7.HL7Geoposicion;

@WebMvcTest(Hl7Controller.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = PayrollApplication.class)
class Hl7ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("unused")
    @MockBean
    private Hl7Service service;

    private static final String JSON = "{}";

    @Test
    void elegibilidad_deberiaRetornar200OK() throws Exception {
        when(service.elegibilidad(any()))
                .thenReturn(new HL7ElegibilidadResp());

        mockMvc.perform(post("/api/elegibilidad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON))
                .andExpect(status().isOk());
    }

    @Test
    void anulaDiagnostico_deberiaRetornar200OK() throws Exception {
        when(service.anulaDiagnostico(any()))
                .thenReturn(new HL7AnulaDiagnosticoResp());

        mockMvc.perform(post("/api/anula-diagnostico")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON))
                .andExpect(status().isOk());
    }

    @Test
    void informaGeoposicion_exito_deberiaRetornar200() throws Exception {
        when(service.informaGeoposicion(any()))
                .thenReturn(new HL7Geoposicion());

        mockMvc.perform(post("/api/informa-geoposicion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON))
                .andExpect(status().isOk());
    }

    @Test
    void informaGeoposicion_inexistente_deberiaRetornar404() throws Exception {
        when(service.informaGeoposicion(any()))
                .thenThrow(new Hl7InexistenteException());

        mockMvc.perform(post("/api/informa-geoposicion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void informaGeoposicion_duplicate_deberiaRetornar400() throws Exception {
        when(service.informaGeoposicion(any()))
                .thenThrow(new HL7DuplicateException("duplicado"));

        mockMvc.perform(post("/api/informa-geoposicion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void consultaGeoposicion_exito_deberiaRetornar200() throws Exception {
        when(service.consultaGeoposicion(any(Integer.class)))
                .thenReturn(new HL7Geoposicion());

        mockMvc.perform(get("/api/consulta-geoposicion/123"))
                .andExpect(status().isOk());
    }

    @Test
    void consultaGeoposicion_inexistente_deberiaRetornar404() throws Exception {
        when(service.consultaGeoposicion(any(Integer.class)))
                .thenThrow(new Hl7InexistenteException());

        mockMvc.perform(get("/api/consulta-geoposicion/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void reimprimirComprobante_deberiaRetornar200() throws Exception {
        when(service.reimprimirComprobante(any(Integer.class)))
                .thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/comprobantes/100"))
                .andExpect(status().isOk());
    }

    @Test
    void getVersion_deberiaRetornar200() throws Exception {
        mockMvc.perform(get("/api/version"))
                .andExpect(status().isOk());
    }

    @Test
    void consultaPrestacionesExceptuadas_deberiaRetornar200() throws Exception {
        when(service.consultaPrestacionExceptuada(any()))
                .thenReturn(List.of(new HL7ConsultaPrestacionExceptuada()));

        mockMvc.perform(get("/api/consulta-prestaciones-exceptuadas"))
                .andExpect(status().isOk());
    }
}