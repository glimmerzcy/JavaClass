package edu.tju.computer;

public abstract class RAM implements Component {
	
	final public static String type = "RAM";
	
	private String name;
	private int price;
	
	private int volume;
	
	public RAM(String name, int price, int volume) {
		this.name = name;
		this.price = price;
		this.volume = volume;
	}
	
	public RAM(RAM ram) {
		this.name = ram.name;
		this.price = ram.price;
		this.volume = ram.volume;
	}

	@Override
	public void work() {
		System.out.println("RAM work");
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
		if (!(obj instanceof RAM))
			return false;
		RAM other = (RAM) obj;
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
		return "RAM [name: " + name + ", price: " + price + ", volume: " + volume + ", brand: " + this.getBrand() + "]";
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
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
