package com.qa.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

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
			StringBuilder topRow = new StringBuilder();
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				topRow.append(String.format("%1$-19s|",
						StringUtils.center(rs.getMetaData().getColumnLabel(i).toUpperCase(), 19)));

			}
			results.add(StringUtils.repeat("_", topRow.length()));
			results.add(topRow.toString());
			results.add(StringUtils.repeat("-", topRow.length()));

			while (rs.next()) {
				StringBuilder row = new StringBuilder();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.append(String.format("%1$-19s|", StringUtils.center(rs.getString(i), 19)));
				}
				results.add(row.toString());

			}
		} catch (SQLException e) {
			LOGGER.error(e.toString());
			results.add("\nerror\n");
		}
		results.add(StringUtils.repeat("_", results.get(0).length()));
		return results;
	}

	public static void errorPrint(Exception e) {
		LOGGER.error(e.toString());
		LOGGER.info("An error occured while completeing the action, please check the log files");
	}

}
