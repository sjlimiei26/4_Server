package practice.session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO: 세션 객체에서 저장된 닉네임과 연락처를 추출하여 출력 하세요.
		// * 세션 객체에서 데이터 추출 ==> 요청 객체
		HttpSession session = request.getSession();
		
		String nickname = (String)session.getAttribute("nickname");
		String tel = (String)session.getAttribute("tel");		
		
	    // [응답 출력 형식] <h2>마이페이지 - 닉네임: [닉네임], 연락처: [연락처]</h2>
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().printf("<h2>마이페이지 - 닉네임: %s, 연락처: %s</h2>\n"
														, nickname, tel);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
