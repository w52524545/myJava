package di;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boss2")
public class Boss {

	@Resource
	public Employee employee; // 依赖

	public void _do() {
		employee.job();
	}
/*
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/
}
