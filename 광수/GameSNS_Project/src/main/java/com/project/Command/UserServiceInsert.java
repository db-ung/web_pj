package com.project.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.UserDAO;
import com.project.DTO.UserDTO;

public class UserServiceInsert implements UserService {
    public ArrayList<UserDTO> execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<UserDTO> dtoList = null;

        // DAO에 있는 insert 메소드 수행
        UserDAO userDAO = new UserDAO();
        String id = request.getParameter("id");
        String nickname = request.getParameter("nickname");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address")+","+request.getParameter("detail_address");
        String email = request.getParameter("frontM")+request.getParameter("LastM");
        String birth = request.getParameter("year")+request.getParameter("month")+request.getParameter("day");
        // 콘솔 로그
        System.out.println("아이디 : " + id);
		System.out.println("닉네임 : " + nickname);
		System.out.println("비밀번호 : " + pw);
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + tel);
		System.out.println("주소 : " + address);

        // UserDAO 클래스의 UserInsert 메소드를 호출하여 사용자 정보를 데이터베이스에 삽입
        userDAO.UserInsert(id, nickname, pw, name, tel, address, email, birth);

        return dtoList;
    }
}
