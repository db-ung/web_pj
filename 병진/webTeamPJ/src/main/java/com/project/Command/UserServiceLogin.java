package com.project.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.UserDAO;
import com.project.DTO.UserDTO;

public class UserServiceLogin implements UserService{
	public ArrayList<UserDTO> execute(HttpServletRequest request, HttpServletResponse response){
		ArrayList<UserDTO> dto = null;
		
		// DAO 에 있는 insert 메소드 수행
		UserDAO dao = new UserDAO();
		String id = request.getParameter("checkid");
		String pw = request.getParameter("checkpw");
		
		dao.UserLogin(id, pw, request, response);
		
		return dto;
	}
}
