package com.lix.web;

import java.io.IOException;

import org.springframework.core.convert.converter.Converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
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
