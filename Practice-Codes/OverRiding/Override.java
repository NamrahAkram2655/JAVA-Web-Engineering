class Circle {

	int i, j;

	Circle(int a, int b) {
		i = a;
		j = b;
	}

	void show() {
		System.out.println("i and j: " + i + " " + j);
	}
}

class Cylinder extends Circle {
	int k;

	Cylinder(int a, int b, int c) {
		super(a, b);
		k = c;
	}

	void show() {
		super.show(); // this calls show() in Super class (A)
		System.out.println("k: " + k);
	}
}

class Override {

	public static void main(String args[]) {
		Cylinder subOb = new Cylinder(1, 2, 3);
		Circle supOb = new Circle(1, 2);

		subOb.show(); // this calls show() in B class

		supOb.show(); // this calls show() in A class

	}

}
