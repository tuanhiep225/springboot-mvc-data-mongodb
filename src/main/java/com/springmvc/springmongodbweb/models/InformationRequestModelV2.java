/**
 * 
 */
package com.springmvc.springmongodbweb.models;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import com.springmvc.springmongodbweb.models.InformationRequestModel.InformationRequestModelBuilder;
import com.springmvc.springmongodbweb.models.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuanhiep225
 *
 */
@Document(collection = "InformationRequestModel-V2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@CompoundIndex(def = "{'messid':1, 'bot_id':1, 'campaign':1}", name = "compound_index", unique = true)
public class InformationRequestModelV2 extends BaseEntity<String>{
	private String id;
	private String hoten;
	private String thamgialuc;
	private String bot_id;
	private String bot_token;
	private String bot_link;
	private String messid;
	private String ref;
	private String linkgioithieu;
	private String campaign;
	@Override
	public String getId() {
		return this.id;
	}
	@Override
	public void setId(String id) {
		this.id= id;
	}
}

