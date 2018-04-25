# Assignment-9---Database-Comparison

The main file with quries can be found [here](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/DatabaseCompairson/src/main/java/Connector/Queries.java)

I have decided to small csv files even tho Helge said we shouldnt, since it took way to long to preform thees quries on the bit dataset.

This assignment was made with MySQL WorkBench, Netbeans and Neo4j.
I made a maven project in netbeans as seen in my repository, and Im using the class
[DBConnector](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/DatabaseCompairson/src/main/java/Connector/DBConnector.java)
to establish my connection to my SQL database, and Im using the class
[Queries](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/DatabaseCompairson/src/main/java/Connector/Queries.java)
as my main and this executes the Depth 1-5 assignment and measures the execution time.
The main class also establish the connection to the neo4j database this happens in the last method called `NEOendorses(String query)` on line `172`

[SQL queries](https://github.com/michael2750/Assignment-9---Database-Comparison/blob/master/Part3.sql)

Havent got to the Neo4j part! :(

### **Execution time**:

**SQL**
- Depth1: 40357346 nanoseconds
- Depth2: 7894546 nanoseconds
- Depth3: 32574262 nanoseconds
- Depth4: 63412746 nanoseconds
- Depth5: 260273440 nanoseconds

**NEO**
- Depth1: 64372520 nanoseconds
- Depth2: 33120736 nanoseconds
- Depth2: 33074180 nanoseconds
- Depth2: 40185566 nanoseconds
- Depth2: 79034815 nanoseconds
