/**
 * 
 */
package com.springmvc.springmongodbweb.models;
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
public class RequestInviteModel  {
	private String hoten;
	private String thamgialuc;
	private String bot_id;
	private String bot_token;
	private String bot_link;
	private String messid;
	private String ref;
	private String linkgioithieu;
	@Override
	public String toString() {
		return "RequestInviteModel [hoten=" + hoten + ", thamgialuc=" + thamgialuc + ", bot_id=" + bot_id
				+ ", bot_token=" + bot_token + ", bot_link=" + bot_link + ", messid=" + messid + ", ref=" + ref + "]";
	}
	
	
}
