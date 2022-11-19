package com.frkl.hwjun;

/**
 *
 * @author klimci
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularityRepository extends CrudRepository<Popularity, Integer> {

}