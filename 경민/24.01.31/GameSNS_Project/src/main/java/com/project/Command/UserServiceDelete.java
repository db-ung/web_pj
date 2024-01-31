package com.project.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.UserDAO;
import com.project.DTO.UserDTO;

public class UserServiceDelete implements UserService{
	public ArrayList<UserDTO> execute(HttpServletRequest request, HttpServletResponse response){
		ArrayList<UserDTO> dto = null;
		
		// DAO 에 있는 insert 메소드 수행
		UserDAO dao = new UserDAO();
		String pw = request.getParameter("deletepw");
		
		dao.UserDelete(pw , request, response);
		
		return dto;
	}
}
