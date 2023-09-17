/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows 10 Operating System Eclipse Version - 2023-03 
*/
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Instructor;

public class InstructorFileHelper implements FileHelper {
    String nameOfFile = "instructor.txt";
    File listOfObjects = new File(nameOfFile);

    @Override
	public boolean doesAFileExist() {
		if (listOfObjects.exists()) {
				return true;
		} else {
				return false;
		}
	}

    @Override
    public boolean writeFile(ArrayList<?> list) {
        ArrayList<Instructor> instructorsToWrite = (ArrayList<Instructor>) list;
        try {
            PrintWriter listOfObjects = new PrintWriter(nameOfFile);
            for (Instructor instructor : instructorsToWrite) {
                StringBuilder sb = new StringBuilder();
                sb.append(instructor.getFirstName() + "," + instructor.getLastName() + "," + instructor.getEmail());
                listOfObjects.println(sb.toString());
            }
            listOfObjects.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file called " + nameOfFile + " found when writing instructors.");
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<?> readFile() {
        ArrayList<Instructor> allInstructors = new ArrayList<Instructor>();
        Scanner fileIn;
        try {
            fileIn = new Scanner(listOfObjects);
            while (fileIn.hasNextLine()) {
                String value = fileIn.nextLine();
                String[] parts = value.split(",");
                /*
                 * This code block is for you to uncomment if you have errors or incorrect
                 * data.
                 * 
                 * System.out.println(parts[0]); System.out.println(parts[1]);
                 * System.out.println(parts[2]);
                 */
                Instructor currentInstructor;
                if (parts.length == 3) {
                    currentInstructor = new Instructor(parts[0], parts[1], parts[2]);
                } else if (parts.length == 2) {
                    currentInstructor = new Instructor(parts[0], parts[1]);
                } else {
                    currentInstructor = new Instructor();
                }
                allInstructors.add(currentInstructor);
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file called " + nameOfFile + " found when reading instructors.");
        }
        return allInstructors;
    }
}
