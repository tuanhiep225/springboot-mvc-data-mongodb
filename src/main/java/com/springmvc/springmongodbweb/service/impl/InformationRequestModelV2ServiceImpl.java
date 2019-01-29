package com.springmvc.springmongodbweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.springmongodbweb.models.InformationRequestModel;
import com.springmvc.springmongodbweb.models.InformationRequestModelV2;
import com.springmvc.springmongodbweb.repositories.InformationRequestModelV2Repository;
import com.springmvc.springmongodbweb.service.InformationRequestModelV2Service;

@Service
public class InformationRequestModelV2ServiceImpl implements InformationRequestModelV2Service{
	@Autowired
	private InformationRequestModelV2Repository repository;
	
	@Override
	public InformationRequestModelV2 getInformationRequestModelByRef(String ref) {
		return repository.getInformationRequestModelByRef(ref);
	}

	@Override
	public InformationRequestModelV2 add(InformationRequestModelV2 entity) {
		return repository.add(entity);
	}

	/* (non-Javadoc)
	 * @see com.sodo.xmarketing.service.InformationRequestModelService#getInformationRequestModelByLinkgioithieu(java.lang.String)
	 */
	@Override
	public InformationRequestModelV2 getInformationRequestModelByLinkgioithieu(String link) {
		return repository.getInformationRequestModelByLinkgioithieu(link);
	}
}
