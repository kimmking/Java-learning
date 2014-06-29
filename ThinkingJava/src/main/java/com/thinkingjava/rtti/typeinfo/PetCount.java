package com.thinkingjava.rtti.typeinfo;

import java.util.HashMap;

import com.thinkingjava.rtti.typeinfo.pets.Cat;
import com.thinkingjava.rtti.typeinfo.pets.Cymric;
import com.thinkingjava.rtti.typeinfo.pets.Dog;
import com.thinkingjava.rtti.typeinfo.pets.ForNameCreator;
import com.thinkingjava.rtti.typeinfo.pets.Hamster;
import com.thinkingjava.rtti.typeinfo.pets.Manx;
import com.thinkingjava.rtti.typeinfo.pets.Mouse;
import com.thinkingjava.rtti.typeinfo.pets.Mutt;
import com.thinkingjava.rtti.typeinfo.pets.Pet;
import com.thinkingjava.rtti.typeinfo.pets.PetCreator;
import com.thinkingjava.rtti.typeinfo.pets.Pug;
import com.thinkingjava.rtti.typeinfo.pets.Rat;
import com.thinkingjava.rtti.typeinfo.pets.Rodent;

public class PetCount {
	
	static class PetCounter extends HashMap<String,Integer>{
		public void count(String type){
			Integer quantity = get(type);
			if(quantity == null)
				put(type,1);
			else
				put(type,quantity+1);
		}
	}
	
	public static void countPets(PetCreator creator){
		PetCounter counter = new PetCounter();
		for(Pet pet : creator.createArray(28)){
			pet.getClass().getSimpleName();
			if(pet instanceof Pet){
				counter.count("pet");
			}
			if(pet instanceof Dog){
				counter.count("Dog");
			}
			if(pet instanceof Mutt){
				counter.count("Mutt");
			}
			if(pet instanceof Pug){
				counter.count("Pug");
			}
			if(pet instanceof Cat){
				counter.count("Cat");
			}
			if(pet instanceof Manx){
				counter.count("Manx");
			}
			if(pet instanceof Cymric){
				counter.count("Cymric");
			}
			if(pet instanceof Rodent){
				counter.count("Rodent");
			}
			if(pet instanceof Rat){
				counter.count("Rat");
			}
			if(pet instanceof Mouse){
				counter.count("Mouse");
			}
			if(pet instanceof Hamster){
				counter.count("Hamster");
			}
			System.out.println();
			System.out.println(counter);
		}
	}
	
	public static void main(String[] args){
		countPets(new ForNameCreator());
	}
}
