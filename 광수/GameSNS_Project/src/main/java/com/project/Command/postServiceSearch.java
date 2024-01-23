package com.project.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.PostDAO;
import com.project.DTO.PostDTO;

public class postServiceSearch implements postService {
	public ArrayList<PostDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<PostDTO> result = new ArrayList<PostDTO>();
		System.out.println("진행중 postService1");

		// 검색어 받아오기.
		String keyword = request.getParameter("searchKeyword");

		// 검색어가 비어있지 않은 경우에만 처리
		if (keyword != null && !keyword.isEmpty()) {
			System.out.println("검색 키워드: " + keyword);

			PostDAO dao = new PostDAO();
			result = (ArrayList<PostDTO>) dao.searchPosts(keyword);
		}else {
			System.out.println("검색어가 없습니다.");
		}
		

		System.out.println("진행중 postService2");
		request.setAttribute("postList", result);
		System.out.println("진행중 postService3");

		return result;

	}
}
