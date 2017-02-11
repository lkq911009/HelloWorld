package dlValidate;

public class inherience {

	public static void main(String[] args) throws ClassNotFoundException {

		Shape shape = new Circle();
		System.out.println(shape.name);
		shape.printType();
		shape.printName();
	}

}

class Bread {
	static String ss = "xixixix";
	static {
		System.out.println("Bread is loaded");
	}

	public Bread() {
		System.out.println("bread");
	}
}

class Meal {

	public Meal() {
		System.out.println("meal");
	}

	Bread bread = new Bread();
}

/*
 * non-params constructor
 */
class Draw {
	// Shape c= new Shape();
	public Draw(String type) {
		System.out.println(type + " draw constructor");
	}
}

class Shape {
	private Draw draw = new Draw("shape");
    public String name = "shape";
	public Shape() {
		System.out.println("shape constructor");
	}

	public void printType() {
		System.out.println("this is shape");
	}

	public static void printName() {
		System.out.println("shape");
	}

}

class Circle extends Shape {
	private Draw draw = new Draw("circle");

	public Circle() {
		System.out.println("circle constructor");
	}

	public void printType() {
		System.out.println("this is circle");
	}

	public static void printName() {
		//System.out.println("circle11111");
	}
}
