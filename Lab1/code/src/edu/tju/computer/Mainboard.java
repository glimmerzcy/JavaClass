package edu.tju.computer;

public abstract class Mainboard implements Component {
	
	final public static String type = "Mainboard";
	
	private String name;
	private int price;
	
	private double speed;
	
	public Mainboard(String name, int price, double speed) {
		this.name = name;
		this.price = price;
		this.speed = speed;
	}

	public Mainboard(Mainboard mainboard) {
		this.name = mainboard.name;
		this.price = mainboard.price;
		this.speed = mainboard.speed;
	}
	
	@Override
	public void work() {
		System.out.println("Mainboard work");
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
		if (!(obj instanceof Mainboard))
			return false;
		Mainboard other = (Mainboard) obj;
		if (this.getBrand() != other.getBrand())
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mainboard [name: " + name + ", price: " + price + ", speed: " + speed + ", brand: " + this.getBrand() + "]";
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
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
