package MainBoard.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MainBoard.DAO.*;
import MainBoard.DTO.mainBoard_PpDTO;

public class Board123_1 implements mbService {
	public ArrayList<mainBoard_PpDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<mainBoard_PpDTO> result1 = new ArrayList<mainBoard_PpDTO>();		
		DBConnectingDAO dao1 = new DBConnectingDAO();		
		result1 = dao1.PpBoard1();		
		ArrayList<ArrayList<mainBoard_PpDTO>> combinedResult = new ArrayList<>();
		combinedResult.add(result1);	
		request.setAttribute("list1", result1);
		

		return result1;
	}
}
