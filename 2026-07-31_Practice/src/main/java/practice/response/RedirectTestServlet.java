package practice.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RedirectTestServlet
 */
@WebServlet("/redirectTest")
public class RedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO: 요청을 받아 새로운 URL(/practice/result)로 이동하도록 처리하십시오.
		
		// * /practice/result 로 재요청
		//			클라이언트 -- 최초 요청 --> 			서버
		//				    <-- 재요청 지시 --
		//					-- 전달받은 주소로 요청 -->
		//response.sendRedirect("/practice/result");
		response.sendRedirect( request.getContextPath() + "/result" );
//		response.sendRedirect("result");
		
	    // [응답 출력 형식] <h2>Redirect 이동 성공</h2> ==> ResultServlet 에서 처리
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
