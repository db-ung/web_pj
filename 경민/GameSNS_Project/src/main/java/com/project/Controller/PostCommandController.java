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
import com.project.DTO.PostDTO;
import com.project.PostCommand.PostService;
import com.project.PostCommand.PostServiceInsert;
import com.project.PostCommand.ViewPost;

/**
 * Servlet implementation class PostCommandController
 */
@WebServlet("*.doPosting")
public class PostCommandController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostCommandController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPostingAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPostingAction(request, response);
	}

	protected void doPostingAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		// View(jsp), Controller(프론트컨트롤러, 커멘드)
		PostService pService = null;

		HttpSession session = request.getSession(false);

		if (command.equals("/insert.doPosting")) {
			System.out.println("<게시물 작성>(을)를 수행합니다.");
			pService = new PostServiceInsert();
		}
		else if (command.equals("/viewPL.doPosting")) {
			System.out.println("<게시물 보기>(을)를 수행합니다.");
			pService = new ViewPost();
			ArrayList<PostDTO> result = pService.execute(request, response);
			if (result != null) {
				request.setAttribute("boardList", result);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPost.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
