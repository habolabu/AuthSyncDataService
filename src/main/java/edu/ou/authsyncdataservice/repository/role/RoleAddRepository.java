package edu.ou.authsyncdataservice.repository.role;

import edu.ou.authsyncdataservice.data.entity.RoleDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoleAddRepository extends BaseRepository<RoleDocument, RoleDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(RoleDocument areaDocument) {
        // do nothing
    }

    /**
     * Add new role
     *
     * @param roleDocument role
     * @return role
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected RoleDocument doExecute(RoleDocument roleDocument) {
        return mongoTemplate.save(roleDocument);
    }

    @Override
    protected void postExecute(RoleDocument areaDocument) {
        // do nothing
    }
}
