package com.project.DAO;

import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.*;

import com.project.DTO.PostDTO;

public class PostDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private DataSource ds = null;
	private Statement st = null;

	public PostDAO() {
		try {
			// JNDI를 사용하여 데이터 소스 설정
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			System.out.println("PostDAO 생성자 에러");
			e.printStackTrace();
		}
	}

	// 게시물 작성
	public void PostInsert(String tag, String ID, String TITLE, String CONTENT, String FILE, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// 비어 있는 항목을 기록할 변수 초기화
			List<String> emptyFields = new ArrayList<>();

			// 각 항목이 비어있는지 체크
			if (tag == null || tag.trim().isEmpty()) {
				emptyFields.add("태그");
			}
			if (TITLE == null || TITLE.trim().isEmpty()) {
				emptyFields.add("제목");
			}
			if (CONTENT == null || CONTENT.trim().isEmpty()) {
				emptyFields.add("내용");
			}

			// 어떤 항목이 비어 있으면 실패 페이지로 리다이렉트 및 JavaScript 경고창
			if (!emptyFields.isEmpty()) {
				String errorMessage = String.join(", ", emptyFields) + " (을)를 작성 하지 않았습니다.";

				// JavaScript 코드를 클라이언트에게 전달하기 위한 스크립트 작성
				String jsScript = "alert('" + errorMessage + "'); location.href = 'failSU.jsp';";

				// JavaScript 코드를 응답에 포함하여 클라이언트에게 전송
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>" + jsScript + "</script>");
				out.close();
			}
			// DB 연결
			conn = ds.getConnection();

			// INSERT 쿼리 수행
			String query = "INSERT INTO board (tag, ID, TITLE, CONTENT, DATE, FILE, isgood) VALUES (?, ?, ?, ?, now(), ?, 0)";
			ps = conn.prepareStatement(query);
			ps.setString(1, tag);
			ps.setString(2, ID);
			ps.setString(3, TITLE);
			ps.setString(4, CONTENT);
			ps.setString(5, FILE);

			try {
				ps.executeUpdate();
				System.out.println("게시물 작성 완료.");
				System.out.println("태그 : " + tag);
				System.out.println("작성자 아이디 : " + ID);
				System.out.println("글 제목 : " + TITLE);
				System.out.println("글 내용 : " + CONTENT);
				response.sendRedirect("successPosting.jsp");
			} catch (Exception e) {
				System.out.println("게시물 작성 실패 (catch).");
				response.sendRedirect("failSU.jsp");
			}
		} catch (Exception e) {
			System.out.println("Insert 쿼리 수행 실패");
			e.printStackTrace();
		}
	}

	// 게시물 보기
	public void PostList(HttpServletRequest request, HttpServletResponse response) {

		conn = null;
		st = null;
		rs = null;

		HttpSession session = request.getSession(true);

		try {
			conn = ds.getConnection();
			String Query = "select * from board order by IDX desc";
			ps = conn.prepareStatement(Query);
			rs = ps.executeQuery();
			List<Map<String, String>> boardList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> boardInfo = new HashMap<>();
				boardInfo.put("tag", rs.getString("tag"));
				boardInfo.put("title", rs.getString("TITLE"));
				boardInfo.put("idx", rs.getString("IDX"));

				boardList.add(boardInfo);
			}

			session.setAttribute("boardList", boardList);
			
			response.sendRedirect("ViewPost.jsp");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.toString());
				e2.printStackTrace();
			}
		}
	}
}
