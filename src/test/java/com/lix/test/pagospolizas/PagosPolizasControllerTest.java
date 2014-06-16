package com.lix.test.pagospolizas;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.lix.controller.PagosPolizasController;
import com.lix.pagospolizas.service.PagosPolizasService;
import com.lix.test.AbstractTestWithContext;
import com.lix.test.TestUtil;

public class PagosPolizasControllerTest extends AbstractTestWithContext {
	private MockMvc mockMvc;
	@Autowired
	private PagosPolizasController pagosPolizasController;
	@Autowired
	private PagosPolizasService pagosPolizasService;
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		// We have to reset our mock between tests because the mock objects
		// are managed by the Spring container. If we would not reset them,
		// stubbing and verified behavior would "leak" from one test to another.
		Mockito.reset(pagosPolizasService);

		mockMvc = MockMvcBuilders.webApplicationContextSetup(
				webApplicationContext).build();
	}

	@Test
	public void findAll_PagosPolizasFound_ShouldReturnFoundTodoEntries()
			throws Exception {
		Mockito.when(pagosPolizasService.findAll()).thenReturn(
				PagosPolizasMock.createList(20));
		mockMvc.perform(get("/api/todo")).andExpect(status().isOk())
				.andExpect(content().type(TestUtil.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(20)));
		// .andExpect(jsonPath("$[0].id", is(1)))
		// .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
		// .andExpect(jsonPath("$[0].title", is("Foo")))
		// .andExpect(jsonPath("$[1].id", is(2)))
		// .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
		// .andExpect(jsonPath("$[1].title", is("Bar")));

		verify(pagosPolizasService, times(1)).findAll();
		verifyNoMoreInteractions(pagosPolizasService);

	}
}
