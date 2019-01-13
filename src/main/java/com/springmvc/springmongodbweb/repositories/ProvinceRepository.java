/**
 * 
 */
package com.springmvc.springmongodbweb.repositories;

import java.util.Collection;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.springmongodbweb.models.District;
import com.springmvc.springmongodbweb.models.Province;

/**
 * @author tuanhiep225
 *
 */
@Repository
public interface ProvinceRepository extends BaseRepository<Province, String>{
	@Query("{'provinceid':'?0'}")
	Province getByProvinceid(String provinceid);
}
