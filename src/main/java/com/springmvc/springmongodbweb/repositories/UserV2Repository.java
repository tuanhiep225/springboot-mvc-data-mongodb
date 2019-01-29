/**
 * 
 */
package com.springmvc.springmongodbweb.repositories;

import org.springframework.data.mongodb.repository.Query;

import com.springmvc.springmongodbweb.models.UserV2;

/**
 * @author tuanhiep225
 *
 */
public interface UserV2Repository  extends BaseRepository<UserV2, String>{
	@Query("{'messenger_user_id':'?0', 'campaign':'?1', 'bot_id':'?2'}")
	UserV2 getByMessenger_user_idAndCampaignAndBot_id(String messenger_user_id,String campaign, String bot_id);

}
