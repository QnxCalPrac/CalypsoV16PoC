package tk.bo.workflow.rule;

import java.util.Vector;

import com.calypso.tk.bo.Task;
import com.calypso.tk.bo.TaskWorkflowConfig;
import com.calypso.tk.bo.workflow.WfTradeRule;
import com.calypso.tk.core.Log;
import com.calypso.tk.core.Trade;
import com.calypso.tk.service.DSConnection;

public class CheckCustomSwapTradeRule implements WfTradeRule{
	private static final String LOG= CheckcustomTradeRule.class.getSimpleName();
	private static final String MESSAGE= "Notional less than 5 millions";
	private static final double Nominal=5000000.0;
	

	
	@Override
	public boolean check(TaskWorkflowConfig wc, Trade trade, Trade oldTrade, Vector messages, DSConnection dsCon,
			Vector excps, Task task, Object dbCon, Vector events) 
	{
		Log.system(LOG,"This is check method()");
		if(trade.getProduct().getPrincipal()<Nominal)
		{
			messages.add(MESSAGE);
			System.out.println("5M check");
			return true ;
			
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TaskWorkflowConfig wc, Trade trade, Trade oldTrade, Vector messages, DSConnection dsCon,
			Vector excps, Task task, Object dbCon, Vector events) 
	{
		// TODO Auto-generated method stub
		Log.system(LOG,"This is update method");
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		Log.system(LOG,"This is custom workflow rule and Description method()");
		return "This rule is for SWAP trades Please enter amount grater than 5M";
		
	}

}
