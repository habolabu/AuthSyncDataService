package edu.ou.authsyncdataservice.repository.account;

import edu.ou.authsyncdataservice.data.entity.AccountDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountAddRepository extends BaseRepository<AccountDocument, AccountDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(AccountDocument input) {
        // do nothing
    }

    /**
     * Save new account
     *
     * @param accountDocument account
     * @return account
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected AccountDocument doExecute(AccountDocument accountDocument) {
        return mongoTemplate.save(accountDocument);
    }

    @Override
    protected void postExecute(AccountDocument input) {

    }
}
