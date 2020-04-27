package edu.tju.computer;

import java.util.ArrayList;

public class Computer {
	
	private String name;
	ArrayList<Component> components;
	private int price;
	
	public Computer(String name,ArrayList<Component> components) {
		this.name = name;
		this.setComponents(components);
	}
	
	public void setComponents(ArrayList<Component> components) {
		this.components = new ArrayList<Component>();
		this.price = 0;
		for (Component component : components) {
			this.components.add(component.copy());
			this.price += component.getPrice();
		}
	}

	public ArrayList<Component> getComponents() {
		ArrayList<Component> components = new ArrayList<Component>();
		for (Component component : this.components) {
			components.add(component.copy());
		}
		return components;
	}
	
	public void addComponents(Component component) {
		components.add(component.copy());
		this.price += component.getPrice();
	}
	
	public boolean removeComponents(Component component) {
		if (components.remove(component)) {
			this.price -= component.getPrice();
			return true;
		}
		else return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		String s = "name: " + name + '\n' + "price: " + price + '\n' + "components:\n";
		for (Component component: components) {
			s += '\t' + component.toString() + '\n';
		}
		return s;
	}
	
	public void work() {
		for (Component component: components) {
			component.work();
		}
	}
	
	public ArrayList<Component> getComponentsByType(String type) {
		ArrayList<Component> components = new ArrayList<Component>();
		for (Component component : this.components) {
			if (component.componentType().equals(type))
			components.add(component.copy());
		}
		return components;
	}
	
	public ArrayList<Component> getComponentsByBrand(String brand) {
		ArrayList<Component> components = new ArrayList<Component>();
		for (Component component : this.components) {
			if (component.getBrand().equals(brand))
				components.add(component.copy());
		}
		return components;
	}
	
	public ArrayList<Component> getComponentsByName(String name) {
		ArrayList<Component> components = new ArrayList<Component>();
		for (Component component : this.components) {
			if (component.getName().equals(name))
				components.add(component.copy());
		}
		return components;
	};
	
}
