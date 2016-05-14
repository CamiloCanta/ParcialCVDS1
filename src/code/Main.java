package code;

import java.awt.List;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		Buscaminas.getMiBuscaminas().nuevaPartida(null, "1");
		ListaUsuarios.getMiListaJugadores().cargarJugadores();
		Usuario u1=new Usuario("Hola");
		ListaUsuarios.getMiListaJugadores().anadirJugador(u1);
		u1.calcularPuntuacion();
		ListaUsuarios.getMiListaJugadores().imprimir();
		ListaUsuarios.getMiListaJugadores().ranking();
		
	}

}
