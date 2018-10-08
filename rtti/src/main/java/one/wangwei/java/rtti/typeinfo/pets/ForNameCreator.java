package one.wangwei.java.rtti.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
	
	private static List<Class<? extends Pet>> types = 
			new ArrayList<Class<? extends Pet>>();
	
	private static String[] typeNames = {
		"one.wangwei.java.rtti.typeinfo.pets.Cat",
		"one.wangwei.java.rtti.typeinfo.pets.Cymric",
		"one.wangwei.java.rtti.typeinfo.pets.Dog",
		"one.wangwei.java.rtti.typeinfo.pets.EgyptianMau",
		"one.wangwei.java.rtti.typeinfo.pets.Hamster",
		"one.wangwei.java.rtti.typeinfo.pets.Manx",
		"one.wangwei.java.rtti.typeinfo.pets.Mouse",
		"one.wangwei.java.rtti.typeinfo.pets.Mutt",
		"one.wangwei.java.rtti.typeinfo.pets.Pug",
		"one.wangwei.java.rtti.typeinfo.pets.Rodent",
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
