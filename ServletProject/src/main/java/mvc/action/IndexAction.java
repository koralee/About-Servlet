package mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.control.ActionForward;

// Action인터페이스를 재정의하고 있는 클래스
// 실질적인 비즈니스 로직을 구현하는 클래스
public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
			System.out.println("IndexAction의 execute() 수행됨!!!");	
		return new ActionForward("index.jsp", false);
	}

}
