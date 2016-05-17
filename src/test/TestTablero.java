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
		tab.setAncho(4);///Pregunta No se pueden juntar los test de los getters y setters y no es mejor inicializar arriba
		//la variable tab
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
	public void testRevelarTablero() {
		tab.revelarTablero();
		for(int i=0;i<4;i++){
			for(int z=0;z<4;z++){
				assertEquals(tab.m[i][z].cas.getEstado(),true);
			}
		}
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
		tab.marcarDesmarcar(1, 1);
		assertEquals(true,tab.m[1][1].cas.getBloqueado());
		tab.marcarDesmarcar(1,1);
		assertEquals(false,tab.m[1][1].cas.getBloqueado());
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
	public void testComprobar() {
		for (int i=0;i<4;i++){
		      for (int z=0;z<4;z++){
		    	  if(tab.m[i][z].cas.getValor().equals("B")){
		    			  tab.m[i][z].cas.bloquearDesbloquear();		    		  
		    	  }
		      }
		}
		assertTrue(tab.comprobar());
	}
	@Test
	public void testGetMinas() {
		Tablero t = new Tablero(1,"hola");
		t.setMinas(5);
		assertEquals(5, t.getMinas());
	}

}
