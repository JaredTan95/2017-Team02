package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Address;
import cn.cqjtu.lexian.model.AddressKey;
import org.springframework.stereotype.Component;

@Component
public interface AddressMapper {
    int deleteByPrimaryKey(AddressKey key);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(AddressKey key);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);


}