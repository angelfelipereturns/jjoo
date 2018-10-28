package com.afaf.jjoo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.afaf.jjoo.controller.JjooController;

/**
 * Clase test para el contexto de la aplicacion
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JjooApplicationTests {
	
	@Autowired
	private JjooController jjooController;

	@Test
	public void contextLoads() {
		assertThat(jjooController).isNotNull();
	}

}
