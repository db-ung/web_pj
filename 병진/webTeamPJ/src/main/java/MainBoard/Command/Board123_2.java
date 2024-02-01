package MainBoard.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MainBoard.DAO.*;
import MainBoard.DTO.mainBoard_PpDTO;

public class Board123_2 implements mbService {
	public ArrayList<mainBoard_PpDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<mainBoard_PpDTO> result2 = new ArrayList<mainBoard_PpDTO>();
		DBConnectingDAO dao = new DBConnectingDAO();
		result2 = dao.PpBoard2();

		request.setAttribute("list2", result2);

		return result2;
	}
}
