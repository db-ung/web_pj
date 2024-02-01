package MainBoard.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MainBoard.DAO.*;
import MainBoard.DTO.mainBoard_PpDTO;

public class Board2 implements mbService {
	public ArrayList<mainBoard_PpDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<mainBoard_PpDTO> result = new ArrayList<mainBoard_PpDTO>();
		DBConnectingDAO dao = new DBConnectingDAO();
		result = dao.PpBoard2();

		request.setAttribute("list", result);

		return result;
	}
}
