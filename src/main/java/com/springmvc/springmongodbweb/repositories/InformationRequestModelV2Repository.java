package com.springmvc.springmongodbweb.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.springmongodbweb.models.InformationRequestModelV2;

@Repository
public interface InformationRequestModelV2Repository extends BaseRepository<InformationRequestModelV2, String>{
    @Query(value = "{'ref': ?0}")
    InformationRequestModelV2 getInformationRequestModelByRef(String ref);
    
    @Query(value = "{'linkgioithieu': ?0, 'isDelete':false}")
    InformationRequestModelV2 getInformationRequestModelByLinkgioithieu(String link);
}
