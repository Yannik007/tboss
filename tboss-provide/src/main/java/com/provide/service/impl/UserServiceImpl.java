package com.provide.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.provide.entity.EsUser;
import com.provide.entity.User;
import com.provide.repository.EsRepository;
import com.provide.repository.UserRepository;
import com.provide.service.UserService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.PageRequest.of;

/**
 * @Description : TODO
 * @Date : 2018/8/24  11:34
 */

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EsRepository esRepository;


    @Override
    public Page<User> getAllUser(List<String> idList,String username, Pageable pageable) {
        Specification<User> specification = (root, criteriaQuery, criteriaBuilder) -> {
            Expression<Integer> idCol = root.get("id");
            Expression<String> rewardRateCol = root.get("username");
            List<Predicate> predicates = new ArrayList<>();
            if (idList != null && idList.size() > 0) {
                predicates.add(idCol.in(idList));
            }
            if (username != null && username != "") {
                predicates.add(rewardRateCol.in(username));
            }
            return null;
        };
        Page<User> page = userRepository.findAll(specification, pageable);
        return page;
    }

    @Override
    public User getById(Integer id) {
        User user = userRepository.getOne(id);
        return user;
    }


    @Override
    public User save(User user) {
        Assert.notNull(user.getUsername(),"用户名不能为空");
        User result = userRepository.save(user);
        return result;
    }

    @Override
    public EsUser save(EsUser esUser) {
        EsUser result = esRepository.save(esUser);
        return result;
    }

    @Override
    public Page<EsUser> getAllUser(String username, Pageable pageable) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(QueryBuilders.matchPhraseQuery("username", username),
                ScoreFunctionBuilders.weightFactorFunction(1000));
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable).withQuery(functionScoreQueryBuilder).build();
        Page<EsUser> page = esRepository.search(searchQuery);
        return page;
    }
}
