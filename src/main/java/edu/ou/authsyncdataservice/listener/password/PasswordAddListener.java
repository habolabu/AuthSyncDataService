package edu.ou.authsyncdataservice.listener.password;

import edu.ou.authsyncdataservice.common.mapper.PasswordDocumentMapper;
import edu.ou.authsyncdataservice.data.entity.PasswordDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.auth.internal.password.PasswordAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PasswordAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<PasswordDocument, PasswordDocument> passwordAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new password
     *
     * @param password input of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {PasswordAddQueueI.QUEUE})
    public Object execute(Object password) {
        final Map<String, Object> dataMap = (Map<String, Object>) messageConverter.fromMessage((Message) password);
        final PasswordDocument passwordDocument = PasswordDocumentMapper.INSTANCE.fromMap(dataMap);

        return passwordAddRepository.execute(passwordDocument);
    }
}
