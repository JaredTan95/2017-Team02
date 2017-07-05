package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.UserOrder;
import cn.cqjtu.lexian.model.UserOrderKey;
import org.springframework.stereotype.Component;

@Component
public interface UserOrderMapper {
    int deleteByPrimaryKey(UserOrderKey key);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(UserOrderKey key);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);
}