package code;

import java.util.ArrayList;
import java.util.Iterator;

public class Nivel2 extends BuilderTablero{

	@Override
	public void ponerNivel() {
		// TODO Auto-generated method stub
		tab.setAlto(8);
		tab.setAncho(8);
		tab.setMinas(4);
		tab.setTablero(new BuilderCasilla[tab.getAncho()][tab.getAlto()]);
	}

	@Override
	public void ponerBombas() {
		// TODO Auto-generated method stub
		int condicion=0;
		int i;
		int z;
		condicion=tab.getAncho()/2;
		while(condicion>0){
			double e=Math.random()*tab.getAncho();
			i=(int)e;
			double f=Math.random()*tab.getAlto();
			z=(int)f;
			if( tab.getTablero()[i][z]==null){
				tab.getTablero()[i][z]=new Bomba();
				tab.getTablero()[i][z].darValor("B");
				condicion=condicion-1;
			}
		}
	}

	@Override
	public void asignarValores() {
		// TODO Auto-generated method stub
		int a=0;
		int b=0;
		for(int i=0;i<tab.getAncho();i++){
			for(int z=0;z<tab.getAlto();z++){
				if(tab.getTablero()[i][z]==null){
					int valor=0;
					ArrayList<Integer> lista=tab.buscar(i, z);
					Iterator<Integer> it=lista.iterator();
					while(it.hasNext()){
						a=it.next();
						b=it.next();
						if(tab.getTablero()[a][b]!=null && tab.getTablero()[a][b].cas.getValor()=="B"){
							valor++;
						}
					}
					if(valor!=0){
						tab.getTablero()[i][z]=new ConValor();
						tab.getTablero()[i][z].cas.darValor(String.valueOf(valor));
					}
				}
				
			}
		}
		 for (int i=0;i<tab.getAncho();i++){
		       for (int z=0;z<tab.getAlto();z++){
		    	   if(tab.getTablero()[i][z]==null){
		    		   tab.getTablero()[i][z]=new Vacia();
		    		  tab.getTablero()[i][z].darValor(String.valueOf(0));
		    	   }
		       }
		 }
	}

}
