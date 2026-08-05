package com.kh.music.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.music.model.dto.MusicDTO;
import com.kh.music.model.vo.Music;
import com.kh.music.util.DBUtil;

public class MusicDAO {
	
	// 곡 목록 조회
	public List<Music> findAll() {
		List<Music> list = new ArrayList<>();
		String sql = "SELECT * FROM MUSIC";
		
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rset = pstmt.executeQuery();) {
			
			while(rset.next()) {
				MusicDTO m = new MusicDTO(
						rset.getInt("id"),
						rset.getString("title"),
						rset.getString("singer")
						);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
