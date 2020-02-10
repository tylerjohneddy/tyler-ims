package com.qa.utils;

import java.sql.ResultSet;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.qa.controller.Action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
	public static final Logger LOGGER = Logger.getLogger(Utils.class);

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
		
	}

	public List<String> resultSetToArrayList(ResultSet rs) {
		List<String> results = new ArrayList<>();

		try {

			while (rs.next()) {
				String row = "";
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row += String.format("|%1$-15s:%2$-15s|",
							StringUtils.center(rs.getMetaData().getColumnLabel(i), 15),
							StringUtils.center(rs.getString(i), 15));
				}
				results.add(row);
			}
		} catch (SQLException e) {
			LOGGER.error(e.toString());
			results.add("\nerror\n");
		}
		return results;
	}

}
