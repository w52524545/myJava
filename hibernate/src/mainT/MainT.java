package mainT;

import java.sql.DriverManager;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import contact.contact;
import person.Person;

public class MainT {
	static MainT mt = new MainT();

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(mt.add());

		// String hql = "FROM Person p,contact c WHERE p.id=c.id";
		// Query query = session.createQuery(hql);
		// List list =query.list();
		// System.out.println(list);

		// String hql = "FROM Person p JOIN fetch p.contact c";
		// Query query = session.createQuery(hql);
		// List<Person> list = query.list();
		// for(Person p:list) {
		// System.out.println(p);
		// }

		// String hql = "FROM Person As person WHERE person.password=123";
		// List<Person> list = session.createQuery(hql).list();
		// for(Person l:list) {
		// System.out.println(l);
		// }
		
		
		tx.commit();
		session.close();
		sessionFactory.close();// 一定 不 要 关闭.这里只是写出来做例子
	}

	private Person add() {
		contact c = null;
		Person p = new Person("weasfssqw", 2222122, new Date(), c);
		return p;
	}
}
