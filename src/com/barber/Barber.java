package com.barber;

public class Barber extends Thread implements Runnable{
	
	boolean isCutting ;
	public Barber(){
		
	}
	public void cutHair(Person person){
		isCutting = true ;
		System.out.println(" Cutting person's hair ");
		RunBarberShop.hairChair.setTheChairNull();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finished(person);
	}
	private void finished (Person person){
		System.out.println(" finished cutting his hair now you can go ");
		person = null ;
		isCutting = false ;
	}
	public boolean getIsCutting(){
		return isCutting ;
	}
	public boolean getPersonForCuttingHair()throws NullPointerException{
		try {
		if (!RunBarberShop.hairChair.getPerson().equals(null)){
			cuttThePersonsHair();
		}else {
			System.err.println(" it's time for sleeping ");
				Thread.sleep(5000);
		}
		} catch(NullPointerException e){
			
		}catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return false ;
	}
	
	private void cuttThePersonsHair() {
		// TODO Auto-generated method stub
		cutHair(RunBarberShop.hairChair.getPerson());
		
	}
	public void run (){
		while (true ){
		
			getPersonForCuttingHair();
		
		sleepBarber();
		}
	}
	public void sleepBarber(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
