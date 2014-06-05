package com.lix.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.lix.controller.PagosCompaniasController;
import com.lix.pagoscompanias.service.PagosCompaniasService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader = WebContextLoader.class, classes = { ExampleApplicationContext.class })
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
//		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
//@DatabaseSetup("toDoData.xml")
//@RunWith(MockitoJUnitRunner.class)
public class PagosCompaniasControllerTest {
	// @Mock
	// PagosCompaniasService pagosCompaniasService;
	// @InjectMocks
	// PagosCompaniasController pagosCompaniasController;

//	MockMvc mockMvc;
//
//	@Mock
//	private PagosCompaniasService pagosCompaniasService;

	@Before
	public void setup() {

		// Process mock annotations
//		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
//		this.mockMvc = MockMvcBuilders.standaloneSetup(new PagosCompaniasController()).build();

	}

	@Test
	public void testCreateSignupFormInvalidUser() throws Exception {

//		ResultActions r = this.mockMvc.perform(
//				get("/pagoscompanias/")
//						// page:1
//						// start:0
//						// limit:25
//						// sort:[{"property":"fecha","direction":"DESC"}]
//						.param("page", "1").param("start", "0").param("limit", "25")
//						.param("sort", "[{\"property\":\"fecha\",\"direction\":\"DESC\"}]")).andExpect(status().isOk());

	}
}
