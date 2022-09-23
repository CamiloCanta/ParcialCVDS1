
# PARCIAL CVDS

Integrantes
=
- Julian Castillo Soto
- Camilo Cantillo Tatis

Paso a Paso GIT
=
1. Buscamos el repositorio.
![image](https://user-images.githubusercontent.com/108955358/190648367-274f8bd7-47f0-43e9-af74-992d8dab7409.png)

2. Le damos a fork.

![image](https://user-images.githubusercontent.com/108955358/190648938-e6d736e4-8294-48a9-afab-731902144588.png)

3. Ya lo podemos visualizar en nuestro github
![image](https://user-images.githubusercontent.com/108955358/190649066-c184a972-0a2a-4f23-8147-ce7ec5caefb9.png)

4. Lo clonamos a nuestro equipo.

![image](https://user-images.githubusercontent.com/108955358/190649509-f01a0cc4-4c28-43e3-a08a-40cb625a3e45.png)
![image](https://user-images.githubusercontent.com/108955358/190649778-d5ebd306-1243-4ebf-9597-a10b232abd21.png)

5. si realizamos cambios en el proyecto y queremos agregarlos al repositorio procedemos a hacerle push para que quede en nuestro repositorio.

![image](https://user-images.githubusercontent.com/108955358/190651605-958ed4c9-d969-4bf3-9ffa-6b0718b82736.png)
![image](https://user-images.githubusercontent.com/108955358/190651677-d0000590-fd4e-497a-b272-31f3925bc54f.png)

Identificar Malas practicas
=

- Codigo repetido

![image](https://user-images.githubusercontent.com/108955358/190653241-d52d697d-8a46-4240-bc24-4ddd57af6ffa.png)
![image](https://user-images.githubusercontent.com/108955358/190653447-95ae70d2-7db2-44e0-be46-2d0736594c0a.png)
![image](https://user-images.githubusercontent.com/108955358/190653533-9d5ae205-4025-437b-be48-90916ec5f120.png)

**Solucion**

crear una clase abstracta llamada Nivel, que implemente una interfaz en donde tendran los metodos de poner bombas y asignar valores.
cada nuevo nivel se creara en una nueva clase, cumpliendo la o del principio solid, a su vez la clase abstracta hereda atributos como ancho alto y numero de minas.

```
public abstract class nivel  implements creacionNivel  {

	protected int filas;
	protected int columnas;
	protected tablero tab;
	
	public nivel(int filas, int columnas, tablero tab){
		this.tab = tablero;
		this.filas = filas;
		this.columnas = columnas;
		tab.setAlto(4);
		tab.setAncho(4);
		tab.setMinas(2);
		
	}
	
	
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

interface creacionNivel(){

	public void asignarValores();
	
	public void ponerBombas();

}



public class nivel1
	
	public nivel0(int filas,int columnas, tablero tab){
	
		this.filas = filas;
		this.columnas = columnas;
		this.tab = tab;
	}

}


public class nivel2{
	
	public nivel2(int filas,int columnas, tablero tab){
	
		this.filas = filas;
		this.columnas = columnas;
		this.tab = tab;
	}

}



public class nivel3{
	
	public nivel3(int filas,int columnas, tablero tab){
	
		this.filas = filas;
		this.columnas = columnas;
		this.tab = tab;
	}

}
```

- Scope de las pruebas unitarias no cubre todo

![image](https://user-images.githubusercontent.com/108955358/190837877-5c3e57a9-12d3-47b1-ba3b-b093ec732a4d.png)
![image](https://user-images.githubusercontent.com/108955358/190837900-5eb6d4a4-3d1f-4135-a99f-3d88b3af16e9.png)

- SUT: es un Proyecto que cumple el SUT, ya que constantemente esta realizando pruebas para su correcto comportamiento pero como lo dicho anteriormente su scope no cubre completamente el proyecto
- Principios first: no cumple el principio R, ya que no es repetible y no lo pudimos correr en nuestras maquina.

- Nombramiento pruebas unitarias y la no implementacion de el patrón AAA

![image](https://user-images.githubusercontent.com/108955358/190654555-66a7881e-c282-4cdf-823d-225b39ce2e04.png)

![image](https://user-images.githubusercontent.com/108955358/190654608-accc5c45-bd4b-4b45-bf37-0bc64879538f.png)

![image](https://user-images.githubusercontent.com/108955358/190654749-1c614d4b-c7fd-4095-8d62-a2717791e43c.png)



- Planteamiento solución Unit Test

```
Public void Dado_UnaCasilla_Cuando_QuiereCambiarEstado_Entonces_CambieEstado();
    //arrange
    Casilla c = new Casilla();
    
    //Act
    c.cambiarEstado();
    
    //Assert
    assertEquals(true, c.getEstado());
  
  
Public void Dado_UnaCasilla_Cuando_SeQuiereSaberSiEsUnaBomba_Entonces_esBomba();
    //arrange
    Casilla c = new Casilla();
    
    //act
    c.darValor("B")
    
    //assert
    assertEquals(true, c.esBomba());
    
 //Multiples clases de equivalencia
 Public void Dado_UnaUsuario_Cuando_SeTienenVariosUsuarios_Entonces_obtenerRanking();
    //arrange
    Usuario u = new Usuario("a");
    
    //act
    ListaUsuarios.getMiListaJugadores().anadirJugador(u);
    ListaUsuarios.getMiListaJugadores().anadirJugadorPorNombre("Hola");
    ListaUsuarios.getMiListaJugadores().borrarJugador(u);
    
    //assert
    assertEquals(1, ListaUsuarios.getMiListaJugadores().obtenerRanking(10).size())
    assertEquals(2, ListaUsuarios.getMiListaJugadores().obtenerRanking(10).size());
    
    
    
public void Dado_UnTablero_Cuando_sePruebaElAncho_Entonces_AnchoEsCorrecto() {
        //arrange
		Tablero t = new Tablero(1,"hola");
        
        //act
		t.setAncho(4);
        
        //assert
		assertEquals(t.getAncho(), 4);
        
public void Dado_UnTablero_Cuando_sePruebaElAlto_Entonces_AltoEsCorrecto() {
        //arrange
		Tablero t = new Tablero(1,"hola");
        
        //act
		t.setAlto(8);
        
        //assert
		assertEquals(t.getAlto(), 8);
        
        
public void Dado_unTablero_Cuando_SeRequiereLaPuntuacion_Entonces_DevolverPuntuacion() {
        //arrange
		Tablero t = new Tablero(1,"hola");
        //assert
		assertEquals(0, t.calcularPuntuacion());
	}
```
**Patrón de diseño**

- Aplicamos factory para la creacion de niveles, debido a que pensando en un juego escalable y donde tenga la posibilidad de que los usuarios puedan cada vez mas jugar un juego con mayor dificultad y incluso un juego personalizado, con una interfaz global, este patron nos permitira generar una flexibilidad en cuanto a la creacion de niveles. cada vez que quieran  mas niveles, simplemente se agrega una nueva clase, sin tener que modificar la logica actual. y se podria reutilzar.

