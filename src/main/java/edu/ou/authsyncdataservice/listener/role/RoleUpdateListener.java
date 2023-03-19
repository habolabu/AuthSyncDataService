package edu.ou.authsyncdataservice.listener.role;

import edu.ou.authsyncdataservice.common.mapper.RoleDocumentMapper;
import edu.ou.authsyncdataservice.data.entity.RoleDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.auth.internal.role.RoleUpdateQueueI;
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
public class RoleUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<RoleDocument, Object> roleUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update exist role
     *
     * @param role role
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoleUpdateQueueI.QUEUE})
    public Object execute(Object role) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) role);
        final RoleDocument roleDocument = RoleDocumentMapper.INSTANCE.fromMap(dataMap);

        return roleUpdateRepository.execute(roleDocument);
    }
}
