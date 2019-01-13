package com.springmvc.springmongodbweb.service;

import com.springmvc.springmongodbweb.models.InformationRequestModel;

public interface InformationRequestModelService {
	public InformationRequestModel getInformationRequestModelByRef(String ref);
	
	public InformationRequestModel add(InformationRequestModel entity);
	
	public InformationRequestModel getInformationRequestModelByLinkgioithieu(String link); 
}
