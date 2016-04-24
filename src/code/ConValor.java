package code;

public class ConValor extends BuilderCasilla{

	public ConValor(){
		cas=new Casilla();
	}
	@Override
	public void darValor(String b) {
		// TODO Auto-generated method stub
		cas.darValor(String.valueOf(b));
		
	}

	@Override
	public void ponerEstado() {
		// TODO Auto-generated method stub
		//cas.cambiarEstado(false);
	}
}
