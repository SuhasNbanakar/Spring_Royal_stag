package com.xworkz.recharge.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.recharge.dto.RechargeCoupounDTO;

@Component
public class RechargeCoupounDAOImpl implements RechargeCoupounDAO {

	@Autowired
	private DataSource datasource;

	@Override
	public boolean save(RechargeCoupounDTO dto) {
		String sql = "insert into recharge_coupon values(?,?,?,?,?,?,?)";
		try (Connection connect = datasource.getConnection()) {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, dto.getId());
			statement.setString(2, dto.getName());
			statement.setDouble(3, dto.getDiscount());
			statement.setDouble(4, dto.getCash());
			statement.setString(5, dto.getCode());
			statement.setDate(6, Date.valueOf(dto.getValidtyDate()));
			statement.setBoolean(7, dto.isFree());
			int row = statement.executeUpdate();
			System.out.println(row);
			return row > 0;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}

}
