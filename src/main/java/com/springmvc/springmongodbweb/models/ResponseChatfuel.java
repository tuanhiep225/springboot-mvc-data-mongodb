/**
 * 
 */
package com.springmvc.springmongodbweb.models;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuanhiep225
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseChatfuel {
	private List<Text> messages;
	private Map<String, String> set_attributes;
	private List<String> redirect_to_blocks;
	
}
