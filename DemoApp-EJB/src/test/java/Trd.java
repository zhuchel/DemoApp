import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.validation.AbstractRestValidator;
import com.validation.ViolationMessages;
import com.validation.bom.OMLeg;
import com.validation.bom.OMLegDay;
import com.validation.marker.ILegTimeMarker;



public class Trd {
	
	@Test
	public void test() throws InterruptedException {
		
		OMLeg leg = new OMLeg();
		leg.setName("name");
		leg.setDt(new Date());
		Thread.sleep(100);
		
		OMLegDay legday = new OMLegDay();
		legday.setName("name");
		legday.setDt("hui");
		
		leg.setDay(legday);
		
		AbstractRestValidator validator = new AbstractRestValidator();
		ViolationMessages mes = validator.validate(leg, ILegTimeMarker.class);
		assertNull(mes);
		
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
