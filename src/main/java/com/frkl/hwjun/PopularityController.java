package com.frkl.hwjun;

/**
 *
 * @author klimci
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/acc")
public class PopularityController {
       
        @Autowired
        PopularityService popularityService;
        
        @GetMapping("/popularity")
        public List<Popularity> getAllPopularities(){
            return popularityService.getAllPopularities();
        }       
}