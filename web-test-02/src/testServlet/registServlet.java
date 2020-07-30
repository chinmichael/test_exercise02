package testServlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbpackage.MemberDAO;
import dbpackage.MemberVO;

@WebServlet("/regist.do")
public class registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public registServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberVO mv = new MemberVO();
		mv.setId(request.getParameter("id"));
		mv.setPw(request.getParameter("pw"));
		mv.setName(request.getParameter("name"));
		mv.setLevel(request.getParameter("level"));
		mv.setGender(request.getParameter("gender"));
		mv.setPhone(request.getParameter("phone"));
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.insertMember(mv);
		
		if(result == 1) {
			request.setAttribute("registUser", mv);
			request.setAttribute("message", "회원 등록이 성공했습니다");
		} else if(result == 0) {
			request.setAttribute("message", "회원 등록에 실패했습니다");
		} else {
			request.setAttribute("message", "fail");
		}
		
		if(result != -1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/regInfo.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/registmember.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
