package JUnit;
import java.util.Collection;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.refdata.LegalEntityAttribute;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ConnectionUtil;

public class JUnitTester {
	public static DSConnection dsCon = null;
	public static void main(String[] args) {
		try{
			dsCon = ConnectionUtil.connect("calypso_user", "calypso", "JUnitTester", "DEV16");
			//saveLE();
			checkLE();
			checkLEA();
			System.out.println("success");
		}catch(Exception e){			
			e.printStackTrace();			
		}
		finally
		{
			DSConnection.logout();
			ConnectionUtil.disconnect();
		}

	}

	public static void checkLE() throws Exception
	{
		LegalEntity le1 = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE");
		System.out.println(le1+le1.getName());
		if (le1.getName().equalsIgnoreCase("JUNITTEST_LE"))
			System.out.println("Legal Entity Found");
		else
			System.out.println("Legal Entity does not exist");
	}

	public static void checkLEA() throws Exception
	{
		LegalEntity le = dsCon.getRemoteReferenceData().getLegalEntity("JUNIT_LE");
		System.out.println(le+le.getName());
		Collection leattrs = le.getLegalEntityAttributes();
		System.out.println(leattrs);
			if (leattrs.toString().contains("TEST1")&&leattrs.toString().contains("TEST2")&&leattrs.toString().contains("TEST3"))
				System.out.println("Legal Entity Attributes --->"+leattrs.toString()+"Found");
			else
				System.out.println("Legal Entity Attribute does not exist");
	}

	/*	public static void saveLE()throws Exception{

		Vector<String> roles = new Vector<>();
		roles.add("CounterParty");
		roles.add("Broker");

		LegalEntity le1 = new LegalEntity();
		le1.setCode("JUNIT_LE");
		le1.setCountry("TEST");
		le1.setName("JUNITTEST_LE");
		le1.setRoleList(roles);
		le1.setStatus("Enabled");
		le1.setClassification(true);
		int le1ID = dsCon.getRemoteReferenceData().save(le1);		


		//Saving Attributes for JUNITTEST_LE
		saveLEA(le1ID, "TEST1", "TEST1");
		saveLEA(le1ID, "TEST2", "TEST2");
		saveLEA(le1ID, "TEST3", "TEST3");

		System.out.println(le1);
	}


	public static void saveLEA(int leid, String attributeType, String attributeValue)throws Exception{
		LegalEntityAttribute leA = new LegalEntityAttribute();
		leA.setLegalEntityId(leid);
		leA.setProcessingOrgId(leid);
		leA.setLegalEntityRole("ALL");
		leA.setAttributeType(attributeType);
		leA.setAttributeValue(attributeValue);
		int leAID = dsCon.getRemoteReferenceData().save(leA);
		System.out.println(leAID + "Saved ---> " + attributeType + " : " + attributeValue );
	}*/



}
