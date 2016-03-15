package code;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BuilderTablero f=new Nivel1();
		f.construirTablero();
		f.tab.imprimir();
		System.out.println();
		f=new Nivel2();
		f.construirTablero();
		f.tab.imprimir();
		System.out.println();
		f=new Nivel3();
		f.construirTablero();
		f.tab.imprimir();
		
	}

}
