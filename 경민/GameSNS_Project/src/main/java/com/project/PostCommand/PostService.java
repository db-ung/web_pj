package com.project.PostCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.project.DTO.PostDTO;

public interface PostService {
	// interface :: 필드는 모두 상수, 메소드는 모두 추상 메소드
	
	// execute 추상 메소드 만들기
	// insert, delete, select, login-test 기능
	public ArrayList<PostDTO> execute(HttpServletRequest request, HttpServletResponse response);
}
