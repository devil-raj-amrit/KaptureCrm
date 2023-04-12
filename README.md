# KaptureCrm
The main java class is CallAnalytics.
Mysql database is used in this project and version of MySql connector is " mysql-connector-j-8.0.31 ".
To use your database in this project follow these steps :
1.  Open CallAnalytics.java file.
2.  Search for " Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root"); ".
3.  Change "mydatabase" with your database name.
4.  After that write your mysql username(in my case it is "root").
5.  Mysql password(in my case it is "root").

I have created a table named as "calls" which have Id(Primary key) , From_number , Start_time , End_time , Duration.

				
