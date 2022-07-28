package com.workz.hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/register")
public class Hospital extends HttpServlet {

	public Hospital() {

		System.out.println("Create HospitalServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Invoking the Doput methods");
		String FirstName = req.getParameter("FirstName");
		String LastName = req.getParameter("LastName");
		String Email = req.getParameter("Email");
		String Age = req.getParameter("Age");
		String Mobile = req.getParameter("Mobile");
		String Password = req.getParameter("Password");
		String ConfirmPassword = req.getParameter("ConfirmPassword");
		System.out.println(FirstName);
		System.out.println(LastName);
		System.out.println(Email);
		System.out.println(Age);
		System.out.println(Mobile);
		System.out.println(Password);
		System.out.println(ConfirmPassword);

		resp.setContentType("text/html");

		PrintWriter printWriter = resp.getWriter();

		String message = null;
		String fontColor = "green";
		boolean select = true;
		if (FirstName != null & !FirstName.isEmpty() && LastName != null) {
			message = "Out patient Registration is success";

		} else {
			message = "Out Patient register is failure Please enter the First Name";
			select = false;
			fontColor = "red";
		}

		String html = "<html><body> <h1 style='color:" + fontColor + ";'>" + message + "</h1>   </body> </html>";

		printWriter.write(html);

		if (select) {

			printWriter.print("<html><body>");
			printWriter.print("<h2>Below are the Details</h2>");
			printWriter.print("=================================" + "<br/>");
			printWriter.print("Full Name   : " + FirstName + "  " + LastName + "<br/>");
			printWriter.print("Current Date: " + LocalDate.now() + "<br/>");
			printWriter.print("Age         : " + Age + "<br/>");
			printWriter.print("Email       : " + Email + "<br/>");
			printWriter.print("</body></html>");

		} else {
			printWriter.print(" ");
			fontColor = "red";
		}
		printWriter.close();
	}
}