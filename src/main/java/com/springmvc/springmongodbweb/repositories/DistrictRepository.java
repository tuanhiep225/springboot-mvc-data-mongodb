/**
 * 
 */
package com.springmvc.springmongodbweb.repositories;

import java.util.Collection;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.springmongodbweb.models.District;

/**
 * @author tuanhiep225
 *
 */
@Repository
public interface DistrictRepository extends BaseRepository<District, String>{
	@Query("{'provinceid':'?0'}")
	Collection<District> getByProvinceid(String provinceid);
	
	@Query("{'districtid':'?0'}")
	District getByDistrictid(String districtid);
}
