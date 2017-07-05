package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AddressExpandMapper {
    List<Address> selectByUserId(String userId);

    Address findAddressByAddressId(String addressId);

    int addAddress(Address address);

}