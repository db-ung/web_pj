package MainBoard.DAO;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.DataSource;
import java.util.*;
import javax.naming.*;

import MainBoard.DTO.mainBoard_PpDTO;

public class DBConnectingDAO {
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private DataSource ds = null;

	public DBConnectingDAO() {
		try {
            if (ds == null) {
            	System.out.println("DataSource is null. Please check your configuration.");
                Context ctx = new InitialContext();
                ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
            }
        } catch (Exception e) {
        	System.out.println("Error initializing DataSource: " + e.toString());
            e.printStackTrace();
        }
	}

	public ArrayList<mainBoard_PpDTO> PpBoard1() {
		ArrayList<mainBoard_PpDTO> result = new ArrayList<mainBoard_PpDTO>();
		con = null;
		st = null;
		rs = null;
		try {
			con = ds.getConnection();
			String query = "select * from board where tag = 'lol' order by isgood desc limit 10";
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				mainBoard_PpDTO mp = new mainBoard_PpDTO();
				mp.setIDX(rs.getInt("IDX"));
				mp.setTITLE(rs.getString("TITLE"));
				mp.setIsgood(rs.getInt("isgood"));

				result.add(mp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.toString());
				e2.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<mainBoard_PpDTO> PpBoard2() {
		ArrayList<mainBoard_PpDTO> result = new ArrayList<mainBoard_PpDTO>();
		con = null;
		st = null;
		rs = null;
		try {
			con = ds.getConnection();
			String query = "select * from board where tag = 'star' order by isgood desc limit 10";
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				mainBoard_PpDTO mp = new mainBoard_PpDTO();
				mp.setIDX(rs.getInt("IDX"));
				mp.setTITLE(rs.getString("TITLE"));
				mp.setIsgood(rs.getInt("isgood"));

				result.add(mp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.toString());
				e2.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<mainBoard_PpDTO> PpBoard3() {
		ArrayList<mainBoard_PpDTO> result = new ArrayList<mainBoard_PpDTO>();
		con = null;
		st = null;
		rs = null;
		try {
			con = ds.getConnection();
			String query = "select * from board where tag = 'fifa' order by isgood desc limit 10";
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				mainBoard_PpDTO mp = new mainBoard_PpDTO();
				mp.setIDX(rs.getInt("IDX"));
				mp.setTITLE(rs.getString("TITLE"));
				mp.setIsgood(rs.getInt("isgood"));

				result.add(mp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.toString());
				e2.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<mainBoard_PpDTO> NewPostList() {
		ArrayList<mainBoard_PpDTO> result = new ArrayList<mainBoard_PpDTO>();
		con = null;
		st = null;
		rs = null;
		try {
			con = ds.getConnection();
			String query = "select * from board order by date desc limit 10";
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				mainBoard_PpDTO mp = new mainBoard_PpDTO();
				mp.setIDX(rs.getInt("IDX"));
				mp.setTITLE(rs.getString("TITLE"));
				mp.setIsgood(rs.getInt("isgood"));

				result.add(mp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.toString());
				e2.printStackTrace();
			}
		}
		return result;
	}
}
