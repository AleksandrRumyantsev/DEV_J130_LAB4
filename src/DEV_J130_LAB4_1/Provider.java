package DEV_J130_LAB4_1;

import java.util.Random;

public class Provider extends Thread{

	private int delay;
	private String name;
	private int totalShip;

	public Provider (String name){
		delay = new Random().nextInt(5000);
		totalShip =0;
		this.name = name;
	}

	public String getNameProvider() {
		return name;
	}

	public int getTotalShip() {
		return totalShip;
	}

	public void shipProduct(){
		int balance = Storage.storage.getProduct();
		int batch = new Random().nextInt(10);
		Storage.storage.addProduct(batch, name);
		totalShip+=batch;
		System.out.println(name + ": всего отгрузил " + totalShip + " товаров.");
	}
	public void run(){
		for (int i=0;i<10;i++)  {
			shipProduct();
			try {Thread.sleep(delay);} catch (InterruptedException ex) {}
		}
	}
}
