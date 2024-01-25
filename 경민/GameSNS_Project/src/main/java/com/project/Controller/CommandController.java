package com.project.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Command.UserService;
import com.project.Command.UserServiceDelete;
import com.project.Command.UserServiceFindID;

import com.project.Command.UserServiceFindPW;
import com.project.Command.UserServiceInsert;
import com.project.Command.UserServiceLogin;
import com.project.Command.UserServiceLogout;
import com.project.Command.UserServiceUpdate;
import com.project.DTO.UserDTO;
import com.project.PostCommand.PostService;
import com.project.PostCommand.PostServiceInsert;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    String uri = request.getRequestURI();
	    String conPath = request.getContextPath();
	    String command = uri.substring(conPath.length());

	    // View(jsp), Controller(프론트컨트롤러, 커멘드)
	    UserService uService = null;

	    HttpSession session = request.getSession(false);
	    boolean isLoggedIn = (session != null && session.getAttribute("nickname") != null);

	    if (isLoggedIn) {
	        // 로그인 상태인 경우
	        if (command.equals("/delete.do")) {
	            System.out.println("<회원 탈퇴>를 수행합니다.");
	            uService = new UserServiceDelete();
	        } else if (command.equals("/logout.do")) {
	            System.out.println("<로그아웃>을 수행합니다.");
	            uService = new UserServiceLogout();
	        } else if (command.equals("/update.do")) {
	            System.out.println("<회원 정보 수정>을 수행합니다.");
	            uService = new UserServiceUpdate();
	        } else {
	            // 로그인 상태에서 불필요한 명령이 들어올 경우 예외 처리 또는 다른 처리를 수행할 수 있습니다.
	            response.sendRedirect("main.html");
	            return;
	        }	        
	    } else {
	        // 비로그인 상태인 경우
	        if (command.equals("/login.do")) {
	            System.out.println("<로그인>을 수행합니다.");
	            uService = new UserServiceLogin();
	        } else if (command.equals("/insert.do")) {
	            System.out.println("<회원 가입>을 수행합니다.");
	            uService = new UserServiceInsert();
	        } else if (command.equals("/findId.do")) {
	            System.out.println("<아이디 찾기>를 수행합니다.");
	            uService = new UserServiceFindID();
	        } else if (command.equals("/findPw.do")) {
	            System.out.println("<비밀번호 찾기>를 수행합니다.");
	            uService = new UserServiceFindPW();
	        } else {
	            // 비로그인 상태에서 불필요한 명령이 들어올 경우 예외 처리 또는 다른 처리를 수행할 수 있습니다.
	            response.sendRedirect("login.html");
	            return;
	        }
	    }

	    uService.execute(request, response);
	}
}