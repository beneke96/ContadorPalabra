public class Main {

	public static void main(String[] args) {
		
		ContadorPalabra m = new ContadorPalabra();
		m.setVisible(true);
		
		// Ejecuci�n del Hilo
		new Thread(m).start();
		
}
}