package code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.thoughtworks.xstream.XStream;


public class ListaUsuarios {
	private ArrayList<Usuario> lista;
	private static ListaUsuarios miListaUsuarios=new ListaUsuarios("C:\\Ranking3.xml");//ruta
	private String path;
	
	private ListaUsuarios(String pPath){
		lista=new ArrayList<Usuario>();
		path=pPath;
	}
	public static ListaUsuarios getMiListaJugadores() {
		return miListaUsuarios;
	}
	
	public ArrayList<Usuario> getListaJug() {
		return lista;
	} 

	private Iterator<Usuario> getCopiaIterator(ArrayList<Usuario> pCpListaJug){
		
		return pCpListaJug.iterator();
	}
	
	private Iterator<Usuario> getIterator(){
		
		return this.lista.iterator();
	}
	
	public void anadirJugador(Usuario pJug){
		
		this.lista.add(pJug);
		
	}
	
	public void anadirJugadorPorNombre(String pJug){
		
		this.lista.add(new Usuario(pJug));
		
	}
	
	public void borrarJugador(Usuario pJug){
		
		this.lista.remove(pJug);
		
	}
		
	public ArrayList<Usuario> obtenerRanking(int pNumJug){
		
		ArrayList<Usuario> ranking = new ArrayList<Usuario>();
		ArrayList<Usuario> cpListaJug = this.lista;
		Usuario jug1;
		Usuario jug2;
		Iterator<Usuario> it = this.getCopiaIterator(cpListaJug);
		int i = 0;
		while(it.hasNext()){
			jug1 = it.next();
			jug2 = jug1;
			while(it.hasNext()){
				
				jug1 = it.next();
				
				if (jug2.getPuntos() < jug1.getPuntos()){
					jug2 = jug1;
				}
				
			};
			ranking.add(jug2);
			cpListaJug.remove(jug2);
			it = this.getCopiaIterator(cpListaJug);
			i++;
		}
	
	return ranking;
	}
	
	public ArrayList<String> imprimirRanking(ArrayList<Usuario> pRanking) throws FileNotFoundException{
		
		ArrayList<String> listaJugImp = new ArrayList<String>();
		int i =0;
		
		while(listaJugImp.size() < pRanking.size()){
			listaJugImp.add(pRanking.get(i).getNombre() + "    Puntos--->      " + pRanking.get(i).getPuntos());
			i++;
		}
		
		return listaJugImp;
	}
	
	public void cargarJugadores(){
		try{
			XMLReader reader=XMLReaderFactory.createXMLReader();
			reader.setContentHandler(new Manejador());
			reader.parse(new InputSource(new FileInputStream("Ranking3.xml")));
			
			
		}catch(SAXException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getTamano(){
		return this.lista.size();
	}
	
	public boolean buscarJugador(String pNomJug){
		
		boolean esta = false;
		Iterator<Usuario> it = this.getIterator();
		Usuario jug1;
		while(it.hasNext() && !esta){
			
			jug1 = it.next();
			
			if(jug1.getNombre().equals(pNomJug)){
				esta = true;
			}
		}

		return esta;
	}
	
	public Iterator<Usuario> it(){
		return this.lista.iterator();
	}
	public void imprimir(){
		Iterator<Usuario> itr=this.it();
		Usuario
		jug=null;
		while(itr.hasNext()){
			jug=itr.next();
			jug.imprimir();
		}
		
	}
	
	
	public void ranking() throws FileNotFoundException{
		Iterator<Usuario> itr= this.getIterator();
		Usuario j1=null;
		XStream x =new XStream();
		
		FileOutputStream nuevo= new FileOutputStream("ranking3.xml");
		x.alias("Jugador", Usuario.class);
		x.toXML(this.lista, nuevo);
		/*while(itr.hasNext()){
			j1= itr.next();
			x.alias("Jugador", Jugador.class);
			x.toXML(j1, nuevo);
		}*/
		
	}
	//Tambien busca
	public void modificarJugador(String nombreJugador){
		
		boolean esta = false;
		Iterator<Usuario> it = this.getIterator();
		Usuario jug1 = null;
		while(it.hasNext() && !esta){
			
			jug1 = it.next();
			
			if(jug1.getNombre().equals(nombreJugador)){
				esta = true;
			}
		}
		jug1.calcularPuntuacion();

	}
	public Usuario getUltimo(){
		Iterator<Usuario> itr= this.getIterator();
		Usuario j1=null;
			while(itr.hasNext()){
				j1 = itr.next();
			}
			return j1;
			
			
	}
}
