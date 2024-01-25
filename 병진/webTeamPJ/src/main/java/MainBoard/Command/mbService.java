package MainBoard.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MainBoard.DTO.mainBoard_PpDTO;

import java.util.*;

public interface mbService {
	
	public ArrayList<mainBoard_PpDTO> execute(HttpServletRequest request, HttpServletResponse response);
	
}
