# Assignment-9---Database-Comparison

The main file with quries can be found [here](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/DatabaseCompairson/src/main/java/Connector/Queries.java)

I have decided to small csv files even tho Helge said we shouldnt, since it took way to long to preform thees quries on the bit dataset.

### **Intro to the setup**
This assignment was made with MySQL WorkBench, Netbeans and Neo4j.
I made a maven project in netbeans as seen in my repository, and Im using the class
[DBConnector](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/DatabaseCompairson/src/main/java/Connector/DBConnector.java)
to establish my connection to my SQL database, and Im using the class
[Queries](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/DatabaseCompairson/src/main/java/Connector/Queries.java)
as my main and this executes the Depth 1-5 assignment and measures the execution time.
The main class also establish the connection to the neo4j database this happens in the last method called `NEOendorses(String query)` on line `172`.

[SQL queries](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/Part3.sql)

### **Setup the project**
As mentioned this is a maven project so it will work on multiple IDE's.
- Clone this project.
- Get the CSV files: [social_network_nodes](https://raw.githubusercontent.com/datsoftlyngby/soft2018spring-databases-teaching-material/master/data/social_network_nodes_small.csv) & [social_network_edges](https://raw.githubusercontent.com/datsoftlyngby/soft2018spring-databases-teaching-material/master/data/social_network_edges_small.csv)
- Import the data into MySQL and Neo4j.
- Open the project DatabaseCompairson in your IDE.
- Change the port, user and password in: [DBConnector](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/DatabaseCompairson/src/main/java/Connector/DBConnector.java) & [Queries](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/DatabaseCompairson/src/main/java/Connector/Queries.java)
to your own accesspoint.
- Run the main in Queries.

### **Execution time**

**SQL**
- Depth1: 40357346 nanoseconds
- Depth2: 7894546 nanoseconds
- Depth3: 32574262 nanoseconds
- Depth4: 63412746 nanoseconds
- Depth5: 260273440 nanoseconds

**NEO**
- Depth1: 64372520 nanoseconds
- Depth2: 33120736 nanoseconds
- Depth3: 33074180 nanoseconds
- Depth4: 40185566 nanoseconds
- Depth5: 79034815 nanoseconds

### **Conclusion**
As we can se under the execution time section, we have almost the same time in the first four depths, but when we get to depth 5 we get the jump on for the neo4j database. And this is only for a dataset of 200 entries, imagine then if we had a million then this number would create an even bigger gab. I belive for the SQL database the execution time will continue to rise, and even faster the more data we get. Where the neo4j database can handle big datasets with good performence quallity and fast relation lookups.
