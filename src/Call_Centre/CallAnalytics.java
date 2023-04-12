package Call_Centre;


import java.sql.*;

public class CallAnalytics {

   
	public static void main(String[] args) {
        try {
           
        	// Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");

            // Query 1: Hour of the day when the call volume is highest
            String query1 = "SELECT HOUR(Start_time) AS hour_of_day, COUNT(*) AS call_count " +
                            "FROM calls " +
                            "GROUP BY HOUR(Start_time) " +
                            "ORDER BY call_count DESC " +
                            "LIMIT 1";
            Statement statement1 = connection.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(query1);
            if (resultSet1.next()) {
                int hourOfDay = resultSet1.getInt("hour_of_day");
                int callCount = resultSet1.getInt("call_count");
                System.out.println("Hour of the day when the call volume is highest: " + hourOfDay + ":00-" + (hourOfDay+1) + ":00, Call count: " + callCount);
            }

            // Query 2: Hour of the day when the calls are longest
            String query2 = "SELECT HOUR(Start_time) AS hour_of_day, AVG(Duration) AS avg_duration " +
                            "FROM calls " +
                            "GROUP BY HOUR(Start_time) " +
                            "ORDER BY avg_duration DESC " +
                            "LIMIT 1";
            Statement statement2 = connection.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query2);
            if (resultSet2.next()) {
                int hourOfDay = resultSet2.getInt("hour_of_day");
                int avgDuration = resultSet2.getInt("avg_duration");
                System.out.println("Hour of the day when the calls are longest: " + hourOfDay + ":00-" + (hourOfDay+1) + ":00, Average duration: " + avgDuration + " seconds");
            }

            // Query 3: Day of the week when the call volume is highest
            String query3 = "SELECT DAYOFWEEK(Start_time) AS day_of_week, COUNT(*) AS call_count " +
                            "FROM calls " +
                            "GROUP BY DAYOFWEEK(Start_time) " +
                            "ORDER BY call_count DESC " +
                            "LIMIT 1";
            Statement statement3 = connection.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(query3);
            if (resultSet3.next()) {
                int dayOfWeek = resultSet3.getInt("day_of_week");
                int callCount = resultSet3.getInt("call_count");
                System.out.println("Day of the week when the call volume is highest: " + dayOfWeek + ", Call count: " + callCount);
            }

            // Query 4: Day of the week when the calls are longest
            String query4 = "SELECT DAYOFWEEK(Start_time) AS day_of_week, AVG(Duration) AS avg_duration " +
                            "FROM calls " +
                            "GROUP BY DAYOFWEEK(Start_time) " +
                            "ORDER BY avg_duration DESC " +
                            "LIMIT 1";
            Statement statement4 = connection.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(query4);
            if (resultSet4.next()) {
                int dayOfWeek = resultSet4.getInt("day_of_week");
                int avgDuration = resultSet4.getInt("avg_duration");
                System.out.println("Day of the week when the calls are longest: " + dayOfWeek + ", Average duration: " + avgDuration);
            }
        }
        catch(SQLException e) {
        	e.printStackTrace();
        }
	
       
	
    }
}
                
