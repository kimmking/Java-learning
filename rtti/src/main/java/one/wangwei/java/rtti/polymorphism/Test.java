package one.wangwei.java.rtti.polymorphism;

class Dog{
	void play(){
		System.out.println("Dog paly");
		this.baseketball();
	}
	
	void baseketball(){
		System.out.println("Dog paly baseketball");
	}
}

class Labrador extends Dog{
	void baseketball(){
		System.out.println("Labrador Dog paly baseketball");
	}
}


public class Test {
	public static void main(String[] args){
		Dog dog = new Labrador();
		dog.play();
	}
}
