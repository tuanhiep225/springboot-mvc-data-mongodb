/**
 * 
 */
package com.springmvc.springmongodbweb.mysql.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springmvc.springmongodbweb.mysql.models.PhoneMail;

/**
 * @author tuanhiep225
 *
 */
@Transactional
public interface PhoneMailRepository extends JpaRepository<PhoneMail, String>{
	@Query("SELECT u FROM PhoneMail u WHERE u.uid = ?1")
	PhoneMail getByUid(String uid);
	
	@Query("SELECT u FROM PhoneMail u WHERE u.phone = ?1")
	PhoneMail getByPhone(String phone);
}
