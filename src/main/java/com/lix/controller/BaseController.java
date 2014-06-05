package com.lix.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.dto.DefaultResponse;

public abstract class BaseController {

	abstract Logger getLogger();

	public BaseController() {
		super();
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public DefaultResponse handleIOException(Exception ex) {
		getLogger().info("Error:{}", ex.getMessage());
		DefaultResponse response = new DefaultResponse();
		response.setMessage(ex.getMessage());
		response.setSuccess(false);
		return response;
	}

	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		// The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

}