package mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcmem.control.Action;
import mvcmem.control.ActionForward;
import mvcmem.model.*;

public class ModifyProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//DB연결
				request.setCharacterEncoding("UTF-8");
				StudentDAO dao = StudentDAO.getInstance();
				HttpSession session = request.getSession();		
				
				String loginID =(String)session.getAttribute("loginID");
				StudentVO vo = new StudentVO(loginID,
						request.getParameter("pass"),
						request.getParameter("name"),
						request.getParameter("phone1"),
						request.getParameter("phone2"),
						request.getParameter("phone3"),
						request.getParameter("email"),
						request.getParameter("zipcode"),
						request.getParameter("address1"),
						request.getParameter("address2"));
				
				dao.updateMember(vo);
				
				
		return new ActionForward("/mvcmem/modifyProcess.jsp", false);
	}

}
