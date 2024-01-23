package com.project.DAO;

import java.sql.*;
import javax.sql.DataSource;

import com.project.DTO.PostDTO;
import com.project.DTO.UserDTO;
import java.util.*;
import javax.naming.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private DataSource ds = null;

    public UserDAO() {
        try {
            // JNDI를 사용하여 데이터 소스 설정
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
        } catch (Exception e) {
            System.out.println("UserDAO 생성자 에러");
            e.printStackTrace();
        }
    }

    // 회원 가입
    public void UserInsert(String id, String nickname, String pw, String name, String tel, String address, String email, String birth) {
        try {
            // DB 연결
            conn = ds.getConnection();

            // INSERT 쿼리 수행
            String query = "INSERT INTO USER (id, nickname, pw, name, tel, address, email, birth) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, nickname);
            ps.setString(3, pw);
            ps.setString(4, name);
            ps.setString(5, tel);
            ps.setString(6, address);
            ps.setString(7, email);
            ps.setString(8, birth);

            try {
                ps.executeUpdate();
                System.out.println("회원가입 완료.");
            } catch (SQLIntegrityConstraintViolationException e) {
                // PRIMARY KEY 또는 UNIQUE 제약 조건 위반
                System.out.println("중복된 사용자 아이디 입니다.");
                // 추가적인 처리를 수행하거나 예외를 다시 throw할 수 있습니다.
            }
        } catch (Exception e) {
            System.out.println("Insert 쿼리 수행 실패");
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // 회원 탈퇴
    public void UserDelete(String id, String pw) {
        try {
            conn = ds.getConnection();

            String query = "DELETE FROM USER WHERE id=? AND pw=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, pw);
            ps.executeUpdate();
            System.out.println("Delete 성공");
        } catch (Exception e) {
            System.out.println("Delete 쿼리 수행 실패");
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

 // 로그인
    public void UserLogin(String id, String pw, HttpServletRequest request, HttpServletResponse response) {
        conn=null;
        ps=null;
        rs=null;

        try {
            conn=ds.getConnection();

            String query="SELECT * FROM user WHERE id=? AND pw=?";
            ps=conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, pw);
            rs = ps.executeQuery();

            if(rs.next()) {
                // 로그인 성공 시 'success' 파라미터를 추가하여 리다이렉트
                response.sendRedirect("main.html?success");
                System.out.println("Login 성공");
            } else {
                // 로그인 실패 시 로그인 페이지로 리다이렉트
                response.sendRedirect("login.html");
                System.out.println("Login 실패");
            }   
        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch(Exception e2) {
                System.out.println(e2.toString());
                e2.printStackTrace();
            }
        }
    }
      
   
    

    // 자원 해제 메서드
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            System.out.println("객체 닫기 실패");
            e.printStackTrace();
        }
    }
}
