package com.frkl.hwjun;

/**
 *
 * @author klimci
 */

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PopularityService {
   @Autowired
   PopularityRepository repository;
   
   @Autowired
   JdbcTemplate jdbcTemplate;
   
   public List<Popularity> getAllPopularities(){

      Calendar c = Calendar.getInstance();
      c.set(Calendar.DATE, c.get(Calendar.DATE)-7);
       
      jdbcTemplate.execute("TRUNCATE TABLE POPULARITY; "
            + "DELETE FROM ACCESSES WHERE TIME_OF_ACCESS < " + c.getTimeInMillis() + "; "  
            + "INSERT INTO POPULARITY (DOCUMENTID, NUM_OF_ACCESSES ) "
            + "SELECT DOCUMENTID, COUNT(DOCUMENTID) AS NUM_OF_ACCESSES FROM ACCESSES GROUP BY DOCUMENTID ORDER BY COUNT(DOCUMENTID) DESC");
       
      List<Popularity> popularities = new ArrayList<Popularity>();
      repository.findAll().forEach(popularity -> popularities.add(popularity));
      return popularities;
   }
}