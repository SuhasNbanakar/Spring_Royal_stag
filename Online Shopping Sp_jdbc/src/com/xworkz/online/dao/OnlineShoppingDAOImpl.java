package com.xworkz.online.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.online.dto.OnlineShoppingDTO;

@Component
public class OnlineShoppingDAOImpl implements OnlineShoppingDAO {

	@Autowired
	private DataSource source;

	@Override
	public boolean save(OnlineShoppingDTO dto) {
		String sql = "INSERT INTO online_shopping values(?,?,?,?,?,?,?,?)";

		try (Connection connection = source.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, dto.getId());
			statement.setString(2, dto.getProductName());
			statement.setDouble(3, dto.getPrice());
			statement.setString(4, dto.getType());
			statement.setInt(5, dto.getQuantity());
			statement.setDouble(6, dto.getDiscount());
			statement.setDouble(7, dto.getGstPercentage());
			statement.setDouble(8, dto.getPaying());

			int row = statement.executeUpdate();
			System.out.println(row);
			return row > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
