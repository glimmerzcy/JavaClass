package edu.tju.computer;

public interface Component {
	public void work();
	public String getBrand();
	public String componentType();
	public void setName(String name);
	public String getName();
	public int getPrice();
	public void setPrice(int price);
	public Component copy();
}