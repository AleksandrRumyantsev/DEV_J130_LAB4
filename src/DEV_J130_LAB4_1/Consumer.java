package DEV_J130_LAB4_1;

import java.util.Random;

public class Consumer extends Thread{

	private int delay;
	private String name;
	private int totalBuy;

	public Consumer (String name){
		this.name = name;
		delay=new Random().nextInt(10);
		totalBuy =0;
	}
	public String getNameConsumer() {
		return name;
	}

	public int getTotalBuy() {
		return totalBuy;
	}

	public void buyProduct (){
		int batch = new Random().nextInt(10);
		if (!Storage.storage.removeProduct(batch, name)){
			try {Thread.sleep(2000);} catch (InterruptedException ex) {}
			buyProduct();
		}else {
			totalBuy+=batch;
			System.out.println(name + ": Всего купил " + totalBuy + " товаров.");
		}
	}

	public void run(){
		for (int i=0;i<10;i++)  {
			buyProduct();
			try {Thread.sleep(delay);} catch (InterruptedException ex) {}
		}
	}
}
