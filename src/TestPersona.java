public class TestPersona {
	
	public static void main(String args[]) {
		Persona A = new Persona("Marco","Rossi");
		Persona B = new Persona("Giuseppe","Verdi",30,Continente.EUROPA);
	
		System.out.println(A.getInfo());
		System.out.println(B.getInfo());

		A.setAge(20);
		A.setContinent(Continente.AMERICA);
		B.setAge(-10);

		System.out.println(A.getInfo());
		System.out.println(B.getInfo());
	}
}
