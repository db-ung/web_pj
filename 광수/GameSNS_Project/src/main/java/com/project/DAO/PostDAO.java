package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.DTO.PostDTO;

public class PostDAO {
	private Connection conn= null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	private DataSource ds = null;
	
	public PostDAO() {
		try {
			//jdbc 드라이버 로드
			 Context ctx = new InitialContext();
			 ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
			 
			
		}catch(Exception e) {
			System.out.println("PostDAO 생성자 에러");
			e.printStackTrace();
		}
	}
	
	
	
	
	//게시판 검색
	    public List<PostDTO> searchPosts(String keyword) {
	        List<PostDTO> result = new ArrayList<>();
	        conn = null;
			st = null;
			rs = null;        		

	        try {
	        	//connection 객체 생성
	            conn = ds.getConnection();
	            	          
	            // 게시글에서 제목 또는 내용에 키워드가 포함된 것을 검색
	            String query = "SELECT * FROM post_info WHERE post_title LIKE ? OR post_content LIKE ?";
	            ps = conn.prepareStatement(query);
	            ps.setString(1, "%" + keyword + "%");
	            ps.setString(2, "%" + keyword + "%");
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                // 결과를 PostDTO 객체로 매핑하여 리스트에 추가
	                PostDTO post = new PostDTO();
	               post.setPost_no(rs.getString("post_no"));
	               post.setPost_title(rs.getString("post_title"));
	               post.setPost_content(rs.getString("post_content"));
	               post.setPost_uploadtime(rs.getString("post_uploadtime"));
	               post.setVisit_cnt(rs.getString("visit_cnt"));
	                
	                result.add(post);
	            }
	        } catch (Exception e) {
	            System.out.println("게시판 검색 실패");
	            e.printStackTrace();
	        } finally {
	        	try {
	        		if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	        		System.out.println("좋았어 오류! 나와라!");
	          	}catch(Exception e2) {
	          		System.out.println("객체 닫기 실패");
	          		e2.printStackTrace();
	          		
	          	}
	        }
	        System.out.println("좋았어 오류야!");
	        return result;
	        
	    }
		
	
	
	
	
}
