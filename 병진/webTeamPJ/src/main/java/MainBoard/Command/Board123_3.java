package MainBoard.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MainBoard.DAO.*;
import MainBoard.DTO.mainBoard_PpDTO;

public class Board123_3 implements mbService {
	public ArrayList<mainBoard_PpDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<mainBoard_PpDTO> result3 = new ArrayList<mainBoard_PpDTO>();
		DBConnectingDAO dao = new DBConnectingDAO();
		result3 = dao.PpBoard3();

		request.setAttribute("list3", result3);

		return result3;
	}
}
