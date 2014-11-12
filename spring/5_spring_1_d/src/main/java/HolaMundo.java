
public class HolaMundo {
	private HolaService service;
	private String mensaje;
	private int contador;
	
	public HolaMundo(int contador) {
		System.out.println(this.getClass().getName()+" constructor");
		this.contador = contador;
	}
	
	public void display() {
		for (int i=0 ; i<contador ;i++) {
			System.out.println(mensaje);
		}
		
		service.service();
	}

	public final String getMensaje() {
		return mensaje;
	}

	public final void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public final HolaService getService() {
		return service;
	}

	public final void setService(HolaService service) {
		this.service = service;
	}
	
	
	
}
