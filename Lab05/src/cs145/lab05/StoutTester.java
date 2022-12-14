package cs145.lab05;

import java.util.Arrays;

import cs145.lab05.StoutStudent.Level;

public class StoutTester {

	public static void main(String[] args) {

		StoutPerson[] people = new StoutPerson[6];

		people[0] = new StoutFaculity(1256, "Turner", "Scott", "Professor");
		people[1] = new StoutFaculity(6150, "Christie", "Diane", "Professor");
		people[2] = new StoutFaculity(1073, "Mason", "Terry", "Professor");
		people[3] = new StoutStudent(1283, "Muzik", "Quincy", Level.junior, "Computer Science/Animation");
		people[4] = new StoutStudent(1234, "Billy", "Hill");
		people[5] = new StoutSI(2289,"Gauvin","Luke",Level.senior,"CSE","CS145");

		Arrays.sort(people);
		
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i]);
		}
	}

}
