package com.barber;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.SwingUtilities;

public class RunBarberShop {

	static int number = 0;
	static ArrayList<Chair> chairs = new ArrayList<Chair>();

	static Barber barber = new Barber();
	static CuttingHairChair hairChair = new CuttingHairChair();
	static ExecutorService executor = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {

		assignChairs();
		assignNewPerson();
		hairChair.setSittingPerson(new Person());
		
		for (int index = 0; index < 10; index++) {
			executor.execute(chairs.get(index).getSittingPerson());
		}
//		for (int index = 0; index < chairs.size(); index++) {
//			synchronized (hairChair) {
//					hairChair.setSittingPerson(chairs.get(index).getSittingPerson());
//					
//			}
//		}
		Barber barber = new Barber();
		barber.start();
		
		executor.shutdown();

	}

	private static void assignChairs() {
		for (int index = 0; index < 10; index++) {
			chairs.add(new Chair());
		}
	}

	private static void assignNewPerson() {
		// TODO Auto-generated method stub
		for (int index = 0; index < chairs.size(); index++) {
			chairs.get(index).setChairForPerson(new Person("ahmad"));
		}

	}

	public static boolean checkThePersonisSitting(Chair chair, Person person) {

		if (chair.isFull) {
			System.out.println(" the chair is full please go sit on next One ");
			return false;
		} else {
			chair.setChairForPerson(person);
			return true;
		}
	}

	public static Person isPersonLeft() {
		for (int index = 0; index < chairs.size(); index++) {
			if (chairs.get(index).isFull) {
				return chairs.get(index).getSittingPerson();
			}
		}
		return null;
	}

	public static Person checkHairChair() {
		if (hairChair.getPerson().equals(null)) {
			System.out.println(" next person ");
			return chairs.get(number).getSittingPerson();
		} else {
			return null;
		}
	}

}
