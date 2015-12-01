package huii;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.some.hui.domain.Department;





public class Trd {
	
	@Test
	public void test() throws InterruptedException {
		
		List<Department> deps = new ArrayList<Department>();
		//Department dep = null;
		int i=0;
		for(i =0; i<10; i++) {
			final Department dep = new Department();
			dep.setId(Long.valueOf(i));
			dep.setName("hui" + i);
			deps.add(dep);
		}
	
		assert(deps != null);
		
		
//		OMLeg leg = new OMLeg();
//		leg.setName("name");
//		leg.setDt(new Date());
//		Thread.sleep(100);
//		
//		OMLegDay legday = new OMLegDay();
//		legday.setName("name");
//		legday.setDt("hui");
//		
//		leg.setDay(legday);
//		
//		AbstractRestValidator validator = new AbstractRestValidator();
//		ViolationMessages mes = validator.validate(leg, ILegTimeMarker.class);
//		assertNull(mes);
		
	}
	
//	@Test
//	public void testDate() throws InterruptedException {
//		
//		OMLeg leg = new OMLeg();
//		leg.setName("name");
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_MONTH, 10);
//		leg.setDt(cal.getTime());
//		Thread.sleep(100);
//		AbstractRestValidator validator = new AbstractRestValidator();
//		ViolationMessages mes = validator.validate(leg);
//		assertNotNull(mes);
//		
//	}
//	
//	@Test
//	public void testKo() {
//		
//		OMLeg leg = new OMLeg();
//		AbstractRestValidator validator = new AbstractRestValidator();
//		ViolationMessages mes = validator.validate(leg);
//		assertNotNull(mes);
//		assertTrue(mes.getViolationMessage().size() ==1);
//		
//	}
//	
//	@Test
//	public void testDateMonday() throws InterruptedException {
//		
//		OMLegDay leg = new OMLegDay();
//		leg.setName("name");
//		leg.setDt(new Date());
//		Thread.sleep(100);
//		AbstractRestValidator validator = new AbstractRestValidator();
//		ViolationMessages mes = validator.validate(leg);
//		assertNull(mes);
//		
//	}

}
