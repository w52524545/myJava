package LinkMan;

import Customer.Customer;

public class LinkMan {
	private Integer id;
	private String lname;
	private String lgender;
	private String lphone;
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLgender() {
		return lgender;
	}

	public void setLgender(String lgender) {
		this.lgender = lgender;
	}

	public String getLphone() {
		return lphone;
	}

	public void setLphone(String lphone) {
		this.lphone = lphone;
	}

	public LinkMan() {
		super();
	}

	public LinkMan(String lname, String lgender, String lphone) {
		super();
		this.lname = lname;
		this.lgender = lgender;
		this.lphone = lphone;
	}

	@Override
	public String toString() {
		return "LinkMan [id=" + id + ", lname=" + lname + ", lgender=" + lgender + ", lphone=" + lphone + "]";
	}
}
