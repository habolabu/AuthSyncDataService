package edu.ou.authsyncdataservice.repository.role;

import edu.ou.authsyncdataservice.data.entity.RoleDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoleUpdateRepository  extends BaseRepository<RoleDocument, Object> {
    private final IBaseRepository<Integer, RoleDocument> roleFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(RoleDocument roleDocument) {
        // do nothing
    }

    /**
     * Update exist role document
     *
     * @param roleDocument input of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(RoleDocument roleDocument) {
        final RoleDocument existRoleDocument = roleFindOneRepository.execute(roleDocument.getOId());

        assert existRoleDocument != null;
        roleDocument.setId(existRoleDocument.getId());

        return mongoTemplate.save(roleDocument);
    }

    @Override
    protected void postExecute(RoleDocument roleDocument) {
        // do nothing
    }
}
