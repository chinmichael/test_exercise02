package testServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbpackage.MemberDAO;
import dbpackage.MemberVO;

@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		String level = request.getParameter("level");
		if(level.equals("일반")) {
			level = "B";
		} else {
			level = "A";
		}
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.memberLogin(id, pw, level);
		
		HttpSession session = request.getSession();
		
		if(result == 1) {
			MemberVO mv = dao.getInfo(id, pw, level);
			session.setAttribute("loginUser", mv);
		} 
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

}
