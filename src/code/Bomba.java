package code;

public class Bomba extends BuilderCasilla{

	public Bomba(){
		cas=new Casilla();
	}
	@Override
	public void darValor(String b) {
		// TODO Auto-generated method stub
		cas.darValor(b);
	}

	@Override
	public void ponerEstado() {
		// TODO Auto-generated method stub
		cas.cambiarEstado(false);
	}

}
