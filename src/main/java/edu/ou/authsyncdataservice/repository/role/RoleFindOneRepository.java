package edu.ou.authsyncdataservice.repository.role;

import edu.ou.authsyncdataservice.data.entity.RoleDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoleFindOneRepository extends BaseRepository<Integer, RoleDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer roleId) {
        // do nothing
    }

    /**
     * Find role by id
     *
     * @param roleId role id
     * @return role
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected RoleDocument doExecute(Integer roleId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(roleId)
                ),
                RoleDocument.class
        );
    }

    @Override
    protected void postExecute(Integer roleId) {
        // do nothing
    }
}
