package DEV_J130_LAB4_1;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<Thread> threadList;
	private static Provider providers[]=new Provider[5];
	private static Consumer consumers[]=new Consumer[5];
	public static void main(String[] args) {
		threadList = new ArrayList<Thread>();
		for (int i=0; i<5;i++){
			providers [i] = new Provider("Поставщик "+ (i+1));
			consumers [i] = new  Consumer("Покупатель "+ (i+1));
			threadList.add(new Thread(providers[i]));
			threadList.add(new Thread(consumers [i]));
		}
		//try {
		for (Thread currentThread:threadList){
			currentThread.start();
		//	currentThread.join();
		}
		//} catch (InterruptedException e) {
		//	throw new RuntimeException(e);
		//}
		for (Thread currentThread:threadList){ //костыль на ожидание выполнения всех потоков и продолжение основного кода
			while (currentThread.isAlive()){
			}
		}
		System.out.println("Все закончили");
		for (int i =0;i<5; i++){
			System.out.println(providers[i].getNameProvider() + ": отгрузил всего " + providers[i].getTotalShip() + " товаров.");
			System.out.println(consumers[i].getNameConsumer() + ": купил всего " + consumers[i].getTotalBuy() + " товаров.");
		}
		System.out.println("На складе осталось: " + Storage.storage.getProduct() + " товаров.");
	}
}