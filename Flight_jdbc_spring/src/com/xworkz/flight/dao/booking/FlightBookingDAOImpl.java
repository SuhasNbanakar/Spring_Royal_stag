package com.xworkz.flight.dao.booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.xworkz.flight.dto.booking.FlightBookingDTO;
import static com.xworkz.flight.constants.JdbcProperties.*;

@Component
public class FlightBookingDAOImpl implements FlightBookingDAO {

	@Override
	public boolean save(FlightBookingDTO dto) {

		String sql = "INSERT INTO flight values(?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = DriverManager.getConnection(URL.getValue(), USERNAME.getValue(),
				SECRET.getValue())) {

			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setInt(1, dto.getId());
			prepare.setString(2, dto.getPassengerName());
			prepare.setBoolean(3, dto.isInternational());
			prepare.setString(4, dto.getPassportNo());
			prepare.setString(5, dto.getAirline());
			prepare.setString(6, dto.getBoarding());
			prepare.setString(7, dto.getDestination());
			prepare.setDouble(8, dto.getTicketPrice());
			prepare.setDate(9, Date.valueOf(dto.getTravelDateAndTime().toLocalDate()));
			prepare.setDouble(10, dto.getGstPercentage());
			prepare.setDouble(11, dto.getTotalPrice());

			int row = prepare.executeUpdate();
			System.out.println(row);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
