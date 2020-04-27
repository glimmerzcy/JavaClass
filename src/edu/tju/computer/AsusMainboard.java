package edu.tju.computer;

public class AsusMainboard extends Mainboard {
	
	final public static String brand = "Asus";
	
	public AsusMainboard(String name, int price, double speed) {
		super(name, price, speed);
	}

	public AsusMainboard(Mainboard mainboard) {
		super(mainboard);
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public Component copy() {
		return new AsusMainboard(this);
	}

}
