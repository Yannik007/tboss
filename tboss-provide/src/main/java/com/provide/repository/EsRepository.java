package com.provide.repository;

import com.provide.entity.EsUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author : tboss
 * @description : esRepository
 * @date : 2018/11/9
 */


public interface EsRepository extends ElasticsearchRepository<EsUser, Long> {

}
