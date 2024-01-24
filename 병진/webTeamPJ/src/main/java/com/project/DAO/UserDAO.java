package com.project.DAO;

import java.net.URLEncoder;
import java.sql.*;
import javax.sql.DataSource;
import java.io.IOException; // IOException 추가
import java.util.*;
import javax.naming.*;
import javax.servlet.RequestDispatcher; // RequestDispatcher 추가
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	// 아이디와 비밀번호 찾기
	public void findId(String name, String tel, HttpServletRequest request, HttpServletResponse response) {
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = ds.getConnection();

			String query = "SELECT * FROM user WHERE name=? AND tel=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, tel);
			rs = ps.executeQuery();

			if (rs.next()) {
				// ID 가져오기
				String id = rs.getString("id");

				// 세션을 가져오거나 없으면 새로 생성
				HttpSession session = request.getSession(true);

				// 세션에 사용자 정보 저장
				session.setAttribute("name", name);
				session.setAttribute("tel", tel);

				System.out.println("이름 : " + name);
				System.out.println("전화번호 : " + tel);
				System.out.println("찾은 ID: " + id);
			} else {
				// 로그인 실패 시 로그인 페이지로 리다이렉트
				response.sendRedirect("login.html");
				System.out.println("찾기 실패");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				System.out.println(e2.toString());
				e2.printStackTrace();
			}
		}
	}
	
	public void findPw(String name, String id, HttpServletRequest request, HttpServletResponse response) {
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = ds.getConnection();

			String query = "SELECT * FROM user WHERE name=? AND id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				// ID 가져오기
				String pw = rs.getString("pw");

				// 세션을 가져오거나 없으면 새로 생성
				HttpSession session = request.getSession(true);

				// 세션에 사용자 정보 저장
				session.setAttribute("name", name);
				session.setAttribute("id", id);

				System.out.println("이름 : " + name);
				System.out.println("아이디 : " + id);
				System.out.println("찾은 PW : " + pw);
			} else {
				// 로그인 실패 시 로그인 페이지로 리다이렉트
				response.sendRedirect("login.html");
				System.out.println("찾기 실패");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				System.out.println(e2.toString());
				e2.printStackTrace();
			}
		}
	}

	// 회원 가입
	public void UserInsert(String id, String nickname, String pw, String name, String tel, String address, String email,
			String birth, HttpServletRequest request, HttpServletResponse response) {
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
				System.out.println("아이디 : " + id);
				System.out.println("닉네임 : " + nickname);
				System.out.println("비밀번호 : " + pw);
				System.out.println("이름 : " + name);
				System.out.println("전화번호 : " + tel);
				System.out.println("주소 : " + address);
				response.sendRedirect("successSU.jsp");
			} catch (SQLIntegrityConstraintViolationException e) {
				// PRIMARY KEY 또는 UNIQUE 제약 조건 위반
				System.out.println("중복된 사용자 아이디 입니다.");
				System.out.println("중복된 아이디 : " + id);
				
				response.sendRedirect("failSU.jsp");
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
	public void UserDelete(String pw, HttpServletRequest request, HttpServletResponse response) {
	    conn = null;
	    ps = null;
	    rs = null;

	    try {
	        HttpSession session = request.getSession(); // 기존 세션 가져오기

	        conn = ds.getConnection();

	        String query = "DELETE FROM USER WHERE id=? AND pw=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, (String) session.getAttribute("id")); // 세션에서 아이디 가져오기
	        ps.setString(2, pw);
	        ps.executeUpdate();
	        System.out.println("Delete 성공");
	        System.out.println("탈퇴 된 계정 : " + session.getAttribute("id"));
	        response.sendRedirect("successDT.jsp");
	    } catch (Exception e) {
	        System.out.println("Delete 쿼리 수행 실패");
	        e.printStackTrace();
	    } finally {
	        closeResources();
	    }
	}

	// 로그인
	public void UserLogin(String id, String pw, HttpServletRequest request, HttpServletResponse response) {
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = ds.getConnection();

			String query = "SELECT * FROM user WHERE id=? AND pw=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();

			if (rs.next()) {
				// 닉네임 가져오기
				String nickname = rs.getString("nickname");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String birth = rs.getString("birth");

				// 세션을 가져오거나 없으면 새로 생성
				HttpSession session = request.getSession(true);

				// 세션에 사용자 정보 저장
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				session.setAttribute("nickname", nickname);
				session.setAttribute("name", name);
				session.setAttribute("address", address);
				session.setAttribute("tel", tel);
				session.setAttribute("birth", birth);

				// 로그인 성공 시 'success' 파라미터와 닉네임을 추가하여 리다이렉트
				response.sendRedirect("mainboard.jsp?success&id=" + URLEncoder.encode(id, "UTF-8") + "&success&pw="
						+ URLEncoder.encode(pw, "UTF-8") + "&success&nickname=" + URLEncoder.encode(nickname, "UTF-8")
						+ "&success&name=" + URLEncoder.encode(name, "UTF-8") + "&success&address="
						+ URLEncoder.encode(address, "UTF-8") + "&success&tel=" + URLEncoder.encode(tel, "UTF-8")
						+ "&success&birth=" + URLEncoder.encode(birth, "UTF-8"));

				System.out.println("아이디 : " + id);
				System.out.println("닉네임 : " + nickname);
				System.out.println("이름 : " + name);
				System.out.println("주소 : " + address);
				System.out.println("전화번호 : " + tel);
				System.out.println("생년월일 : " + birth);
				System.out.println("Login 성공");
			} else {
				// 로그인 실패 시 로그인 페이지로 리다이렉트
				response.sendRedirect("failLog.jsp");
				System.out.println("Login 실패");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				System.out.println(e2.toString());
				e2.printStackTrace();
			}
		}
	}

	// 자원 해제 메서드
	private void closeResources() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("객체 닫기 실패");
			e.printStackTrace();
		}
	}
}
