/**
 * 
 */
package com.springmvc.springmongodbweb.models;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestParam;

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
@Document(collection = "user")
public class User extends BaseEntity<String> {

	private String id;

	private String hoten;

	private String sodienthoai;

	private Province tinh_tp;

	private District quan_huyen;

	private Ward phuong_xa;

	private String diachi;

	private String messenger_user_id;

	private String bot_id;

	private String bot_token;

	private String bot_link;

	private String goToBlock;

	private String fb_iframe_origin;

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
