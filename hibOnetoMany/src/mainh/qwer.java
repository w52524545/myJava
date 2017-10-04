package mainh;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import Customer.Customer;
import LinkMan.LinkMan;

public class qwer {
	static qwer mt = new qwer();

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		LinkMan li = new LinkMan();
		li.setLgender("qwe");
		li.setLname("ef");
		li.setLphone("123124");
		
		Set<LinkMan> linkMans = new HashSet<LinkMan>();
		Customer cu = new Customer();
		cu.setCustLevel("22");
		cu.setCustMobile("23311");
		cu.setCustName("dsff");
		cu.setCustPhone("2134444");
		cu.setCustSource("sdfsa");
		li.setCustomer(cu);
		linkMans.add(li);
		cu.setLinkMans(linkMans);
		session.save(li);
		session.save(cu);

		tx.commit();
		session.close();
		sessionFactory.close();// 一定 不 要 关闭.这里只是写出来做例子
	}

}
