package one.wangwei.java.rtti.typeinfo;

import java.util.HashMap;

import one.wangwei.java.rtti.typeinfo.pets.Cat;
import one.wangwei.java.rtti.typeinfo.pets.Cymric;
import one.wangwei.java.rtti.typeinfo.pets.Dog;
import one.wangwei.java.rtti.typeinfo.pets.ForNameCreator;
import one.wangwei.java.rtti.typeinfo.pets.Hamster;
import one.wangwei.java.rtti.typeinfo.pets.Manx;
import one.wangwei.java.rtti.typeinfo.pets.Mouse;
import one.wangwei.java.rtti.typeinfo.pets.Mutt;
import one.wangwei.java.rtti.typeinfo.pets.Pet;
import one.wangwei.java.rtti.typeinfo.pets.PetCreator;
import one.wangwei.java.rtti.typeinfo.pets.Pug;
import one.wangwei.java.rtti.typeinfo.pets.Rat;
import one.wangwei.java.rtti.typeinfo.pets.Rodent;

public class PetCount {
	
	static class PetCounter extends HashMap<String,Integer>{
		
		private static final long serialVersionUID = -1215991836054403566L;

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
			String name = pet.getClass().getSimpleName();
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
			System.out.println(name);
		}
	}
	
	public static void main(String[] args){
		countPets(new ForNameCreator());
	}
}
