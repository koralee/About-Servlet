package mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.control.ActionForward;

// 모든 XXXAction 클래스가 implements할 인터페이스,
// 비즈니스 로직을 재정의할 메소드를 선언한 인터페이스
public interface Action {
    public ActionForward execute(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException;
    
}
