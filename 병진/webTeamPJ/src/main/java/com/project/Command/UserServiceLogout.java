package com.project.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DTO.UserDTO;

import java.util.ArrayList;

public class UserServiceLogout implements UserService {
    public ArrayList<UserDTO> execute(HttpServletRequest request, HttpServletResponse response) {
        // 세션을 가져오거나 없으면 새로 생성
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("nickname") != null) {
            try {
                // 세션 무효화
                session.invalidate();
                System.out.println("로그아웃 성공");

                // 로그아웃 성공 후 메인 페이지로 리다이렉트
                response.sendRedirect("successOut.jsp");

            } catch (IllegalStateException e) {
                // 세션이 이미 무효화되었을 경우
                System.out.println("이미 로그아웃되었습니다.");
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        } else {
            System.out.println("로그아웃 실패: 로그인 상태가 아닙니다.");
            // 로그인 상태가 아닌 경우 메인 페이지로 리다이렉트
            try {
                response.sendRedirect("mainboard.jsp");
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }

        // 로그아웃 기능에서는 반환값이 필요하지 않음
        return null;
    }
}
