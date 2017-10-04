package aop.service;

public class ServiceImpl implements Service {
	public void add() {
		System.err.print("add");
	}

	public void update() {
		System.err.print("udpate");
	}

	public void delete() {
		System.err.print("delete");
	}
}
