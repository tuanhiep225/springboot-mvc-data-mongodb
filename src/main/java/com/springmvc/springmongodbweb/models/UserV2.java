/**
 * 
 */
package com.springmvc.springmongodbweb.models;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import com.springmvc.springmongodbweb.models.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuanhiep225
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user-v2")
@CompoundIndex(def = "{'messenger_user_id':1, 'bot_id':1, 'campaign':1}", name = "compound_index", unique = true)
public class UserV2 extends User {
	
	private String campaign;
}
