package com.project.PostCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.PostDAO;
import com.project.DTO.PostDTO;

public class ViewPost implements PostService {
	public ArrayList<PostDTO> execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<PostDTO> dtoList = null;
        PostDAO dao = new PostDAO();
        
        dao.PostList(request,response);
        
        return dtoList;
	}
}
