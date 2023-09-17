package controller;
/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows 10 Operating System Eclipse Version - 2023-03 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Classroom;

public class ClassroomFileHelper implements FileHelper {
	String nameOfFile = "classroom.txt";
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
		// TODO Auto-generated method stub
		ArrayList<Classroom> classroomsToWrite = (ArrayList<Classroom>) (list);
		try {
				PrintWriter listOfObjects = new PrintWriter(nameOfFile);
				for (Classroom c : classroomsToWrite) {
					StringBuilder sb = new StringBuilder();
					sb.append(c.getBuilding() + "," + c.getRoomNumber() + "," +
								c.getCampus() + "," + c.getType() + ","
								+ c.getCapacity());
					listOfObjects.println(sb.toString());
				}
				listOfObjects.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file called " + nameOfFile + " found when writing classrooms.");
			return false;
		}
		return true;
	}
	
	@Override
	public ArrayList<?> readFile() {
		// TODO Auto-generated method stub
		ArrayList<Classroom> allClassrooms = new ArrayList<Classroom>();
		Scanner fileIn;
		try {
			fileIn = new Scanner(listOfObjects);
			while (fileIn.hasNextLine()) {
				String value = fileIn.nextLine();
				String[] parts = value.split(",");
				/*
				* This code block is for you to uncomment if you have errors
				or incorrect data.
				* System.out.println(parts[0]);
				* System.out.println(parts[1]);
				* System.out.println(parts[2]);
				* System.out.println(parts[3]);
				* System.out.println(parts[4]);
				*/
				Classroom currentRoom = new Classroom(parts[0], parts[1],
				parts[2], parts[3], Integer.parseInt(parts[4]));
				allClassrooms.add(currentRoom);
			}
			fileIn.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("No file called " + nameOfFile + " found when reading classrooms.");	
	}
	return allClassrooms;
	}
}