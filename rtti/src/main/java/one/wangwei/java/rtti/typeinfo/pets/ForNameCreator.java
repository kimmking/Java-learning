package one.wangwei.java.rtti.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
	
	private static List<Class<? extends Pet>> types = 
			new ArrayList<Class<? extends Pet>>();
	
	private static String[] typeNames = {
		"com.thinkingjava.rtti.typeinfo.pets.Cat",
		"com.thinkingjava.rtti.typeinfo.pets.Cymric",
		"com.thinkingjava.rtti.typeinfo.pets.Dog",
		"com.thinkingjava.rtti.typeinfo.pets.EgyptianMau",
		"com.thinkingjava.rtti.typeinfo.pets.Hamster",
		"com.thinkingjava.rtti.typeinfo.pets.Manx",
		"com.thinkingjava.rtti.typeinfo.pets.Mouse",
		"com.thinkingjava.rtti.typeinfo.pets.Mutt",
		"com.thinkingjava.rtti.typeinfo.pets.Pug",
		"com.thinkingjava.rtti.typeinfo.pets.Rodent",
	};
	
	@SuppressWarnings("unchecked")
	private static void loader(){
		for(String name : typeNames){
			try {
				types.add((Class<? extends Pet>) Class.forName(name));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	static{
		loader();
	}
	
	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}
}
