package batalha;

public class Controller {
	// cria o vetor de eventos
	private EventSet es = new EventSet();
	
	// adiciona os eventos
	public void addEvent(Event c) { es.add(c); }
	
	//roda
	public void run() {
		Event e;
		while((e = es.getNext()) != null) {
			if(e.ready()) {
				e.action();
				System.out.println(e.description());
				es.removeCurrent();
			}
		}
	}
}