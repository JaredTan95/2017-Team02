package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.User;
import org.springframework.stereotype.Component;

/**
 * 用户扩展接口DAO
 * Created by zjhfyq on 2017/7/2.
 */
@Component
public interface UserExpandMapper {

    User findUserByAccount(String account);

}
