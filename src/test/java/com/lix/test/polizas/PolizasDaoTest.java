package com.lix.test.polizas;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lix.clientes.dao.ClientesDao;
import com.lix.companias.dao.CompaniasDao;
import com.lix.polizas.dao.PolizasDao;
import com.lix.polizas.model.Polizas;
import com.lix.secciones.dao.SeccionesDao;
import com.lix.test.AbstractTestWithContext;

public class PolizasDaoTest extends AbstractTestWithContext{
	@Autowired
	PolizasDao polizasDao;
	@Autowired
	SeccionesDao seccionesDao;
	@Autowired
	ClientesDao clientesDao;
	@Autowired
	CompaniasDao companiasDao;

//	@Test
	public void testFindAll() {
		List<Polizas> accs = polizasDao.findAll();
		Assert.assertThat("Check DB is empty first", accs.size(), Matchers.is(0));
		Polizas m = PolizasMock.createInstance();
		//save first cliente compania tipo poliza
		clientesDao.save(m.getClientes());
		seccionesDao.saveOrUpdate(m.getTipoPoliza());
		companiasDao.saveOrUpdate(m.getCompanias());
		
		polizasDao.saveOrUpdate(m);
		accs = polizasDao.findAll();
		Assert.assertThat("Check Polizas has been created", accs.size(), Matchers.is(1));
	}
	public void testSave(){
		
	}
	@Test
	public void testPolizasXVencimiento(){
// 		Calendar cal=Calendar.getInstance();
// 		cal.set(2008, 0, 1);
// 		Date hoy=cal.getTime();
// 		cal.add(Calendar.YEAR, 1);
// 		Date despues=cal.getTime();
		
// //		for(Polizas p:PolizasMock.createList(10)){
// //			System.out.println(p.getFVigHasta());
// //			clientesDao.save(p.getClientes());
// //			seccionesDao.saveOrUpdate(p.getTipoPoliza());
// //			companiasDao.saveOrUpdate(p.getCompanias());
// //			polizasDao.save(p);
// //		}
// 		System.out.println("HOY:"+hoy);
// 		System.out.println("DESPUES:"+despues);
// //		Assert.assertEquals(10,polizasDao.getPolizasPorVencer(hoy,despues).size());
// 		int size=polizasDao.getPolizasPorVencerPage(hoy,despues).size();
// 		System.out.println("size:"+size);
// 		Assert.assertThat(size, Matchers.greaterThan(1));
	}
}
