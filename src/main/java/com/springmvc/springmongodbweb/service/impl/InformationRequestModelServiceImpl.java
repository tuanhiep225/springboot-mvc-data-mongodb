package com.springmvc.springmongodbweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.springmongodbweb.models.InformationRequestModel;
import com.springmvc.springmongodbweb.repositories.InformationRequestModelRepository;
import com.springmvc.springmongodbweb.service.InformationRequestModelService;

@Service
public class InformationRequestModelServiceImpl implements InformationRequestModelService{

	@Autowired
	private InformationRequestModelRepository repository;
	
	@Override
	public InformationRequestModel getInformationRequestModelByRef(String ref) {
		return repository.getInformationRequestModelByRef(ref);
	}

	@Override
	public InformationRequestModel add(InformationRequestModel entity) {
		return repository.add(entity);
	}

	/* (non-Javadoc)
	 * @see com.sodo.xmarketing.service.InformationRequestModelService#getInformationRequestModelByLinkgioithieu(java.lang.String)
	 */
	@Override
	public InformationRequestModel getInformationRequestModelByLinkgioithieu(String link) {
		return repository.getInformationRequestModelByLinkgioithieu(link);
	}

}
