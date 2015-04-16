package com.lix.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.lix.reportes.PlanPagosExcelBuilder;
import com.lix.reportes.PolizasPorVencerExcelBuilder;
import com.lix.web.PaginationParamsConverter;

@EnableWebMvc
@ComponentScan(basePackages = { "com.lix" })
@Configuration
@ImportResource("classpath:spring-security.xml")
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	// equivalents for <mvc:resources/> tags
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/resources/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/css")
				.addResourceLocations("/resources/css/")
				.setCachePeriod(31556926);
	}

	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		ConversionService object = bean.getObject();
		return object;
	}

	private Set<Converter> getConverters() {
		Set<Converter> converters = new HashSet<Converter>();

		converters.add(new PaginationParamsConverter());

		return converters;
	}

	@Bean
	public RequestMappingHandlerAdapter requestMappingHandler() {
		RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new MappingJacksonHttpMessageConverter());
		adapter.setMessageConverters(messageConverters);
		return adapter;
	}

	@Bean
	public PolizasPorVencerExcelBuilder polizasPorVencer() {
		return new PolizasPorVencerExcelBuilder();
	}

	@Bean
	public PlanPagosExcelBuilder planPagos() {
		return new PlanPagosExcelBuilder();
	}

}
