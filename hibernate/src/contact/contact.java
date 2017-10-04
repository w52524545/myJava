package contact;

import person.Person;

public class contact {
	private Integer id;
	private Integer phone;
	private Integer QQ;
	private Character weixin;
	private Character tel;
	private Person person;
	
	public contact() {
	}
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getQQ() {
		return QQ;
	}
	public void setQQ(Integer qQ) {
		QQ = qQ;
	}
	public char getWeixin() {
		return weixin;
	}
	public void setWeixin(Character weixin) {
		this.weixin = weixin;
	}
	public Character getTel() {
		return tel;
	}
	public void setTel(Character tel) {
		this.tel = tel;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
