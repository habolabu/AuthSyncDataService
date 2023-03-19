package edu.ou.authsyncdataservice.listener.role;

import edu.ou.authsyncdataservice.common.mapper.RoleDocumentMapper;
import edu.ou.authsyncdataservice.data.entity.RoleDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.auth.internal.role.RoleAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RoleAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<RoleDocument, RoleDocument> roleAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new role
     *
     * @param role role info
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoleAddQueueI.QUEUE})
    public Object execute(Object role) {
        final Map<String, Object> dataMap = (Map<String, Object>) messageConverter.fromMessage((Message) role);
        final RoleDocument roleDocument = RoleDocumentMapper.INSTANCE.fromMap(dataMap);

        return roleAddRepository.execute(roleDocument);
    }
}
