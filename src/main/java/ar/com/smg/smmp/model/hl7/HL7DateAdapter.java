package ar.com.smg.smmp.model.hl7;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "HL7DateAdapter", description = "Adaptador de fechas utilizado para conversión entre representaciones de fecha HL7 y objetos Date.", hidden = true)
public class HL7DateAdapter extends XmlAdapter<String, Date> implements Serializable {

	private static final long serialVersionUID = -6993005487835954847L;

	private DateFormat defaultFormat;
	private DateFormat[] allowedFormats;

	public HL7DateAdapter() {
		this.defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.allowedFormats = new DateFormat[] {
				this.defaultFormat,
				new SimpleDateFormat("yyyyMMdd"),
				new SimpleDateFormat("yyyy-MM-dd"),
		};
	}

	@Override
	public String marshal(Date v) {
		return this.defaultFormat.format(v);
	}

	@Override
	public Date unmarshal(String v) throws ParseException {
		ParseException parseException = null;
		for(DateFormat dateFormat : this.allowedFormats) {
			try {
				return dateFormat.parse(v);
			} catch (ParseException e) {
				parseException = e;
			}
		}
		if( parseException != null ) {
			throw parseException;
		}
		return null;
	}
}