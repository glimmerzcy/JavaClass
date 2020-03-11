package edu.tju.computer;

public class SeagateHardDisk extends HardDisk {
	
	final public static String brand = "Seagate";
	
	public SeagateHardDisk(String name, int price, int volume) {
		super(name, price, volume);
	}

	public SeagateHardDisk(HardDisk hardDisk) {
		super(hardDisk);
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public Component copy() {
		return new SeagateHardDisk(this);
	}
	
}
