package cn.cqjtu.lexian.service.admin;

import cn.cqjtu.lexian.model.Admin;
import cn.cqjtu.lexian.model.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tanjian on 2017/7/1.
 */

public interface AdminService {
    /**
     * Validate.
     *
     * @param admin the admin
     * @return the message
     */
    Message Validate(Admin admin);

    /**
     * Update.
     *
     * @param admin the admin
     * @return the message
     */
    Message Update(Admin admin);
}
