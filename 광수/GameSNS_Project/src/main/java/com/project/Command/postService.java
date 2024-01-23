package com.project.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DTO.PostDTO;

public interface postService {

	public ArrayList<PostDTO> execute(HttpServletRequest request, HttpServletResponse response);
}
