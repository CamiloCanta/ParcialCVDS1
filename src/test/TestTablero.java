package test;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Tablero;

public class TestTablero {

	@Test
	public void testTablero() {
	}

	@Test
	public void testSetAncho() {
	}

	@Test
	public void testSetAlto() {
	}

	@Test
	public void testGetAncho() {
		Tablero t = new Tablero(1);
		t.setAncho(4);
		assertEquals(t.getAncho(), 4);
	}

	@Test
	public void testGetAlto() {
		Tablero t = new Tablero(1);
		t.setAlto(4);
		assertEquals(t.getAlto(), 4);	}

	@Test
	public void testCalcularPuntuacion() {
		Tablero t = new Tablero(1);
		assertEquals(0, t.calcularPuntuacion());
	}

	@Test
	public void testRevelarTablero() {
	}

	@Test
	public void testEsBomba() {
		//No necesario
	}

	@Test
	public void testDestapar() {
		Tablero t = new Tablero(1);
		t.destapar(1, 1);//Fallo
		assertNotEquals(0, t.calcularPuntuacion());
	}

	@Test
	public void testMarcarDesmarcar() {
	}

	@Test
	public void testImprimir() {
	}

	@Test
	public void testBuscar() {
	}

	@Test
	public void testSetMinas() {
	}

	@Test
	public void testGetMinas() {
		Tablero t = new Tablero(1);
		t.setMinas(5);
		assertEquals(5, t.getMinas());
	}

}
