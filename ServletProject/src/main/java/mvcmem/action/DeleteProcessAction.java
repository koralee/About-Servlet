package mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcmem.control.Action;
import mvcmem.control.ActionForward;
import mvcmem.model.StudentDAO;

public class DeleteProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//DB연결
		request.setCharacterEncoding("UTF-8");
		StudentDAO dao = StudentDAO.getInstance();

		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("loginID");
		String pass = request.getParameter("pass");
		
		int result = dao.deleteMember(loginID, pass);
		
		if(result != 0) {
			session.invalidate();
		}
		
		request.setAttribute("result", result);
		
		return new ActionForward("/mvcmem/deleteProcess.jsp",false);
	}

}
