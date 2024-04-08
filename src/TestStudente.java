public class TestStudente {
	public static void main(String args[]) {
		Studente A = new Studente("Mario","Rossi",29.2,10);

		A.setContinent(Continente.EUROPA);
		A.setAge(20);

		try {
			A.setAge(-10);
		} catch(Exception e) {
			System.err.println(e);
			//System.exit(0);
		}

		System.out.println(A.getInfo());
	}
}
