package test;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Tablero;

public class TestTablero {
	private Tablero tab = new Tablero(1, "hola");
	@Test
	public void testTablero() {
		Tablero t = new Tablero(2, "hola");
	}

	@Test
	public void testSetAncho() {
		tab.setAncho(4);
	}

	@Test
	public void testSetAlto() {
		tab.setAlto(4);
	}

	@Test
	public void testGetAncho() {
		Tablero t = new Tablero(1,"hola");
		t.setAncho(4);
		assertEquals(t.getAncho(), 4);
	}

	@Test
	public void testGetAlto() {
		Tablero t = new Tablero(1,"hola");
		t.setAlto(4);
		assertEquals(t.getAlto(), 4);	}

	@Test
	public void testCalcularPuntuacion() {
		Tablero t = new Tablero(1,"hola");
		assertEquals(0, t.calcularPuntuacion());
	}

	@Test
	public void testEsBomba() {
		//No necesario
	}

	@Test
	public void testDestapar() {
		Tablero t = new Tablero(1,"hola");
		t.destapar(1, 1);//Fallo
		assertNotEquals(0, t.calcularPuntuacion());
	}

	@Test
	public void testMarcarDesmarcar() {
		//Simulado
	}
	@Test
	public void testBuscar() {
		//Simulado
	}

	@Test
	public void testSetMinas() {
		//No necesario
	}
	@Test	
	public void testComprobar() {
		//Simulado
	}
	@Test
	public void testGetMinas() {
		Tablero t = new Tablero(1,"hola");
		t.setMinas(5);
		assertEquals(5, t.getMinas());
	}

}
