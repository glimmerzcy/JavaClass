package edu.tju.computer;

public abstract class HardDisk implements Component {
	
	final public static String type = "HardDise";
	
	private String name;
	private int price;
	
	private int volume;
	
	public HardDisk(String name, int price, int volume) {
		this.name = name;
		this.price = price;
		this.volume = volume;
	}

	public HardDisk(HardDisk hardDisk) {
		this.name = hardDisk.name;
		this.price = hardDisk.price;
		this.volume = hardDisk.volume;
	}

	@Override
	public void work() {
		System.out.println("HardDisk work");
	}

	@Override
	public String componentType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof HardDisk))
			return false;
		HardDisk other = (HardDisk) obj;
		if (this.getBrand() != other.getBrand())
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (volume != other.volume)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "HardDisk [name: " + name + ", price: " + price + ", volume: " + volume + ", brand: " + this.getBrand() + "]";
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
