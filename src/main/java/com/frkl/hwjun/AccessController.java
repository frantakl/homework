package com.frkl.hwjun;

/**
 *
 * @author klimci
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

	@Autowired
	AccessRepository accessRepository;
             
	@PostMapping("/adac")
	public ResponseEntity<Access> createAccessItem(@RequestBody Access Access) {
		try {
			Access _access = accessRepository
					.save(new Access(Access.getTimeOfAccess(), Access.getDocumentID(),Access.getUserID()));
			return new ResponseEntity<>(_access, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
