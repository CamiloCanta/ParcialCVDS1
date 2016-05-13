package code;

import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejador extends DefaultHandler {
	private ListaUsuarios lista;
	private Integer num;
	private String nom;
	private Usuario jug;

	public Manejador(){
		this.jug=new Usuario(null);
	}
	@Override
    public void startDocument() {
        //System.out.println("Comienzo del Documento XML");
    }
 
    @Override
    public void endDocument() {
        //System.out.println("Final del Documento XML");
    }
 
    public void startElement(String uri, String localName,
              String name, Attributes attributes) throws SAXException {
        num=0;
        nom=null;
        if(localName.equals("Jugador")){
        	jug=new Usuario(null);
        }
        //Recorremos los atributos  
      
        	
        
    }
   
    @Override  
    public void characters(char[] ch, int start, int length)  
          throws SAXException {  
       // Guardamos el texto en la variable temporal  
       nom = new String(ch,start,length); 
     //  num= Integer.parseInt(nom);
    }  
    @Override  
    public void endElement(String uri, String localName, String name)  
          throws SAXException {  
       // Según la etiqueta guardamos el valor leido   
       // en una propiedad del objeto libro  
    	
    	if(localName.equals("Jugador")){
        	ListaUsuarios.getMiListaJugadores().anadirJugador(jug);
    	}else if(localName.equals("puntuacion")){ 
    	   jug.darPuntuacion(Integer.parseInt(nom));
       }else if (localName.equals("nombre")){  
    	   jug.setNombre(nom);
       }  
    	//System.out.println(ListaUsuarios.getMiListaJugadores().getTamano());
    	//ListaUsuarios.getMiListaJugadores().imprimir();

    }  
 
	  
}

