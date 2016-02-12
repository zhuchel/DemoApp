package hui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.some.hui.domain.Department;

public class jpaTest {

	private static EntityManagerFactory emf;
	private static EntityManager em = null;

	@BeforeClass
	public static void setUp() {
		emf = Persistence.createEntityManagerFactory("codis_base");
		em = emf.createEntityManager();

	}

	//@Test
	public void testF() {
		em.getTransaction().begin();
		Department dep = new Department();
		dep.setId(1L);
		dep.setName("hui");
		em.persist(dep);
		em.flush();
		Department found = em.find(Department.class, 1L);
		assert (found != null);
		em.getTransaction().rollback();
	}

}
