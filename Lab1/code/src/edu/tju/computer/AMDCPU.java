package edu.tju.computer;

public class AMDCPU extends CPU {

	final public static String brand = "AMD";
	
	public AMDCPU(String name, int price, int coreNum) {
		super(name, price, coreNum);
	}
	
	public AMDCPU(AMDCPU cpu) {
		super(cpu);
	}

	@Override
	public String getBrand() {
		return brand;
	}
	
	@Override
	public AMDCPU copy() {
		return new AMDCPU(this);
	}

}
