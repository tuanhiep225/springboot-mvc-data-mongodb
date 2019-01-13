/**
 * 
 */
package com.springmvc.springmongodbweb.repositories;

import java.util.Collection;

import org.springframework.data.mongodb.repository.Query;

import com.springmvc.springmongodbweb.models.District;
import com.springmvc.springmongodbweb.models.Ward;

/**
 * @author tuanhiep225
 *
 */
public interface WardRepository extends BaseRepository<Ward, String>{
	@Query("{'districtid':'?0'}")
	Collection<Ward> getByDistrictid(String districtid);
	
	@Query("{'wardid':'?0'}")
	Ward getByWardid(String wardid);
}
