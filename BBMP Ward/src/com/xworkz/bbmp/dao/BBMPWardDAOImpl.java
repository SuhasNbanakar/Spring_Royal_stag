package com.xworkz.bbmp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.bbmp.dto.BBMPWardDTO;

@Component
public class BBMPWardDAOImpl implements BBMPWardDAO {

	@Autowired
	private DataSource dataSource;

	@Override
	public boolean save(BBMPWardDTO dto) {

		String sql = "INSERT INTO bbmpward values(?,?,?,?,?,?,?,?)";

		try (Connection connection = dataSource.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dto.getId());
			statement.setInt(2, dto.getWardNo());
			statement.setString(3, dto.getWardName());
			statement.setString(4, dto.getCorporatorName());
			statement.setString(5, dto.getMla());
			statement.setDouble(6, dto.getBudget());
			statement.setDouble(7, dto.getSpent());
			statement.setDouble(8, dto.getRemaing());

			int row = statement.executeUpdate();
			System.out.println(row);
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
