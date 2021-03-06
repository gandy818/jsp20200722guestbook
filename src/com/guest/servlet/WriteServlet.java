package com.guest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guest.model.Message;
import com.guest.service.WriteMessageService;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Message message = new Message();
		
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String pw = request.getParameter("password");
		String body = request.getParameter("message");
		
		if(name == null || body == null 
				|| name.isEmpty() || body.isEmpty()) {
			session.setAttribute("info","이름, 메세지를 정확하게 입력해주세요");
		}else {
		
		
		message.setGuestName(name);
		message.setPassword(pw);
		message.setMessage(body);
		
		
		
		
		WriteMessageService service = WriteMessageService.getInstace();
		
		boolean success = service.write(message);
		
		
		
		if(success) {
			session.setAttribute("info", "메세지 등록");
		}else{
			session.setAttribute("info", "메세지 등록실패");
		}
		
		}
		response.sendRedirect("main");
	}

}
