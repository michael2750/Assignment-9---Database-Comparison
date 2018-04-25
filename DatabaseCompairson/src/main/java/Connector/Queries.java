package Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

public class Queries {

    public static void main(String[] args) throws Exception {
        //Query 1
        long End1_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsOne();
        }
        long End1_ETime = System.nanoTime();
        long End1_TotalTime = ((End1_ETime - End1_STime) / 20);

        //Query 2
        long End2_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsTwo();
        }
        long End2_ETime = System.nanoTime();
        long End2_TotalTime = ((End2_ETime - End2_STime) / 20);

        //Query 3
        long End3_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsThree();
        }
        long End3_ETime = System.nanoTime();
        long End3_TotalTime = ((End3_ETime - End3_STime) / 20);

        //Query 4
        long End4_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsFour();
        }
        long End4_ETime = System.nanoTime();
        long End4_TotalTime = ((End4_ETime - End4_STime) / 20);

        //Query 5
        long End5_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsFive();
        }
        long End5_ETime = System.nanoTime();
        long End5_TotalTime = ((End5_ETime - End5_STime) / 20);
        
        // NEO endorses 1
        long NEO_endorses1_startTime = System.nanoTime();
        for (int i = 1; i <= 20; i++) {
            //NEOendorses("MATCH (:Person {name: '${name}'})-[:ENDORSES]->(other) RETURN distinct other");
            NEOendorses("MATCH ({name:'Sol Linkert'})-[:ENDORSES]->(other) RETURN other");
        }
        long NEO_endorses1_endTime = System.nanoTime();
        long NEO_endorses1_duration = ((NEO_endorses1_endTime - NEO_endorses1_startTime) / 20);
        
        // NEO endorses 2
        long NEO_endorses2_startTime = System.nanoTime();
        for (int i = 1; i <= 20; i++) {
            NEOendorses("MATCH ({name:'Sol Linkert'})-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other");
        }
        long NEO_endorses2_endTime = System.nanoTime();
        long NEO_endorses2_duration = ((NEO_endorses2_endTime - NEO_endorses2_startTime) / 20);
        
        // NEO endorses 3
        long NEO_endorses3_startTime = System.nanoTime();
        for (int i = 1; i <= 20; i++) {
            NEOendorses("MATCH ({name:'Sol Linkert'})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other");
        }
        long NEO_endorses3_endTime = System.nanoTime();
        long NEO_endorses3_duration = ((NEO_endorses3_endTime - NEO_endorses3_startTime) / 20);
        
        // NEO endorses 4
        long NEO_endorses4_startTime = System.nanoTime();
        for (int i = 1; i <= 20; i++) {
            NEOendorses("MATCH ({name:'Sol Linkert'})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other");
        }
        long NEO_endorses4_endTime = System.nanoTime();
        long NEO_endorses4_duration = ((NEO_endorses4_endTime - NEO_endorses4_startTime) / 20);
        
        // NEO endorses 5
        long NEO_endorses5_startTime = System.nanoTime();
        for (int i = 1; i <= 20; i++) {
            NEOendorses("MATCH ({name:'Sol Linkert'})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other");
        }
        long NEO_endorses5_endTime = System.nanoTime();
        long NEO_endorses5_duration = ((NEO_endorses5_endTime - NEO_endorses5_startTime) / 20);
        
        System.out.println("SQL:");
        System.out.println("Depth1: " + End1_TotalTime + " nanoseconds");
        System.out.println("Depth2: " + End2_TotalTime + " nanoseconds");
        System.out.println("Depth3: " + End3_TotalTime + " nanoseconds");
        System.out.println("Depth4: " + End4_TotalTime + " nanoseconds");
        System.out.println("Depth5: " + End5_TotalTime + " nanoseconds");
        
        System.out.println("NEO:");
        System.out.println("Endorses 1 - " + NEO_endorses1_duration + " nanoseconds");
        System.out.println("Endorses 2 - " + NEO_endorses2_duration + " nanoseconds");
        System.out.println("Endorses 3 - " + NEO_endorses3_duration + " nanoseconds");
        System.out.println("Endorses 4 - " + NEO_endorses4_duration + " nanoseconds");
        System.out.println("Endorses 5 - " + NEO_endorses5_duration + " nanoseconds");

    }

    public static void EndorsementsOne() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'))";
        ResultSet res = state.executeQuery(query);
    }

    public static void EndorsementsTwo() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary')))";
        ResultSet res = state.executeQuery(query);
    }

    public static void EndorsementsThree() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'))))";
        ResultSet res = state.executeQuery(query);
    }

    public static void EndorsementsFour() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary')))))";
        ResultSet res = state.executeQuery(query);
    }

    public static void EndorsementsFive() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'))))))";
        ResultSet res = state.executeQuery(query);
    }
    
    public static void NEOendorses(String query) {
        Driver driver = GraphDatabase.driver("bolt://localhost:11002", AuthTokens.basic("user", "root123"));
        Session session = driver.session();
        StatementResult result = session.run(query);
        session.close();
        driver.close();
    }
}
