/**
 * 
 */
package com.springmvc.springmongodbweb.service;

import com.springmvc.springmongodbweb.models.InformationRequestModelV2;

/**
 * @author tuanhiep225
 *
 */
public interface InformationRequestModelV2Service {
	public InformationRequestModelV2 getInformationRequestModelByRef(String ref);
	
	public InformationRequestModelV2 add(InformationRequestModelV2 entity);
	
	public InformationRequestModelV2 getInformationRequestModelByLinkgioithieu(String link); 
}