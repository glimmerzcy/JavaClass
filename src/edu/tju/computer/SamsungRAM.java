package edu.tju.computer;

public class SamsungRAM extends RAM {
	
	final public static String brand = "Samsung";
	
	public SamsungRAM(String name, int price, int volume) {
		super(name, price, volume);
	}

	public SamsungRAM(RAM ram) {
		super(ram);
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public Component copy() {
		return new SamsungRAM(this);
	}

}
