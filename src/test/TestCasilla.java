package test;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Casilla;

public class TestCasilla {

	@Test
	public void testCasilla() {
		//No necesario
	}

	@Test
	public void testGetEstado() {
		//No necesario
	}

	@Test
	public void testBloquearDesbloquear() {
		Casilla c = new Casilla();
		assertEquals(false, c.getEstado());
		c.bloquearDesbloquear();
		assertEquals(true, c.getEstado());//ERROR
	}

	@Test
	public void testGetValor() {
		//No necesario
	}

	@Test
	public void testDarValor() {
		//No necesario
	}

	@Test
	public void testCambiarEstado() {
		Casilla c = new Casilla();
		c.cambiarEstado();
		assertEquals(true, c.getEstado());
	}

	@Test
	public void testEsBomba() {
		Casilla c = new Casilla();
		c.darValor("B");
		assertEquals(true, c.esBomba());
	}

}
