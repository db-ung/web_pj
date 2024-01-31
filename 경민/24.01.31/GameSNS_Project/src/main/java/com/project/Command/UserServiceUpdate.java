// UserServiceUpdate.java

package com.project.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.UserDAO;
import com.project.DTO.UserDTO;

public class UserServiceUpdate implements UserService {
    public ArrayList<UserDTO> execute(HttpServletRequest request, HttpServletResponse response) {
    	ArrayList<UserDTO> dtoList = null;
        HttpSession session = request.getSession();
        
        String id = (String) session.getAttribute("id");
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");
        String pw = request.getParameter("pw");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String email = request.getParameter("frontM") + request.getParameter("LastM");
        String birth = request.getParameter("year")+request.getParameter("month")+request.getParameter("day");

        UserDAO dao = new UserDAO();
        dao.UserUpdate(id, name, nickname, pw, tel, address, email, birth, request, response);
        
        session.setAttribute("id", id);
        session.setAttribute("nickname", nickname);
        session.setAttribute("name", name);
        session.setAttribute("pw", pw);
        session.setAttribute("tel", tel);
        session.setAttribute("address", address);
        session.setAttribute("email", email);
        session.setAttribute("birth", birth);
        
        return dtoList;
    }
}
