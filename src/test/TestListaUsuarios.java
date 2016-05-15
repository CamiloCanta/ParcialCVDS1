package test;

import static org.junit.Assert.*;

import org.junit.Test;

import code.ListaUsuarios;
import code.Usuario;

public class TestListaUsuarios {

	@Test
	public void testGetMiListaJugadores() {
	}

	@Test
	public void testGetListaJug() {
	}

	@Test
	public void testAnadirJugador() {
	}

	@Test
	public void testAnadirJugadorPorNombre() {
		
	}

	@Test
	public void testBorrarJugador() {
	}

	@Test
	public void testObtenerRanking() {
		Usuario u = new Usuario("a");
		ListaUsuarios.getMiListaJugadores().anadirJugador(u);
		ListaUsuarios.getMiListaJugadores().anadirJugadorPorNombre("Hola");
		assertEquals(2, ListaUsuarios.getMiListaJugadores().obtenerRanking(10).size());
		ListaUsuarios.getMiListaJugadores().borrarJugador(u);
		assertEquals(1, ListaUsuarios.getMiListaJugadores().obtenerRanking(10).size());//Error
	}

	@Test
	public void testImprimirRanking() {
	}

	@Test
	public void testCargarJugadores() {
	}

	@Test
	public void testGetTamano() {
	}

	@Test
	public void testBuscarJugador() {
		Usuario u = new Usuario("a");
		ListaUsuarios.getMiListaJugadores().anadirJugador(u);
		assertEquals(true, ListaUsuarios.getMiListaJugadores().buscarJugador("a"));
	}

	@Test
	public void testIt() {
	}

	@Test
	public void testImprimir() {
	}

	@Test
	public void testRanking() {
	}

	@Test
	public void testModificarJugador() {
	}

	@Test
	public void testGetUltimo() {
	}

}
