package com.xworkz.resort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.resort.dto.ResortDTO;

@Component
public class ResortDAOImpl implements ResortDAO {
	@Autowired
	private DataSource source;

	@Override
	public boolean save(ResortDTO dto) {
		String sql = "INSERT INTO Resort values(?,?,?,?,?,?,?,?)";

		try (Connection connection = source.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dto.getId());
			statement.setString(2, dto.getName());
			statement.setString(3, dto.getOwnerName());
			statement.setTime(4, Time.valueOf(dto.getOpenTime()));
			statement.setTime(5, Time.valueOf(dto.getCloseTime()));
			statement.setDouble(6, dto.getEntrencePrice());
			statement.setDouble(7, dto.getGstPercentage());
			statement.setDouble(8, dto.getTotalPrice());

			int row = statement.executeUpdate();
			System.out.println(row);
			return row > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
