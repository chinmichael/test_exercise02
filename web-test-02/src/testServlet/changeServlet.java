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

/**
 * Servlet implementation class changeServlet
 */
@WebServlet("/change.do")
public class changeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public changeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		MemberVO mv = new MemberVO();
		mv.setId(request.getParameter("id"));
		mv.setPw(request.getParameter("pw"));
		mv.setName(request.getParameter("name"));
		mv.setLevel(request.getParameter("level"));
		mv.setGender(request.getParameter("gender"));
		mv.setPhone(request.getParameter("phone"));
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.updateMember(mv);
		
		HttpSession session = request.getSession();
		if(result == 1) {
			session.setAttribute("loginUser", mv);
			request.setAttribute("message", "회원 정보가 수정되었습니다");
		} else {
			request.setAttribute("message", "회원 정보 수정에 실패했습니다");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberInfo.jsp");
		dispatcher.forward(request, response);
		
	}

}
