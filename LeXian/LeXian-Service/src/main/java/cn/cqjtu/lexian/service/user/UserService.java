package cn.cqjtu.lexian.service.user;

import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.UserExpand;
import cn.cqjtu.lexian.model.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tanjian on 2017/7/1.
 */

public interface UserService {
    //TODO:UserService

    Message register(UserExpand userExpand);


    Message login(User user);


    Message findUserByuserAccount(String userAccount);
}
