package JUnit;

import java.util.Map;
import java.util.Vector;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.refdata.LegalEntityAttribute;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ConnectionUtil;

// TODO : added comments for runner

public class JUnitRunner {
	public static DSConnection dsCon = null;

	
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executing @BeforeClass method");
		dsCon = ConnectionUtil.connect("calypso_user", "calypso", "JUnitTestCaseRunner", "DEV16");

		Vector<String> roles = new Vector<>();
		roles.add("CounterParty");
		roles.add("Broker");

		LegalEntity le1 = new LegalEntity();
		le1.setCode("JUNIT_LE_ANTBUILDERNEW");
		le1.setCountry("TEST");
		le1.setName("JUNITTEST_LE_ANTBUILDERNEW");
		le1.setRoleList(roles);
		le1.setStatus("Enabled");
		le1.setClassification(true);
		int le1ID = dsCon.getRemoteReferenceData().save(le1);		

		System.out.println(le1+"-----------"+le1ID);
	}

	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executing @AfterClass method");
		DSConnection.logout();
		ConnectionUtil.disconnect();
	}

	public static void setUp() throws Exception {
		System.out.println("Executing @Before method");
	}

	public static void tearDown() throws Exception {
		System.out.println("Executing @After method");
	}

	public static LegalEntity checkLE_AssertEquals_NotNull() throws CalypsoServiceException {
		System.out.println("Executing @Test method");
		LegalEntity le1 = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE");
		System.out.println(le1+le1.getName());
		if (le1.getName().equalsIgnoreCase("JUNITTEST_LE"))
			System.out.println("Legal Entity Found");
		else
			System.out.println("Legal Entity does not exist");
		return le1;
	}

	public static LegalEntity checkLE_AssertFalse_True() throws CalypsoServiceException {
		System.out.println("Executing @Test method");
		LegalEntity le1 = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE");
		System.out.println(le1+le1.getName());
		if (le1.getName().equalsIgnoreCase("JUNITTEST_LE"))
			System.out.println("Legal Entity Found");
		else
			System.out.println("Legal Entity does not exist");
		return le1;
	}

	public static Map<Integer, Map<LegalEntityAttribute, LegalEntityAttribute>> checkLEA_AssertEquals_NotNull() throws CalypsoServiceException {
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
        return lea;
	}

	public static Map<Integer, Map<LegalEntityAttribute, LegalEntityAttribute>> checkLEA_AssertFalse_True() throws CalypsoServiceException {
		System.out.println("Executing @Test method");
		Vector <Integer> v = new Vector<>();
		int leId = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE").getEntityId();
		System.out.println(leId);
		v.add(leId);
		Map<Integer, Map<LegalEntityAttribute, LegalEntityAttribute>> lea = dsCon.getRemoteReferenceData().getLegalEntityAttributesUsingIds(v);
		System.out.println(lea);
		return lea;
	}
	
}


