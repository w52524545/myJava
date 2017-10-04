package sourse;

public class Cartltem {
	private String name;
	private int quantity;
	private Double price;
	private String id;
	private String desc;

	public Cartltem(String name, int quantity, Double price, String id, String desc) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.id = id;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
