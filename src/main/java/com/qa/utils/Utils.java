package com.qa.utils;

import java.sql.ResultSet;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.*;

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
			String topRow = "";
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				topRow += String.format("%1$-19s|",
							StringUtils.center(rs.getMetaData().getColumnLabel(i).toUpperCase(), 19));
				
			}
			results.add(StringUtils.repeat("-", topRow.length()));
			results.add(topRow);
			results.add(StringUtils.repeat("-", topRow.length()));

			while (rs.next()) {
				String row = "";
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row += String.format("%1$-19s|",
							StringUtils.center(rs.getString(i), 19));
				}
				results.add(row);
				
			}
		} catch (SQLException e) {
			LOGGER.error(e.toString());
			results.add("\nerror\n");
		}
		results.add(StringUtils.repeat("-", results.get(0).length()));
		return results;
	}

}
