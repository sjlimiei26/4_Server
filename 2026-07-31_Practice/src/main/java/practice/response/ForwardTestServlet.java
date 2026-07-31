package practice.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ForwardTestServlet
 */
@WebServlet("/forwardTest")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		TODO: 요청 객체에 임의의 데이터를 저장(setAttribute)한 후 
						서버 내부에서 이동 처리하세요.
		 */
		// * 요청 객체에 임의의 데이터를 저장 (key, value)
		request.setAttribute("sample", "##포워드 할 데이터##");
		
		// * forward => 다른 자원(html, jsp)으로 응답 처리
		//  [응답 출력 형식] <h2>Forward 이동 성공: [저장한 데이터]</h2>
		request.getRequestDispatcher("/forwardResult.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
