package com.frkl.hwjun;

/**
 *
 * @author klimci
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class HwjunApplication {

	public static void main(String[] args) {
	SpringApplication.run(HwjunApplication.class, args);
        
        String[] docID = {"be8752a3-8044-4532-b14a-5a27110e14a7", "be8752a3-8044-4532-b14a-5a27110e14a7", "be8752a3-8044-4532-b14a-5a27110e14a7", "be8752a3-8044-4532-b14a-5a27110e14a7", "be8752a3-8044-4532-b14a-5a27110e14a7", "c3bd3ffb-02d0-4bca-9c2e-b1ebc266e1b6", "c3bd3ffb-02d0-4bca-9c2e-b1ebc266e1b6", "c3bd3ffb-02d0-4bca-9c2e-b1ebc266e1b6", "c3bd3ffb-02d0-4bca-9c2e-b1ebc266e1b6", "e0b8ba7a-3ec2-42cf-bce1-0b3cf838c07d", "e0b8ba7a-3ec2-42cf-bce1-0b3cf838c07d", "e0b8ba7a-3ec2-42cf-bce1-0b3cf838c07d", "9dbd31fb-3fbc-49dd-9cea-af23dc043c74"};
        String[] usrID = {"8f06db54-9944-49ee-b416-e1124402f05a", "8f06db54-9944-49ee-b416-e1124402f05a", "8f06db54-9944-49ee-b416-e1124402f05a", "8f06db54-9944-49ee-b416-e1124402f05a", "8f06db54-9944-49ee-b416-e1124402f05a", "14d230c0-4b22-4a75-bd6b-ecaadc5e6ed0", "14d230c0-4b22-4a75-bd6b-ecaadc5e6ed0", "14d230c0-4b22-4a75-bd6b-ecaadc5e6ed0", "14d230c0-4b22-4a75-bd6b-ecaadc5e6ed0", "bc045f4d-fafb-40aa-8000-93b65edbd85b", "bc045f4d-fafb-40aa-8000-93b65edbd85b", "bc045f4d-fafb-40aa-8000-93b65edbd85b", "bc045f4d-fafb-40aa-8000-93b65eabd85b"};
        String[] timOA = {"1368702920000", "1168702920000", "1612702920000", "1668702920000", "1668702920000", "1668702680000", "1668702680000", "1668702680000", "1668702680000", "1668702780000", "1668702780000", "1668702780000", "1668702780000"};      
        
        Connection conn = null;
        Statement stmt = null;

        for (int i = 1; i < 14; i++) {

            try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:mem:accesses", "frkl", "");
            stmt = conn.createStatement();
            String sql = "INSERT INTO ACCESSES (ID, TIME_OF_ACCESS, DOCUMENTID, USERID) "
                    + "VALUES (" + i + ", " + timOA[i] + ",'" + docID[i] + "','" + usrID[i] + "')";
            stmt.execute(sql);
            } catch (SQLException se) {
            } catch (Exception e) {

            } finally {
            try {
                if (stmt!=null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn!= null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
  
       
        }

    }    
}

        

