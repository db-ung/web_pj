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
import com.project.DTO.UserDTO;

import MainBoard.Command.Board1;
import MainBoard.Command.Board123_1;
import MainBoard.Command.Board123_2;
import MainBoard.Command.Board123_3;
import MainBoard.Command.Board2;
import MainBoard.Command.Board3;
import MainBoard.Command.NewPost;
import MainBoard.Command.mbService;
import MainBoard.DTO.mainBoard_PpDTO;

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
	    response.setContentType("text/html; charset=UTF-8");
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
	        }
	    }
	    mbService mpp = null;
		mbService mpp1 = null;
		mbService mpp2 = null;
		mbService mpp3 = null;
		if (command.equals("/ppb1.do")) {
			mpp = new Board1();
			ArrayList<mainBoard_PpDTO> result = mpp.execute(request, response);
			if (result != null) {
				request.setAttribute("list", result);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Spp1Board.jsp");
                dispatcher.forward(request, response);
			}
		}
		else if (command.equals("/ppb2.do")) {
			mpp = new Board2();
			ArrayList<mainBoard_PpDTO> result = mpp.execute(request, response);
			if (result != null) {
				request.setAttribute("list", result);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Spp2Board.jsp");
                dispatcher.forward(request, response);
			}
		}
		else if (command.equals("/ppb3.do")) {
			mpp = new Board3();
			ArrayList<mainBoard_PpDTO> result = mpp.execute(request, response);
			if (result != null) {
				request.setAttribute("list", result);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Spp3Board.jsp");
                dispatcher.forward(request, response);
			}
		}
		else if(command.equals("/ppb12.do")) {
			mpp1 = new Board123_1();
			mpp2 = new Board123_2();
			ArrayList<mainBoard_PpDTO> result1 = mpp1.execute(request, response);
			ArrayList<mainBoard_PpDTO> result2 = mpp2.execute(request, response);
			if(result1 != null && result2 != null) {
				request.setAttribute("list1", result1);
				request.setAttribute("list2", result2);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Spp12Board.jsp");
                dispatcher.forward(request, response);
			}
		}
		else if(command.equals("/ppb13.do")) {
			mpp1 = new Board123_1();
			mpp3 = new Board123_3();
			ArrayList<mainBoard_PpDTO> result1 = mpp1.execute(request, response);
			ArrayList<mainBoard_PpDTO> result3 = mpp3.execute(request, response);
			if(result1 != null && result3 != null) {
				request.setAttribute("list1", result1);
				request.setAttribute("list3", result3);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Spp13Board.jsp");
                dispatcher.forward(request, response);
			}
		}
		else if(command.equals("/ppb23.do")) {
			mpp2 = new Board123_2();
			mpp3 = new Board123_3();
			ArrayList<mainBoard_PpDTO> result2 = mpp2.execute(request, response);
			ArrayList<mainBoard_PpDTO> result3 = mpp3.execute(request, response);
			if(result2 != null && result3 != null) {
				request.setAttribute("list2", result2);
				request.setAttribute("list3", result3);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Spp23Board.jsp");
                dispatcher.forward(request, response);
			}
		}
		else if(command.equals("/ppb123.do")) {
			mpp1 = new Board123_1();
			mpp2 = new Board123_2();
			mpp3 = new Board123_3();
			ArrayList<mainBoard_PpDTO> result1 = mpp1.execute(request, response);
			ArrayList<mainBoard_PpDTO> result2 = mpp2.execute(request, response);
			ArrayList<mainBoard_PpDTO> result3 = mpp3.execute(request, response);
			if(result1 != null && result3 != null) {
				request.setAttribute("list1", result1);
				request.setAttribute("list2", result2);
				request.setAttribute("list3", result3);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Spp123Board.jsp");
                dispatcher.forward(request, response);
			}
		}
		else if(command.equals("/newPost.do")) {
			mpp1 = new NewPost();
			ArrayList<mainBoard_PpDTO> result = mpp1.execute(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Spp123Board.jsp");
			dispatcher.forward(request, response);
		}

	    uService.execute(request, response);
	}
}