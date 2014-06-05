package com.lix.web;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.core.convert.converter.Converter;

import com.lix.dto.PaginationParams;

public class PaginationParamsConverter extends JsonDeserializer<PaginationParams> implements Converter<String, PaginationParams> {

	@Override
	public PaginationParams convert(String arg0) {
		PaginationParams p = new PaginationParams();
		return p;
	}

	@Override
	public PaginationParams deserialize(JsonParser jp, DeserializationContext arg1) throws IOException, JsonProcessingException {
		return convert(jp.getText());
	}

}
