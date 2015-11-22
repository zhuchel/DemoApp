package hui;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.some.hui.domain.Department;
import com.some.hui.hibernate.HibernateUtil;

public class HibernateTest {

	@Test
	public void testF() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Department princess = new Department();
		princess.setId(System.currentTimeMillis());
		princess.setName("Princess");
		session.save(princess);
		tx.commit();
		HibernateUtil.closeSession();
	}

}
