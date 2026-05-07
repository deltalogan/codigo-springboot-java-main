package ar.com.smg.smmp.model.hl7;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter
@Setter
@Schema(name = "HL7GeoposicionResp", description = "DTO de respuesta HL7 con información de geoposición.")
public class HL7GeoposicionResp extends HL7Geoposicion {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = -7537528758688093770L;
}