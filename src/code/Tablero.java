package code;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import window.EjemploPanel;

public class Tablero {

	public BuilderCasilla [][] m;
	private int ancho;
	private int alto;
	private int bloqueos=0;
	private int minas=0;
	private EjemploPanel tableroG;
	
	public Tablero(int pNivel){
		tableroG = new EjemploPanel(pNivel);
		tableroG.setVisible(true);
	}
	public void setAncho(int a){
		ancho=a;
	}
	public void setAlto(int a){
		alto=a;
	}
	
	
	public int getAncho(){
		return ancho;
	}
	public  int getAlto(){
		return alto;
	}
	public int calcularPuntuacion(){
		int result=0;
		for (int i=0;i<ancho;i++){
		      for (int z=0;z<alto;z++){
		    	  if(!m[i][z].cas.getValor().equals("B")){
		    		  result=result+(Integer.parseInt(m[i][z].cas.getValor())+1);
		    	  }
		      }
		}return result;
	}
	public ArrayList<String> revelarTablero(){//devolver todas las casillas
		ArrayList<String> lista=new ArrayList<String>();
		for (int i=0;i<ancho;i++){
		      for (int z=0;z<alto;z++){
		    	  m[i][z].cas.cambiarEstado();
		    	  if(m[i][z].cas.getValor().equals("B")){
		    		  lista.add("*");
		    	  }else{
		    	  lista.add(m[i][z].cas.getValor());
		    	  }
		      }
		}
		return lista;
	}
	public boolean esBomba(int i, int  z){
		if(m[i][z].cas.getValor().equals("B")){
			return true;
		}else{
			return false;
		}
	}
	public ArrayList<Integer> destapar(int i,int z){
		if(!m[i][z].cas.bloqueado && !m[i][z].cas.getEstado() ){
			ArrayList<Integer> lista=new ArrayList<Integer>();
			int a,b;
			if(m[i][z].cas.getValor().equals("0")){
				System.out.println("Entra en caso raro");
				m[i][z].cas.cambiarEstado();
				lista.add(i);
				lista.add(z);
				ArrayList<Integer> lis=buscar(i, z);
				Iterator<Integer> it=lis.iterator();
				while(it.hasNext()){
					a=it.next();
					b=it.next();
					if(m[a][b].cas.getValor().equals("0") && (m[a][b].cas.getEstado()==false)){
						lista.addAll(destapar(a,b));
					}
				}
			}else if(m[i][z].cas.getValor().equals("B")){
				System.out.println("Bomba");
			}else{
				m[i][z].cas.cambiarEstado();
				lista.add(i);
				lista.add(z);
				System.out.println("Caso normal "+ m[i][z].cas.getValor());
			}
			return lista;
	}else{
		return null;
	}
	}
	public boolean marcarDesmarcar(int i,int j){
		boolean d = false;
		if(bloqueos<this.minas){
			System.out.println("Primera opcion");
			if(m[i][j].cas.bloquearDesbloquear()){
				sumarBloqueos();
				System.out.println(bloqueos);
			}else{
				restarBloqueos();
				System.out.println(bloqueos);
			}
			d=true;
		}else if(m[i][j].cas.bloqueado){
			System.out.println("Segunda opcion");
			m[i][j].cas.bloquearDesbloquear();
			restarBloqueos();
			d=true;
			System.out.println(bloqueos);
		}
		return d;
	}
	private void sumarBloqueos(){
		this.bloqueos++;
	}
	private void restarBloqueos(){
		this.bloqueos--;
	}
	public void imprimir(){
		 for (int i=0;i<ancho;i++){
		       for (int z=0;z<alto;z++){
		    	   System.out.println(i+ " "+ z +" "+ m[i][z].cas.getValor());
		       }
		 }
	}
	public ArrayList<Integer> buscar(int i, int z){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		if(i==0 && z==0){
			arr.add(i+1);
			arr.add(z);
			arr.add(i);
			arr.add(z+1);
			arr.add(i+1);
			arr.add(z+1);
		}else if(i==getAncho()-1 && z==getAlto()-1){
			arr.add(i-1);
			arr.add(z);
			arr.add(i);
			arr.add(z-1);
			arr.add(i-1);
			arr.add(z-1);

		}else if(i==getAncho()-1 && z==0){
			arr.add(i-1);
			arr.add(z);
			arr.add(i-1);
			arr.add(z+1);
			arr.add(i);
			arr.add(z+1);			

		}else if(i==0 && z==getAlto()-1){
			arr.add(i);
			arr.add(z-1);
			arr.add(i+1);
			arr.add(z-1);
			arr.add(i+1);
			arr.add(z);

		}else if(z==0 && i!=0 && i!=getAncho()-1){
			
			arr.add(i-1);
			arr.add(z);
			arr.add(i-1);
			arr.add(z+1);
			arr.add(i);
			arr.add(z+1);
			arr.add(i+1);
			arr.add(z+1);
			arr.add(i+1);
			arr.add(z);

		}else if(i==0 && z!=0 && z!=getAlto()-1){
			arr.add(i);
			arr.add(z-1);
			arr.add(i+1);
			arr.add(z-1);
			arr.add(i+1);
			arr.add(z);
			arr.add(i+1);
			arr.add(z+1);
			arr.add(i);
			arr.add(z+1);

		}else if(i==getAncho()-1 && z!=getAlto()-1 && i!=0 && z!=0){
			arr.add(i);
			arr.add(z-1);
			arr.add(i-1);
			arr.add(z-1);
			arr.add(i-1);
			arr.add(z);
			arr.add(i-1);
			arr.add(z+1);
			arr.add(i);
			arr.add(z+1);

		}else if(i!=getAncho()-1 && z==getAlto()-1 && z!=0 && i!=0){
			arr.add(i-1);
			arr.add(z);
			arr.add(i-1);
			arr.add(z-1);
			arr.add(i);
			arr.add(z-1);
			arr.add(i+1);
			arr.add(z-1);
			arr.add(i+1);
			arr.add(z);

		}else{
			arr.add(i);
			arr.add(z-1);
			arr.add(i-1);
			arr.add(z-1);
			arr.add(i+1);
			arr.add(z-1);
			arr.add(i);
			arr.add(z+1);
			arr.add(i+1);
			arr.add(z+1);
			arr.add(i-1);
			arr.add(z+1);
			arr.add(i+1);
			arr.add(z);
			arr.add(i-1);
			arr.add(z);

		}
		return arr;
	}
	public void setMinas(int i) {
		this.minas=i;
		
	}
	public int getMinas() {
		// TODO Auto-generated method stub
		return this.minas;
	}
	public boolean comprobar() {
		boolean win = true;
		for (int i=0;i<ancho;i++){
		      for (int z=0;z<alto;z++){
		    	  if(m[i][z].cas.getValor().equals("B")){
		    		  if(!m[i][z].cas.getBloqueado()){
		    			  win=false;
		    		  }
		    	  }
		      }
		}
		return win;
	}
}

