package calypsox.tk.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.calypso.tk.core.Log;
import com.calypso.tk.event.PSConnection;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ScheduledTask;

//either the name should be in ScheduledTask<Name> or the package should be till ScheduledTask and only the custom name should be there

public class ScheduledTaskSAMPLE extends ScheduledTask  {
	public static final String LOG_CATEGORY = ScheduledTaskSAMPLE.class.getSimpleName();//logging
	@Override
	public String getTaskInformation() {
		// TODO Auto-generated method stub
		return "Custom Schedule Task";
	} 
	@Override
	protected boolean process(DSConnection ds, PSConnection ps) {
		// This is the main method for calypso you have to call methods in this segment to make it run
		Log.system(LOG_CATEGORY,"Inside Proccess metod starts");
	
		return true;
	}
	@Override
	public boolean sendMail(DSConnection ds, PSConnection ps) {
		// TODO Auto-generated method stub
		Log.system(LOG_CATEGORY,"Inside send-mail metod starts");
		return super.sendMail(ds, ps);
	}	
	@Override 
	protected List<AttributeDefinition> buildAttributeDefinition()
	{     List<AttributeDefinition> attributeList =  new ArrayList<AttributeDefinition>();   
	Log.system(LOG_CATEGORY,"Inside BuildAttributeDefination metod starts");
	attributeList.add(attribute("Test String"));  
	attributeList.add(attribute("Test Domain").domainName("productType"));
	attributeList.add(attribute("Test Boolean").booleanType());  
	attributeList.add(attribute("Test Int").integer());   
	DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
	attributeList.add(attribute("Test Date").dateFormat(dateFormat));   
	attributeList.add(attribute("Test trial"));
	Log.system(LOG_CATEGORY,"Inside Proccess metod ends");
	return attributeList; 
	}
	
}
