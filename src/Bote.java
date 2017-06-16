import java.util.LinkedList;

public class Bote {

	private LinkedList<Object> misioneros;
	private LinkedList<Object> canibales;
	private int capacidad;
	private char direccion;
	
	public Bote(int capacidad, char direccion_inicial){
		this.capacidad = capacidad;
		this.direccion = direccion_inicial;
		this.misioneros = new LinkedList<>();
		this.canibales = new LinkedList<>();
	}
	
	public LinkedList<Object> obtenerMisioneros() {
		return this.misioneros;
	}

	public LinkedList<Object> obtenerCanibales() {
		return this.canibales;
	}

	public void meterMisioneros(Object m) {
		this.misioneros.add(m);
	}

	public void meterCanibales(Object c) {
		this.misioneros.add(c);
	}
	
}
