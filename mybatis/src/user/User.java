package user;

public class User {
	// 属性名称与数据库名称一致
	private String uid;
	private String name;
	private String gender;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", gender=" + gender
				+ "]";
	}

}