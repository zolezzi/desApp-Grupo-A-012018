package edu.unq.desapp.grupo_a.backend.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JSONDateDeserialize extends JsonDeserializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private  DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US);
;
   
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        String date = jp.getText();
        Date newDate = null;
		try {
			newDate = df.parse(date);
			//newDate = dateFormat.parse(date);
			DateFormat outputFormatter1 = new SimpleDateFormat("dd-MMM-yyyy");
	        String output1 = outputFormatter1.format(newDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return newDate;
	}
    
}