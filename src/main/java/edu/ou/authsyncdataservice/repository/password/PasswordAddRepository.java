package edu.ou.authsyncdataservice.repository.password;

import edu.ou.authsyncdataservice.data.entity.PasswordDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PasswordAddRepository extends BaseRepository<PasswordDocument, PasswordDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(PasswordDocument input) {
        // do nothing
    }

    /**
     * Save new password
     *
     * @param passwordDocument password
     * @return password
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected PasswordDocument doExecute(PasswordDocument passwordDocument) {
        return mongoTemplate.save(passwordDocument);
    }

    @Override
    protected void postExecute(PasswordDocument input) {

    }
}
