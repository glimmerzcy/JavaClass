package edu.tju.computer;

public class IntelCPU extends CPU {
	
	final public static String brand = "Intel";
	
	public IntelCPU(String name, int price, int coreNum) {
		super(name, price, coreNum);
	}
	
	public IntelCPU(IntelCPU cpu) {
		super(cpu);
	}

	@Override
	public String getBrand() {
		return brand;
	}
	
	@Override
	public IntelCPU copy() {
		return new IntelCPU(this);
	}
}
