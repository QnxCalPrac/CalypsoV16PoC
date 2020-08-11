package calypsox.tk.util;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

// CALV16-12

//import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.Trade;
import com.calypso.tk.event.ESStarter;
import com.calypso.tk.mo.TradeFilter;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ScheduledTask;
import com.calypso.tk.util.TradeArray;

public class ScheduledTaskTEST extends ScheduledTask
{
		private static final long serialVersionUID = 1L;
		TradeFilter tf = null;	
		public static ESStarter es =new ESStarter();
		//es.startconnection();
		public static ScheduledTaskTEST scr = new ScheduledTaskTEST();
		public boolean process(DSConnection ds,com.calypso.tk.event.PSConnection ps)
		{
			String tradeId = getAttribute("tradeId");
			String path = getAttribute("FilePath");
			int tradeIdInt = Integer.valueOf(tradeId);
			Trade trade;
			TradeArray tray = new TradeArray();
			try 
			{
				trade = ds.getRemoteTrade().getTrade(tradeIdInt);				
				File file = new File (path);
				file.createNewFile();
				FileWriter writer = new FileWriter(file);

				//int tradeid = trade.getId(); // another comment

				String cpty = trade.getCounterParty().getName();
				String book = trade.getBook().getName();
				writer.write(cpty +" \n "+ book);
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.toString();
			}
			
			// Place holder for logging
			// LOG.info("");

			/*
			scr.setType("REPORT");
			System.out.println("scr.setType---->");
			scr.setExternalReference("Sourav");
			scr.setTime(2);
			scr.setAttribute("REPROT TYPE", "Settlement");
			scr.setAttribute("REPROT FILE NAME", "Souravblabla");*/
			scr.saveAndPublishDefaultTask(ds,"processErrorMsg","Random String");
			//scr.saveAndPublishDefaultTask(ds, processErrorMsg, exceptionType)
			System.out.println("Done");
			return true;
		}
		
		@Override
		protected List<AttributeDefinition> buildAttributeDefinition()
		{
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  // something as comment

		List<AttributeDefinition> attributeList = new ArrayList<AttributeDefinition>();
		//attributeList.add(attribute("Test String"));
		attributeList.add(attribute("tradeId"));
		attributeList.add(attribute("FilePath"));
		/*attributeList.add(attribute("Test Boolean").booleanType());
		attributeList.add(attribute("Test Int").integer());
		attributeList.add(attribute("Test Date").dateFormat(dateFormat));*/
		return attributeList;
		}
				
		@Override
		public String getTaskInformation() {
			// TODO Auto-generated method stub
			return "This task is used to report keywords for a trade.";
		}
}
