package edu.tju.computer;

public class WestDigitalsHardDisk extends HardDisk {
	
	final public static String brand = "WestDigitals";
	
	public WestDigitalsHardDisk(String name, int price, int volume) {
		super(name, price, volume);
	}

	public WestDigitalsHardDisk(HardDisk hardDisk) {
		super(hardDisk);
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public Component copy() {
		return new WestDigitalsHardDisk(this);
	}

}
