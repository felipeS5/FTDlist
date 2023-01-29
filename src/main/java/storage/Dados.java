package storage;

public class Dados {
	private String texto;
	private String estado = "progress";
	
	public Dados(String texto) {
		this.texto = texto;
	}
	
	public String toString() {
		return texto + " / " + estado;
	}
}