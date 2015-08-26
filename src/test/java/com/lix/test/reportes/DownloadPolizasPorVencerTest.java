package com.lix.test.reportes;


import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.lix.controller.ReportesController;
import com.lix.polizas.dao.PolizasDao;
import com.lix.test.AbstractTestWithContext;
import com.lix.test.polizas.PolizasMock;

public class DownloadPolizasPorVencerTest extends AbstractTestWithContext {
	private final static Logger LOGGER = LoggerFactory.getLogger(DownloadPolizasPorVencerTest.class);
	private MockMvc mockMvc;

	@Mock
	PolizasDao polizasDao;
	
	@Autowired
	ReportesController reportesController;
	  @Before
	  public void setup() {
		  MockitoAnnotations.initMocks(this);
			// We have to reset our mock between tests because the mock objects
			// are managed by the Spring container. If we would not reset them,
			// stubbing and verified behavior would "leak" from one test to another.
			// Mockito.reset(service);

			this.mockMvc = MockMvcBuilders.standaloneSetup(reportesController).build();
	  }
	 @Test
	  public void getFile() throws Exception {
		 Mockito.when(polizasDao.getPolizasPorVencerPage(new Date(),new Date())).thenReturn(PolizasMock.createList(200));
	    this.mockMvc.perform(get("/reportes/polizasPorVencer/").accept(MediaType.parseMediaType("application/vnd.ms-excel")))
	        .andExpect(status().isOk());
	  }
}
