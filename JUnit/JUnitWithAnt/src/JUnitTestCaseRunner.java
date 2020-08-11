package JUnit;

import static org.junit.Assert.*;
import java.util.Map;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.refdata.LegalEntityAttribute;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ConnectionUtil;


// Test case runner - only

public class JUnitTestCaseRunner {
	public static DSConnection dsCon = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executing @BeforeClass method");
		dsCon = ConnectionUtil.connect("calypso_user", "calypso", "JUnitTester", "DEV16");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executing @AfterClass method");
		DSConnection.logout();
		ConnectionUtil.disconnect();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Executing @Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Executing @After method");
	}

	@Test
	public void checkLE_AssertEquals_NotNull() throws CalypsoServiceException {
		System.out.println("Executing @Test method");
		LegalEntity le1 = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE");
		System.out.println(le1+le1.getName());
		if (le1.getName().equalsIgnoreCase("JUNITTEST_LE"))
			System.out.println("Legal Entity Found");
		else
			System.out.println("Legal Entity does not exist");
		assertEquals(true,le1.getName().equalsIgnoreCase("JUNITTEST_LE"));
		assertNotNull(le1);
	}

	@Test
	public void checkLE_AssertFalse_True() throws CalypsoServiceException {
		System.out.println("Executing @Test method");
		LegalEntity le1 = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE");
		System.out.println(le1+le1.getName());
		if (le1.getName().equalsIgnoreCase("JUNITTEST_LE"))
			System.out.println("Legal Entity Found");
		else
			System.out.println("Legal Entity does not exist");
		assertFalse(false!=le1.getName().equalsIgnoreCase("JUNITTEST_LE1111"));
		assertTrue(true==le1.getName().equalsIgnoreCase("JUNITTEST_LE"));
	}

	@Test
	public void checkLEA_AssertEquals_NotNull() throws CalypsoServiceException {
		System.out.println("Executing @Test method");
		Vector <Integer> v = new Vector<>();
		int leId = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE").getEntityId();
		System.out.println(leId);
		v.add(leId);
		Map<Integer, Map<LegalEntityAttribute, LegalEntityAttribute>> lea = dsCon.getRemoteReferenceData().getLegalEntityAttributesUsingIds(v);
		System.out.println(lea);
		if (lea.toString().contains("TEST1")&&lea.toString().contains("TEST2")&&lea.toString().contains("TEST3"))
			System.out.println("Legal Entity Attributes --->"+lea.toString()+"Found");
		else
			System.out.println("Legal Entity Attribute does not exist");
		assertEquals(true,lea.toString().contains("TEST1"));
		assertEquals(true,lea.toString().contains("TEST2"));
		assertEquals(true,lea.toString().contains("TEST3"));
		assertNotNull(leId);
	}

	@Test
	public void checkLEA_AssertFalse_True() throws CalypsoServiceException {
		System.out.println("Executing @Test method");
		Vector <Integer> v = new Vector<>();
		int leId = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE").getEntityId();
		System.out.println(leId);
		v.add(leId);
		Map<Integer, Map<LegalEntityAttribute, LegalEntityAttribute>> lea = dsCon.getRemoteReferenceData().getLegalEntityAttributesUsingIds(v);
		System.out.println(lea);
		assertFalse(false!=lea.toString().contains("TEST4"));
		assertFalse(false!=lea.toString().contains("TEST5"));
		assertFalse(false!=lea.toString().contains("TEST6"));
		assertTrue(true==lea.toString().contains("TEST1"));
		assertTrue(true==lea.toString().contains("TEST2"));
		assertTrue(true==lea.toString().contains("TEST3"));
	}
}


