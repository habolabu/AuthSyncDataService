package edu.ou.authsyncdataservice.repository.accountSetting;

import edu.ou.authsyncdataservice.data.entity.AccountSettingDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountSettingSaveAllRepository extends BaseRepository<List<AccountSettingDocument>, Void> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(List<AccountSettingDocument> input) {
        // do nothing
    }

    /**
     * Save list of account settings
     *
     * @param accountSettingDocuments list of account setting
     * @return void
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Void doExecute(List<AccountSettingDocument> accountSettingDocuments) {
        accountSettingDocuments.forEach(mongoTemplate::save);
        return null;
    }

    @Override
    protected void postExecute(List<AccountSettingDocument> input) {
        // do nothing
    }
}
