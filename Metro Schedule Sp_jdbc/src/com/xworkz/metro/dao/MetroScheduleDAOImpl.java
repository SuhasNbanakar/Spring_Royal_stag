package com.xworkz.metro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.metro.dto.MetroScheduleDTO;

@Component
public class MetroScheduleDAOImpl implements MetroScheduleDAO {
	@Autowired
	private DataSource dataSource;

	@Override
	public boolean save(MetroScheduleDTO dto) {

		String sql = "INSERT INTO metro values(?,?,?,?,?,?,?,?,?)";

		try (Connection connection = dataSource.getConnection()) {
			// id,station,platform,trainNo,dateAndtime,passengerName,
			// destination,ticketPrice,duration
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dto.getId());
			statement.setString(2, dto.getStationName());
			statement.setInt(3, dto.getPlatform());
			statement.setInt(4, dto.getTrainNo());
			statement.setTimestamp(5, Timestamp.valueOf(dto.getDateAndTime()));
			statement.setString(6, dto.getPassengerName());
			statement.setString(7, dto.getDestination());
			statement.setDouble(8, dto.getTicketPrice());
			statement.setTime(9, Time.valueOf(dto.getDuration()));

			int row = statement.executeUpdate();
			System.out.println(row);
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
