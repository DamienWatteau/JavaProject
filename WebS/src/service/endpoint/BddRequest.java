package service.endpoint;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BddRequest {
	public static List<String> getWordsFromBdd(String caract) throws SQLException {
		List<String> list = new ArrayList();
		
		Connection connection = ConnectionOracle.getIntance();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select Nom from DC22740 where Nom like '"+caract+"%'");
		while(rs.next()) {
			list.add(rs.getString(1));
		}
		
		return list;
	}
}
