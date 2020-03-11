package edu.tju.computer;

public abstract class CPU implements Component {
	
	final public static String type = "CPU";
	
	private String name;
	private int price;
	
	private int coreNum;
	
	public CPU(String name, int price, int coreNum) {
		this.name = name;
		this.price = price;
		this.coreNum = coreNum;
	}
	
	public CPU(CPU cpu) {
		this.name = cpu.name;
		this.price = cpu.price;
		this.coreNum = cpu.coreNum;
	}
	
	@Override
	public void work() {
		System.out.println("CPU work");
	}
	
	@Override
	final public String componentType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CPU))
			return false;
		CPU other = (CPU) obj;
		if (this.getBrand() != other.getBrand())
			return false;
		if (coreNum != other.coreNum)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CPU [name: " + name + ", price: " + price + ", coreNum: " + coreNum + ", brand: " + this.getBrand() + "]";
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getCoreNum() {
		return coreNum;
	}

	public void setCoreNum(int coreNum) {
		this.coreNum = coreNum;
	}
}
