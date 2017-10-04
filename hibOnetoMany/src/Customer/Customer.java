package Customer;

import java.util.HashSet;
import java.util.Set;

import LinkMan.LinkMan;

public class Customer {

	private Integer id;
	private String custName;
	private String custLevel;
	private String custSource;
	private String custPhone;
	private String custMobile;
	private Set<LinkMan> linkMans = new HashSet<LinkMan>();

	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}

	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Customer(String custName, String custLevel, String custSource, String custPhone, String custMobile) {
		super();
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", custLevel=" + custLevel + ", custSource="
				+ custSource + ", custPhone=" + custPhone + ", custMobile=" + custMobile + "]";
	}
}
