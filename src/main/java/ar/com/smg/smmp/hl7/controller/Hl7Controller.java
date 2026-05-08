package ar.com.smg.smmp.hl7.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import ar.com.smg.smmp.hl7.application.Hl7Service;
import ar.com.smg.smmp.hl7.exception.HL7DuplicateException;
import ar.com.smg.smmp.hl7.exception.Hl7InexistenteException;
import ar.com.smg.smmp.model.hl7.*;
@RestController
@RequestMapping("/api")
@Tag(name = "HL7 SMMP",
        description =
                "Servicios HL7 para el Sistema de Gestión de Prestaciones Médicas")
public class Hl7Controller {
    private final Hl7Service service;
    public Hl7Controller(Hl7Service service) {
        this.service = service;
    }
    @Operation(summary = "Consulta de Elegibilidad",
            description = "Verifica la elegibilidad de un afiliado")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Elegibilidad consultada correctamente",
                            content = @Content(
                                    schema = @Schema(implementation = HL7ElegibilidadResp.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PostMapping("/elegibilidad")
    public ResponseEntity<HL7ElegibilidadResp>
    elegibilidad(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la solicitud de elegibilidad HL7",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = HL7Elegibilidad.class)))
                 @RequestBody @Schema(implementation = HL7Elegibilidad.class)
                 HL7Elegibilidad hl7Elegibilidad) {
        if (hl7Elegibilidad == null) {
            return ResponseEntity.badRequest().build();
        }
        HL7ElegibilidadResp response = service.elegibilidad(hl7Elegibilidad);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Anula Diagnóstico",
            description = "Anula un diagnóstico previamente informado")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Diagnóstico anulado correctamente",
                            content =
                            @Content(schema = @Schema(
                                    implementation = HL7AnulaDiagnosticoResp.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PostMapping("/anula-diagnostico")
    public ResponseEntity<HL7AnulaDiagnosticoResp>
    anulaDiagnostico(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la solicitud de anulación de diagnóstico HL7",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = HL7AnulaDiagnostico.class)))
                     @RequestBody HL7AnulaDiagnostico hl7AnulaDiagnostico) {
        if (hl7AnulaDiagnostico == null) {
            return ResponseEntity.badRequest().build();
        }
        HL7AnulaDiagnosticoResp response =
                service.anulaDiagnostico(hl7AnulaDiagnostico);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Informa Diagnóstico",
            description = "Informa un nuevo diagnóstico")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Diagnóstico informado correctamente",
                            content =
                            @Content(schema = @Schema(
                                    implementation = HL7InfoDiagnosticoResp.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PostMapping("/informa-diagnostico")
    public ResponseEntity<HL7InfoDiagnosticoResp>
    informaDiagnostico(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la solicitud de información de diagnóstico HL7",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = HL7InfoDiagnostico.class)))
                       @RequestBody HL7InfoDiagnostico hl7InfoDiagnostico) {
        if (hl7InfoDiagnostico == null) {
            return ResponseEntity.badRequest().build();
        }
        HL7InfoDiagnosticoResp response =
                service.informaDiagnostico(hl7InfoDiagnostico);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Consulta Autorización",
            description = "Consulta el estado de una autorización")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Consulta de autorización realizada correctamente",
                            content = @Content(
                                    schema = @Schema(implementation = HL7ConsultaAutoResp.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PostMapping("/consulta-autoriz")
    public ResponseEntity<HL7ConsultaAutoResp>
    consultaAuto(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la solicitud de consulta de autorización HL7",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = HL7ConsultaAuto.class)))
                 @RequestBody HL7ConsultaAuto hl7ConsultaAuto) {
        if (hl7ConsultaAuto == null) {
            return ResponseEntity.badRequest().build();
        }
        HL7ConsultaAutoResp response = service.consultaAuto(hl7ConsultaAuto);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Consulta Totales",
            description = "Consulta totales de prestaciones en un período")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Consulta de totales realizada correctamente",
                            content =
                            @Content(schema = @Schema(
                                    implementation = HL7ConsultaTotalesResp.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PostMapping("/consulta-totales")
    public ResponseEntity<HL7ConsultaTotalesResp>
    consultaTotales(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la solicitud de consulta de totales HL7",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = HL7ConsultaTotales.class)))
                    @RequestBody HL7ConsultaTotales hl7ConsultaTotales) {
        if (hl7ConsultaTotales == null) {
            return ResponseEntity.badRequest().build();
        }
        HL7ConsultaTotalesResp response =
                service.consultaTotales(hl7ConsultaTotales);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Cancelación de Prestaciones",
            description = "Cancela una o más prestaciones")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Prestaciones canceladas correctamente",
                            content = @Content(
                                    schema = @Schema(implementation = HL7CancelPrestacResp.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PostMapping("/cancelacion-prestaciones")
    public ResponseEntity<HL7CancelPrestacResp>
    cancelacionPrestaciones(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la solicitud de cancelación de prestaciones HL7",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = HL7CancelPrestac.class)))
                            @RequestBody HL7CancelPrestac hl7CancelPrestac) {
        if (hl7CancelPrestac == null) {
            return ResponseEntity.badRequest().build();
        }
        HL7CancelPrestacResp response =
                service.cancelacionPrestaciones(hl7CancelPrestac);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Registración de Prestación",
            description = "Registra una nueva prestación")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Prestación registrada correctamente",
                            content = @Content(
                                    schema = @Schema(implementation = HL7RegProdResp.class)))
                    ,
                    @ApiResponse(
                            responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @PostMapping("/registracion-prod")
    public ResponseEntity<HL7RegProdResp>
    registracionProd(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la solicitud de registración de prestación HL7",
            required = true,
            content = @Content(schema = @Schema(implementation = HL7RegProd.class)))
                     @RequestBody HL7RegProd hl7RegProd) {
        if (hl7RegProd == null) {
            return ResponseEntity.badRequest().build();
        }
        HL7RegProdResp response = service.registracionProd(hl7RegProd);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Informa Geoposición",
            description = "Registra las coordenadas geográficas de una transacción")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Geoposición registrada correctamente",
                            content = @Content(
                                    schema = @Schema(implementation = HL7Geoposicion.class)))
                    ,
                    @ApiResponse(responseCode = "400",
                            description = "La solicitud es inválida o la transacción ya "
                                    + "tiene una geoposición asociada"),
                    @ApiResponse(responseCode = "404",
                            description = "Transacción no encontrada"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            })
    @PostMapping("/informa-geoposicion")
    public ResponseEntity<HL7Geoposicion>
    informaGeoposicion(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la solicitud de geoposición HL7", required = true,
            content = @Content(schema = @Schema(implementation = HL7Geoposicion.class)
            )) @RequestBody HL7Geoposicion hl7Geoposicion) {
        if (hl7Geoposicion == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            HL7Geoposicion response = service.informaGeoposicion(hl7Geoposicion);
            return ResponseEntity.ok(response);
        } catch (Hl7InexistenteException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (HL7DuplicateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Versión de la API",
            description = "Retorna la versión actual del servicio")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Versión obtenida correctamente",
                            content = @Content(schema = @Schema(implementation = Map.class)))
                    ,
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @GetMapping("/version")
    public ResponseEntity<Map<String, String>>
    getVersion() {
        Map<String, String> versionMap = Map.of("version", "1.0.0-SNAPSHOT");
        return ResponseEntity.ok(versionMap);
    }
    @Operation(summary = "Reimprimir Comprobante",
            description =
                    "Obtiene los datos necesarios para reimprimir un comprobante")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Datos del comprobante obtenidos correctamente",
                            content =
                            @Content(array = @ArraySchema(
                                    schema = @Schema(implementation = Object.class))))
                    ,
                    @ApiResponse(responseCode = "400",
                            description = "Código de transacción inválido"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @GetMapping("/comprobantes/{codigoTx}")
    public ResponseEntity<List<Object>>
    reimprimirComprobante(@Parameter(description = "Código de la transacción",
            example = "123456", required = true) @PathVariable String codigoTx) {
        try {
            Integer codigo = Integer.valueOf(codigoTx);
            List<Object> response = service.reimprimirComprobante(codigo);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @Operation(summary = "Consulta Geoposición",
            description = "Obtiene las coordenadas registradas de una transacción")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Geoposición encontrada",
                            content = @Content(
                                    schema = @Schema(implementation = HL7Geoposicion.class)))
                    ,
                    @ApiResponse(responseCode = "404",
                            description = "Geoposición no encontrada"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @GetMapping("/consulta-geoposicion/{codigoTx}")
    public ResponseEntity<HL7Geoposicion>
    getCoordenadas(@Parameter(description = "Código de transacción",
            example = "123456", required = true) @PathVariable Integer codigoTx) {
        try {
            HL7Geoposicion response = service.consultaGeoposicion(codigoTx);
            return ResponseEntity.ok(response);
        } catch (Hl7InexistenteException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Consulta Prestaciones Exceptuadas",
            description =
                    "Consulta prestaciones que están exceptuadas según nomenclador")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200",
                            description = "Consulta realizada correctamente",
                            content =
                            @Content(array = @ArraySchema(
                                    schema = @Schema(
                                            implementation =
                                                    HL7ConsultaPrestacionExceptuada.class))))
                    ,
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            })
    @GetMapping("/consulta-prestaciones-exceptuadas")
    public ResponseEntity<List<HL7ConsultaPrestacionExceptuada>>
    getPrestacionesExceptuadas(
            @Parameter(description =
                    "Código de nomenclador utilizado para filtrar la consulta",
                    example = "420101") @RequestParam(required = false)
            Integer nomenclador,
            @Parameter(description = "Código o descripción breve de la prestación "
                    + "utilizada para filtrar la consulta",
                    example = "CONSULTA") @RequestParam(required = false)
            String prestacion) {
        try {
            HL7ConsultaPrestacionExceptuada param =
                    new HL7ConsultaPrestacionExceptuada();
            param.setNomen(nomenclador);
            param.setPrestac(prestacion);
            List<HL7ConsultaPrestacionExceptuada> response =
                    service.consultaPrestacionExceptuada(param);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}