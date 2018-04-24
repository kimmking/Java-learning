package com.thinkingjava.rtti.typeinfo.pets;

import java.util.LinkedHashMap;
import java.util.Map;

import net.mindview.util.MapData;
import static net.mindview.util.Print.*;

/**
 * {@link #PetCount3}
 * @author wangwei
 *
 */
public class PetCount3 {
	
	static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer>{

		private static final long serialVersionUID = 650781150490849843L;
		
		public PetCounter(){
			super(MapData.map(LiteralPetCreator.allTypes, 0));
		}
		
		public void count(Pet pet){
			for(java.util.Map.Entry<Class<? extends Pet>, Integer> pair: this.entrySet())
				if(pair.getKey().isInstance(pet))
					put(pair.getKey(),pair.getValue() + 1);
		}
		
		public String toString(){
			StringBuilder result = new StringBuilder("{");
			for(Map.Entry<Class<? extends Pet>, Integer> pair:entrySet()){
				result.append(pair.getKey().getSimpleName());
				result.append("=");
				result.append(pair.getValue());
				result.append(", ");
			}
			result.delete(result.length()-2, result.length());
			result.append("}");
			return result.toString();
		}
		
		public static void main(String[] args){
			PetCounter petCount = new PetCounter();
			for(Pet pet : Pets.createArray(30)){
				printnb(pet.getClass().getSimpleName() + " ");
				petCount.count(pet);
			}
			print();
			print(petCount);
		}
	}
}
