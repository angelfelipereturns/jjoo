package com.afaf.jjoo.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.afaf.jjoo.data.ResumenSedesDao;
import com.afaf.jjoo.data.model.ResumenSedes;

/**
 * Clase test para el DAO de ResumenSedesDao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResumenSedesDaoTests {
	
	@Autowired
	private ResumenSedesDao resumenSedesDao;
	
	@Test
	@Transactional
	@Rollback(true)
	public void listaResumenSedesTest() {
		ResumenSedes resumenSedes = new ResumenSedes(3, "FRANCIA", 8, "PARIS", 5, "VERANO", 2);
		List<ResumenSedes> list = resumenSedesDao.listaResumenSedes();
		assertEquals(resumenSedes.getClass(), list.get(0).getClass());
	}

}
