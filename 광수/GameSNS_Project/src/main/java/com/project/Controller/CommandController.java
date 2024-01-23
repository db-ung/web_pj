package com.project.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Command.UserService;
import com.project.Command.UserServiceDelete;
import com.project.Command.UserServiceInsert;
import com.project.Command.UserServiceLogin;
import com.project.Command.postService;
import com.project.Command.postServiceSearch;
import com.project.DTO.PostDTO;
import com.project.DTO.UserDTO;

/**
 * Servlet implementation class CommandController
 */
@WebServlet("*.do")
public class CommandController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		// 사용자가 불러온 링크를 반환 (ex) /JSP_0117/insert.do
		String conPath = request.getContextPath(); // 프로젝트명 반환
		String command = uri.substring(conPath.length());
		// insert.do, delete.do ... 형식으로 command에 저장

		// View(jsp), Controller(프론트컨트롤러, 커멘드)
		UserService uService = null; // 객체 생성X, 타입 구성만 한 것
		postService pService = null;
		
		ArrayList<PostDTO> post = null;
		ArrayList<UserDTO> user = null;

		if (command.equals("/insert.do")) {
			// "회원 추가" 수행을 요청할 시
			System.out.println("<회원 가입>을 수행합니다.");
			uService = new UserServiceInsert();
		} else if (command.equals("/delete.do")) {
			System.out.println("<회원 탈퇴>를 수행합니다.");
			uService = new UserServiceDelete();
		} else if (command.equals("/login.do")) {
			System.out.println("<로그인>을 수행합니다.");
			uService = new UserServiceLogin();
		} else if (command.equals("/search.do")) {
			System.out.println("<게시판 검색>을 수행합니다.");
			pService = new postServiceSearch();
			System.out.println("<게시판 검색>완료");
		}

		

		if (uService != null) {
			user = uService.execute(request, response);
			System.out.println("uService 오류");
		} else if (pService != null) {
			post = pService.execute(request, response);
			System.out.println("pService 오류");
		}

		 // Forward 부분
	    if (post != null) {
	        request.setAttribute("postList", post);
	        // post 데이터를 request에 attribute로 추가
	        System.out.println("postlist 실행 ");
	        RequestDispatcher dis = request.getRequestDispatcher("/getList.jsp");
	        dis.forward(request, response);
	    }

	}

}