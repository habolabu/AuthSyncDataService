package edu.ou.authsyncdataservice.listener.account;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.auth.internal.account.AccountDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountDeleteListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> accountDeleteRepository;

    /**
     * Delete exist account id
     *
     * @param accountId account id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AccountDeleteQueueI.QUEUE})
    public Object execute(Integer accountId) {
        return accountDeleteRepository.execute(accountId);
    }
}
