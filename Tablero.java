package Buscaminas;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {

	public BuilderCasilla [][] m;
	int ancho;
	int alto;
	
	public Tablero(){
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
	public void revelarTablero(){
		for (int i=0;i<ancho;i++){
		      for (int z=0;z<alto;z++){
		    	  m[i][z].cas.cambiarEstado(false);
		      }
		}
	}
	public ArrayList<Integer> destapar(int i,int z){
		ArrayList<Integer> lista=new ArrayList<Integer>();
		int a,b;
		if(m[i][z].cas.getValor()=="0"){
			m[i][z].cas.cambiarEstado(true);
			lista.add(i);
			lista.add(z);
			ArrayList<Integer> lis=buscar(i, z);
			Iterator<Integer> it=lis.iterator();
			while(it.hasNext()){
				a=it.next();
				b=it.next();
				if(m[a][b].cas.getValor()=="0"){
					lista.addAll(destapar(a,b));
				}
			}
		}
		
		
		return lista;
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
}

