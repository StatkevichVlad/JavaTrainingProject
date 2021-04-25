package mySQL;

public class MainTest {

	public static void main(String[] args) {
		DBworker bworker = new DBworker();
		DBAthletes dbAthletes = new DBAthletes(bworker);
		
	}

}
