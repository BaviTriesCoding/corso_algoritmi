public class Persona {
	private final String nome;
	private final String cognome;
	private int          anni;
	private Continente   continente;

	public Persona(String nome, String cognome) {
		this.nome       = nome;
		this.cognome    = cognome;
		this.anni       = 0;
		this.continente = Continente.SCONOSCIUTO;
	}

	public Persona(String nome, String cognome, int anni, Continente continente) {
		this.nome       = nome;
		this.cognome    = cognome;
		this.anni       = anni;
		this.continente = continente;
	}

	public void setAge(int anni) {
		if(anni >= 0)
			this.anni = anni;
	}

	public void setContinent(Continente continente) {
		this.continente = continente;
	}

	public String getName() {
		return nome;
	}
	
	public String getSurname() {
		return cognome;
	}

	public int getAge() {
		return anni;
	}

	public Continente getContinent() {
		return continente;
	}
	
	public String getInfo() {
		return "Mi chiamo " + nome + " " + cognome + " ho " + anni + " anni e vivo in " + continente;
	}
	
}
