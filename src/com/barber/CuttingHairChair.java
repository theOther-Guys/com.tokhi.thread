package com.barber;

public class CuttingHairChair{
	
	Person person ;
	private Barber barber;
	
	public CuttingHairChair() {
		// TODO Auto-generated constructor stub
	}
	public synchronized void setSittingPerson(Person person){
		this.person = person ;
	}
	public void setSittingPerson (Barber barber){
		this.barber = barber ;
	}
	public Person getPerson(){
		return person ;
	}
	public void setTheChairNull(){
		this.person = null ;
	}

}
