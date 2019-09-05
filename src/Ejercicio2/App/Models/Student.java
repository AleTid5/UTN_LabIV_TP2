package Ejercicio2.App.Models;

import java.util.List;
import java.util.Optional;

public class Student {
	private static List<Integer> notes = null;

	public static void setNotes(List<Integer> list) {
		Student.notes = list;
	}
	
	public static double getAverage() {
		Optional<Integer> total = Student.notes.stream().reduce((note1, note2) -> note1 + note2);
		
		return Math.round(((double) total.get() / Student.notes.size()) * 100.0) / 100.0;
	}
	
	public static boolean canBePromoted() {
		return ! Student.notes.stream().anyMatch(note -> note < 8);
	}
	
	public static boolean canBeRegularized() {
		return ! Student.notes.stream().anyMatch(note -> note < 6);
	}
}
