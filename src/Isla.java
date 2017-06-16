import java.util.LinkedList;

public class Isla {
	public LinkedList<Object> misioneros;
	public LinkedList<Object> canibales;
	private char direccion;
	
	public Isla(char d, int m, int c){
		this.misioneros = new LinkedList<>();
		this.canibales = new LinkedList<>();
		this.direccion = d;
		this.generarIsla(m,c);
	}
	
	private void generarIsla(int m, int c) {
		for (int i = 0; i < m; i++) {
			this.misioneros.add('M');
		}
		for (int i = 0; i < m; i++) {
			this.canibales.add('C');
		}
	}

	private boolean esSeguro(){
		return misioneros.size() >= canibales.size();
	}
	
	public void meterMisionero(Bote bote){
		misioneros.addAll(bote.obtenerMisioneros());
	}
	
	public void meterCanibal(Bote bote){
		canibales.addAll(bote.obtenerCanibales());
	}
	
	public boolean misioneroAlBote(Bote bote){
		Object misionero = misioneros.removeFirst();
		if(esSeguro()){
			bote.meterMisioneros(misionero);
			return true;
		}
		misioneros.add(misionero);
		return false;
	}
	
	public boolean canibalAlBote(Bote bote){
		Object canibal = canibales.removeFirst();
		if(esSeguro()){
			bote.meterCanibales(canibal);
			return true;
		}
		canibales.add(canibal);
		return false;
	}
}
