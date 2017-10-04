package person;

import java.util.Date;

import contact.contact;

public class Person {
	private Integer id;
	private String name;
	private int password;
	private Date birthday;
	private contact contact;

	public Person() {

	}

	public Person(String name, int password, Date birthday, contact contact) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public contact getContact() {
		return contact;
	}

	public void setContact(contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "id:" + id + "  name:" + name + "  phone:" + contact.getPhone() + "  weixin:" + contact.getWeixin()
				+ "  qq:" + contact.getQQ() + "  birth:" + birthday;
	}

}