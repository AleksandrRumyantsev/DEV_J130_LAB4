package DEV_J130_LAB4_1;

public class Storage {
	private volatile int  product;
	public static Storage storage = new Storage();

	private Storage() {
		this.product =0;
	}

	public synchronized int getProduct() {
		return product;
	}


	public synchronized void addProduct (int product, String name){
		this.product +=product;
		System.out.println(name + " произвел и поставил на склад " + product + " товаров.");
		System.out.println("Остаток товаров на складе = " + this.product);
		notifyAll();
	}
	public synchronized boolean removeProduct (int product, String name){
		if (this.product<product){
			System.out.println(name + ": не достаточно товара. Ожидает.");
			return false;
		}else {
			this.product -= product;
			System.out.println(name + ": купил " + product + " товаров.");
			System.out.println("Остаток товаров на складе = " + this.product);
			notifyAll();
			return true;
		}
	}
}
