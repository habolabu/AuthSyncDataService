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
public class RoleDeleteRepository extends BaseRepository<Integer, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer roleId) {
        // do nothing
    }

    /**
     * Delete exist role
     *
     * @param roleId role id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(Integer roleId) {
        return mongoTemplate.remove(
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
