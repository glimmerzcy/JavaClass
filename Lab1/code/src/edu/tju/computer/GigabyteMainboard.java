package edu.tju.computer;

public class GigabyteMainboard extends Mainboard {
	
	final public static String brand = "Gigabyte";
	
	public GigabyteMainboard(String name, int price, double speed) {
		super(name, price, speed);
	}

	public GigabyteMainboard(Mainboard mainboard) {
		super(mainboard);
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public Component copy() {
		return new GigabyteMainboard(this);
	}

}
