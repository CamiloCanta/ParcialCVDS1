package code;

import java.util.ArrayList;

public class Buscaminas {

	private Tablero tablero;
	private static Buscaminas miBuscaminas = new Buscaminas();
	
	
	public Buscaminas() {
		// TODO Auto-generated constructor stub
	}

	public static Buscaminas getMiBuscaminas(){
		return miBuscaminas;
	}

	public void nuevaPartida(String text, Object selectedItem) {
		BuilderTablero tablero;
		
		if ((String)selectedItem == "1") {
		tablero = new Nivel1();
		tablero.construirTablero(1);	
			
		}else if((String)selectedItem == "2"){
		tablero = new Nivel2();
		tablero.construirTablero(2);
		}else{
		tablero = new Nivel3();	
		tablero.construirTablero(3);
		}
		
		
		
		
		
		this.tablero = tablero.devolverTablero();
		System.out.println(text+"   "+selectedItem);
		System.out.println(this.tablero.getMinas()+ "==MINAS");
		
	}
	public boolean marcarDesmarcar(int i,int j){
		return this.tablero.marcarDesmarcar(i, j);
	}

	public ArrayList<Integer> destapar(int xT, int yT) {
		return tablero.destapar(xT, yT);
		
	}
	
	public boolean esBomba(int i, int z){
		return tablero.esBomba(i, z);
	}
	public ArrayList<String> revelar(){
		return tablero.revelarTablero();
	}
	public int calcularPuntuacion(){
		return tablero.calcularPuntuacion();
	}
}
