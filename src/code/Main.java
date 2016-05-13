package code;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*BuilderTablero f=new Nivel1();
		f.construirTablero();
		f.tab.imprimir();
		System.out.println();
		f=new Nivel2();
		f.construirTablero();
		f.tab.imprimir();
		System.out.println();
		f=new Nivel3();
		f.construirTablero();
		f.tab.imprimir();*/
		Buscaminas.getMiBuscaminas().nuevaPartida(null, "1");
		ListaUsuarios.getMiListaJugadores().cargarJugadores();
		Usuario u1=new Usuario("Hola");
		ListaUsuarios.getMiListaJugadores().anadirJugador(u1);
		u1.calcularPuntuacion();
		ListaUsuarios.getMiListaJugadores().imprimir();
		
	}

}
