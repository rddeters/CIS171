package tests;
import model.Classroom;

/**  
 * River Deters - mddeters  
 * CIS171 22149
 * July 7th, 2023
 * Windows 10 Operating System Eclipse Version - 2023-03
 */ 

public class RegistrationTesterDeters {
	public static void main(String[] args) {      
		Classroom compSciLab = new Classroom("8", "17", "Ankeny", "Computer Lab", 20);
		Classroom bioLab = new Classroom("3", "28a", "Carroll", "Science Lab", 22);
		Classroom litRoom = new Classroom("Betts", "12", "Urban", "Classroom", 18);
		
		System.out.println(compSciLab.toString());
		System.out.println(bioLab.toString());
		System.out.println(litRoom.toString());
	}
}
