package sourse;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
	private ArrayList<Cartltem> cart;

	public ShoppingCart() {
		cart = new ArrayList<Cartltem>();
	}

	public ArrayList<Cartltem> getCart() {
		return cart;
	}

	public void addCartItem(Cartltem item) {
		@SuppressWarnings("unused")
		Cartltem oldItem = null;
		if (item != null) {
			for (int i = 0; i < cart.size(); ++i) {
				oldItem = cart.get(i);
				if (oldItem.getId().equals(item.getId())) {
					oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
					return;
				}
			}
			cart.add(item);
		}
	}

	public boolean removeCartItem(String id) {
		Cartltem item = null;
		for (int i = 0; i < cart.size(); ++i) {
			item = cart.get(i);
			if (item.getId().equals(id)) {
				cart.remove(i);
				return true;
			}
		}
		return false;
	}

	public double getTotal() {
		Iterator<Cartltem> it = cart.iterator();
		double sum = 0.0;
		Cartltem item = null;
		while (it.hasNext()) {
			item = it.next();
			sum = sum + item.getPrice();
		}
		return sum;
	}
}
