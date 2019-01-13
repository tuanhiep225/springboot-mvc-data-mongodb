/**
 * 
 */
package com.springmvc.springmongodbweb.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.springmvc.springmongodbweb.models.Province.ProvinceBuilder;
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
@Builder
@Document(collection="district")
public class District extends BaseEntity<String>{
	private String id;
	private String districtid;
	private String provinceid;
	private String name;
	private String type;
	private String location;

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(String id) {
		this.id=id;
		
	}

}

