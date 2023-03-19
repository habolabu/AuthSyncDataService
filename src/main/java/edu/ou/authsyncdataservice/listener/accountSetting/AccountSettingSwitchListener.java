package edu.ou.authsyncdataservice.listener.accountSetting;

import edu.ou.authsyncdataservice.common.mapper.AccountSettingDocumentMapper;
import edu.ou.authsyncdataservice.data.entity.AccountSettingDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.auth.internal.accountSetting.AccountSettingUpdateQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AccountSettingSwitchListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<AccountSettingDocument, AccountSettingDocument> accountSettingUpdateRepository;
    private final MessageConverter messageConverter;

    @Override
    @RabbitListener(queues = AccountSettingUpdateQueueI.QUEUE)
    public Object execute(Object accountSetting) {
        final Map<String, Object> dataMap = (HashMap<String, Object>)
                messageConverter.fromMessage((Message) accountSetting);
        final AccountSettingDocument parkingSpaceDocument = AccountSettingDocumentMapper.INSTANCE.fromMap(dataMap);

        return accountSettingUpdateRepository.execute(parkingSpaceDocument);
    }
}
