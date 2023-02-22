package mvcmem.control;

import mvcmem.action.DeleteFormAction;
import mvcmem.action.DeleteProcessAction;
import mvcmem.action.IdCheckAction;
import mvcmem.action.IndexAction;
import mvcmem.action.LoginFormAction;
import mvcmem.action.LoginProcessAction;
import mvcmem.action.LogoutAction;
import mvcmem.action.ModifyFormAction;
import mvcmem.action.ModifyProcessAction;
import mvcmem.action.RegFormAction;
import mvcmem.action.RegProcessAction;
import mvcmem.action.ZipCheckAction;

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
			
		case "idCheck":
			action = new IdCheckAction();
			break;
			
		case "regProcess":
			action = new RegProcessAction();
			break;
			
		case "zipCheck":
			action = new ZipCheckAction();
			break;
			
		case "login":
			action = new LoginFormAction();
			break;
			
		case "loginProcess":
			action = new LoginProcessAction();
			break;
			
		case "logout":
			action = new LogoutAction();
			break;
			
		case "modifyForm":
			action = new ModifyFormAction();
			break;
			
		case "modifyProcess":
			action = new ModifyProcessAction();
			break;
			
		case "deleteForm":
			action = new DeleteFormAction();
			break;
			
		case "deleteProcess":
			action = new DeleteProcessAction();
			break;
			
			
			default:
				action = new IndexAction();
			break;	
		}
		
		
		
		
		return action;
	}
}
