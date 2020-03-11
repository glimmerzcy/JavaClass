package edu.tju.computer;

public class KingstonRAM extends RAM {
	
	final public static String brand = "Kingston";
	
	public KingstonRAM(String name, int price, int volume) {
		super(name, price, volume);
	}

	public KingstonRAM(RAM ram) {
		super(ram);
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public Component copy() {
		return new KingstonRAM(this);
	}

}
