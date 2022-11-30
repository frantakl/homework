package com.frkl.hwjun;

/**
 *
 * @author klimci
 */

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

	@Autowired
	AccessRepository accessRepository;
        
        @Autowired
        JdbcTemplate jdbcTemplate;
             
	@PostMapping("/adac")
	public ResponseEntity<Access> createAccessItem(@RequestBody Access Access) {	
            try {
			Access _access = accessRepository
					.save(new Access(Access.getTimeOfAccess(), Access.getDocumentID(),Access.getUserID()));
                        
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.DATE, c.get(Calendar.DATE)-7);
       
                        jdbcTemplate.execute("TRUNCATE TABLE POPULARITY; "
                            + "DELETE FROM ACCESSES WHERE TIME_OF_ACCESS < " + c.getTimeInMillis() + "; "  
                            + "INSERT INTO POPULARITY (DOCUMENTID, NUM_OF_ACCESSES ) "
                            + "SELECT DOCUMENTID, COUNT(DOCUMENTID) AS NUM_OF_ACCESSES FROM ACCESSES GROUP BY DOCUMENTID ORDER BY COUNT(DOCUMENTID) DESC LIMIT 10");
                        
			return new ResponseEntity<>(_access, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
