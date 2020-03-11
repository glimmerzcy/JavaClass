package edu.tju.computer;

import java.util.ArrayList;

public class ComputerStore {
	
	public static void  main(String[] args) {
		ArrayList<Computer> computers = new ArrayList<Computer>();
		
		System.out.println("1.New a Computer Lenovo-999");
		ArrayList<Component> components = new ArrayList<Component>();
		components.add(new IntelCPU("Inter-i7", 3000, 4));
		components.add(new SamsungRAM("Sam99", 1000, 500));
		components.add(new SeagateHardDisk("Sea88", 500, 1024));
		components.add(new AsusMainboard("Asus33", 200, 3.2));
		computers.add(new Computer("Lenovo-999", components));
		System.out.println(computers.get(0).toString());

		// 测试结果：
		// 
		// 1.New a Computer Lenovo-999
		// name: Lenovo-999
		// price: 4700
		// components:
		// 	CPU [name: Inter-i7, price: 3000, coreNum: 4, brand: Intel]
		// 	RAM [name: Sam99, price: 1000, volume: 500, brand: Samsung]
		// 	HardDisk [name: Sea88, price: 500, volume: 1024, brand: Seagate]
		// 	Mainboard [name: Asus33, price: 200, speed: 3.2, brand: Asus]
		
		System.out.println("2.Add a hard disk for Lenvo-999");
		computers.get(0).addComponents(new SeagateHardDisk("Seagate-00", 300, 500));
		System.out.println(computers.get(0).toString());
		
		// 测试结果
		// 
		// 2.Add a hard disk for Lenvo-999
		// name: Lenovo-999
		// price: 5000
		// components:
		// 	CPU [name: Inter-i7, price: 3000, coreNum: 4, brand: Intel]
		// 	RAM [name: Sam99, price: 1000, volume: 500, brand: Samsung]
		// 	HardDisk [name: Sea88, price: 500, volume: 1024, brand: Seagate]
		// 	Mainboard [name: Asus33, price: 200, speed: 3.2, brand: Asus]
		// 	HardDisk [name: Seagate-00, price: 300, volume: 500, brand: Seagate]
		
		System.out.println("3.Test Lenvo-999's work");
		computers.get(0).work();
		System.out.println();

		// 测试结果
		//
		// 3.Test Lenvo-999's work
		// CPU work
		// RAM work
		// HardDisk work
		// Mainboard work
		// HardDisk work
		
		System.out.println("4.New a Computer Dell-888");
		components = new ArrayList<Component>();
		components.add(new AMDCPU("AMD11", 2000, 4));
		components.add(new KingstonRAM("King22", 800, 600));
		components.add(new WestDigitalsHardDisk("Wes77", 600, 2048));
		components.add(new GigabyteMainboard("Giga90", 400, 4.1));
		computers.add(new Computer("Dell-888", components));
		System.out.println(computers.get(1).toString());

		// 测试结果
		// 
		// 4.New a Computer Dell-888
		// name: Dell-888
		// price: 3800
		// components:
		// 	CPU [name: AMD11, price: 2000, coreNum: 4, brand: AMD]
		// 	RAM [name: King22, price: 800, volume: 600, brand: Kingston]
		// 	HardDisk [name: Wes77, price: 600, volume: 2048, brand: WestDigitals]
		// 	Mainboard [name: Giga90, price: 400, speed: 4.1, brand: Gigabyte]
		
		System.out.println("5.New a Computer hp-777");
		components = new ArrayList<Component>();
		components.add(new IntelCPU("Intel-i5", 2500, 4));
		components.add(new KingstonRAM("King22", 1000, 600));
		components.add(new SeagateHardDisk("Sea77", 600, 2048));
		components.add(new GigabyteMainboard("Giga88", 400, 4.1));
		computers.add(new Computer("hp-777", components));
		System.out.println(computers.get(2).toString());

		// 测试结果
		// 
		// 5.New a Computer hp-777
		// name: hp-777
		// price: 4500
		// components:
		// 	CPU [name: Intel-i5, price: 2500, coreNum: 4, brand: Intel]
		// 	RAM [name: King22, price: 1000, volume: 600, brand: Kingston]
		// 	HardDisk [name: Sea77, price: 600, volume: 2048, brand: Seagate]
		// 	Mainboard [name: Giga88, price: 400, speed: 4.1, brand: Gigabyte]
		
		System.out.println("6.Remove RAM from hp-777:");
		computers.get(2).removeComponents(new KingstonRAM("King22", 1000, 600));
		System.out.println(computers.get(2).toString());

		// 测试结果
		// 
		// 6.Remove RAM from hp-777:
		// name: hp-777
		// price: 3500
		// components:
		// 	CPU [name: Intel-i5, price: 2500, coreNum: 4, brand: Intel]
		// 	HardDisk [name: Sea77, price: 600, volume: 2048, brand: Seagate]
		// 	Mainboard [name: Giga88, price: 400, speed: 4.1, brand: Gigabyte]

	}
}
