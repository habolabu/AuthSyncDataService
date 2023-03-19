package edu.ou.authsyncdataservice.listener.account;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ou.authsyncdataservice.common.mapper.AccountDocumentMapper;
import edu.ou.authsyncdataservice.data.entity.AccountDocument;
import edu.ou.authsyncdataservice.data.entity.AccountSettingDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.auth.internal.account.AccountAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AccountAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<AccountDocument, AccountDocument> accountAddRepository;
    private final IBaseRepository<List<AccountSettingDocument>, Void> accountSettingSaveAllRepository;
    private final MessageConverter messageConverter;
    private final ObjectMapper objectMapper;

    /**
     * Add new account
     *
     * @param account account info
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AccountAddQueueI.QUEUE})
    public Object execute(Object account) {
        final Map<String, Object> dataMap = (Map<String, Object>) messageConverter.fromMessage((Message) account);
        final AccountDocument accountDocument = AccountDocumentMapper.INSTANCE.fromMap(dataMap);
        final List<AccountSettingDocument> accountSettingDocuments = objectMapper.convertValue(
                dataMap.get("accountSettingEntities"),
                new TypeReference<>() {
        });
        accountSettingSaveAllRepository.execute(accountSettingDocuments);
        return accountAddRepository.execute(accountDocument);
    }
}
