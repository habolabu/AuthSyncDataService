package edu.ou.authsyncdataservice.listener.password;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.auth.internal.password.PasswordDeleteByAccountIdQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordDeleteByAccountIdListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> passwordDeleteByAccountIdRepository;

    /**
     * Delete exist account id
     *
     * @param accountId account id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {PasswordDeleteByAccountIdQueueI.QUEUE})
    public Object execute(Integer accountId) {
        return passwordDeleteByAccountIdRepository.execute(accountId);
    }
}
