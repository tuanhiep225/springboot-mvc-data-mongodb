/**
 * 
 */
package com.springmvc.springmongodbweb.models;
import org.springframework.data.annotation.Id;
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
@Document(collection = "InformationRequestModel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationRequestModel extends BaseEntity<String>{
	private String id;
	private String hoten;
	private String thamgialuc;
	private String bot_id;
	private String bot_token;
	private String bot_link;
	private String messid;
	private String ref;
	private String linkgioithieu;
	@Override
	public String getId() {
		return this.id;
	}
	@Override
	public void setId(String id) {
		this.id= id;
	}
}
