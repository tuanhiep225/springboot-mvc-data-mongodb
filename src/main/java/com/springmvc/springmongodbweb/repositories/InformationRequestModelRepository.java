/**
 * 
 */
package com.springmvc.springmongodbweb.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.springmongodbweb.models.InformationRequestModel;

/**
 * @author tuanhiep225
 *
 */
@Repository
public interface InformationRequestModelRepository extends BaseRepository<InformationRequestModel, String>{
    @Query(value = "{'ref': ?0}")
    InformationRequestModel getInformationRequestModelByRef(String ref);
    
    @Query(value = "{'linkgioithieu': ?0, 'isDelete':false}")
    InformationRequestModel getInformationRequestModelByLinkgioithieu(String link);
}
