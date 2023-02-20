package mvcmem.control;

import mvcmem.action.IndexAction;
import mvcmem.action.RegFormAction;

public class ActionFactory {
private static ActionFactory factory;
	
	private ActionFactory() {}
	
	public static synchronized ActionFactory getInstance() {

		if (factory == null) {
				factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		
		switch(cmd) {
		case "index":
			action = new IndexAction();
			break;
			
		case "regForm":
			action = new RegFormAction();
			break;
			
			
			default:
				action = new IndexAction();
			break;	
		}
		
		
		
		
		return action;
	}
}
