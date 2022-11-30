package com.frkl.hwjun;

/**
 *
 * @author klimci
 */

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopularityService {
   @Autowired
   PopularityRepository repository;
      
   public List<Popularity> getAllPopularities(){      
      List<Popularity> popularities = new ArrayList<Popularity>();
      repository.findAll().forEach(popularity -> popularities.add(popularity));
      return popularities;
   }
}