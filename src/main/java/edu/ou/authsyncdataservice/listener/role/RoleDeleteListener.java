package edu.ou.authsyncdataservice.listener.role;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.auth.internal.role.RoleDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleDeleteListener  implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> roleDeleteRepository;

    /**
     * Delete exist role id
     *
     * @param roleId role id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoleDeleteQueueI.QUEUE})
    public Object execute(Integer roleId) {
        return roleDeleteRepository.execute(roleId);
    }
}
