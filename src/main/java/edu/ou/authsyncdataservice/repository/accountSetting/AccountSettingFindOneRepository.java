package edu.ou.authsyncdataservice.repository.accountSetting;

import edu.ou.authsyncdataservice.data.entity.AccountSettingDocument;
import edu.ou.authsyncdataservice.data.entity.AccountSettingDocumentPK;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountSettingFindOneRepository extends BaseRepository<AccountSettingDocumentPK, AccountSettingDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(AccountSettingDocumentPK input) {
        // do nothing
    }

    /**
     * Find account setting by id
     *
     * @param accountSettingDocumentPK account setting id
     * @return account setting
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected AccountSettingDocument doExecute(AccountSettingDocumentPK accountSettingDocumentPK) {
        return mongoTemplate.findOne(
                new Query(
                        new Criteria().andOperator(
                                List
                                        .of(
                                                Criteria.where("accountId")
                                                        .is(accountSettingDocumentPK.getAccountId()),
                                                Criteria.where("permissionId")
                                                        .is(accountSettingDocumentPK.getPermissionId()),
                                                Criteria.where("roleId")
                                                        .is(accountSettingDocumentPK.getRoleId())
                                        )
                                        .toArray(new Criteria[0])
                        )
                ),
                AccountSettingDocument.class
        );
    }

    @Override
    protected void postExecute(AccountSettingDocumentPK input) {
        // do nothing
    }
}
