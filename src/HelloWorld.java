/**
 * <b>HelloWorld</b> ad oggetti
 * @author Pippo
 * @version 1.0
 */
public class HelloWorld {
	/** Messaggio privato */
	protected final String msg;

	/**
   * Costruttore di un oggetto di tipo HelloWord
   * @param msg messaggio da salvare
   */
	public HelloWorld(String msg) {
		this.msg =  msg;
	}

	/**
   * Stampa il messaggio salvato
   */
	public void print() {
		System.out.println(msg);
	}
}
