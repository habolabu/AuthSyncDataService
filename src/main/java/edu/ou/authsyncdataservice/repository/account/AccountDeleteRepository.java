package edu.ou.authsyncdataservice.repository.account;

import edu.ou.authsyncdataservice.data.entity.AccountDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountDeleteRepository extends BaseRepository<Integer, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Delete exist account
     *
     * @param accountId account id
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(Integer accountId) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("oId")
                                .is(accountId)
                ),
                AccountDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
