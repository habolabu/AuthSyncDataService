package edu.ou.authsyncdataservice.repository.accountSetting;

import edu.ou.authsyncdataservice.data.entity.AccountSettingDocument;
import edu.ou.authsyncdataservice.data.entity.AccountSettingDocumentPK;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountSettingUpdateRepository extends BaseRepository<AccountSettingDocument, AccountSettingDocument> {
    private final IBaseRepository<AccountSettingDocumentPK, AccountSettingDocument> accountSettingFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(AccountSettingDocument input) {
        // do nothing
    }

    /**
     * Update exist account setting document
     *
     * @param accountSettingDocument account setting
     * @return updated account setting
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected AccountSettingDocument doExecute(AccountSettingDocument accountSettingDocument) {
        final AccountSettingDocument existAccountSettingDocument =
                accountSettingFindOneRepository.execute(
                        new AccountSettingDocumentPK()
                                .setAccountId(accountSettingDocument.getAccountId())
                                .setPermissionId(accountSettingDocument.getPermissionId())
                                .setRoleId(accountSettingDocument.getRoleId())
                );

        assert existAccountSettingDocument != null;
        accountSettingDocument.setId(existAccountSettingDocument.getId());

        return mongoTemplate.save(accountSettingDocument);
    }

    @Override
    protected void postExecute(AccountSettingDocument input) {
        // do nothing
    }
}
