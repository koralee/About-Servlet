package mvc.control;

import mvc.action.Action;
import mvc.action.IndexAction;

// XXXAction 의 비즈니스 로직 수행 후 ControlServlet에게 반환하는 객체
// (이동할 url과 이동방법을 저장하는 클래스

public class ActionFactory {

	private static ActionFactory factory;
	
	private ActionFactory() { }
	
	public static synchronized ActionFactory getInstance() {
		
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action getAction(String cmd) {
		
		Action action = null;
		
		if(cmd.equals("index")) {
			action = new IndexAction();
		}
		
		
		
		
		
		
		return action;
	}
	
	
	
}
