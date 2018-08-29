package one.wangwei.java.rtti.typeinfo;


class Building{};
class House extends Building{};

public class ClassCasts {
	
	Building b = new House();
	Class<House> houseType = House.class;
	
	House h = houseType.cast(b);
}
