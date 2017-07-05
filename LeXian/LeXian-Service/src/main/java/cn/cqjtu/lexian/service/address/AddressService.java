package cn.cqjtu.lexian.service.address;

import cn.cqjtu.lexian.model.Address;
import cn.cqjtu.lexian.model.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tanjian on 2017/7/1.
 */

public interface AddressService {
    /**
     * 查找一个用户的所有收货地址
     *
     * @param address
     * @return
     */
    Message findUserAllAddress(Address address);

    /**
     * 查找一个收货地址
     *
     * @param address the address
     * @return the message
     */
    Message findOneAddress(Address address);

    /**
     * 更新一个收货地址
     *
     * @param address the address
     * @return the message
     */
    Message updateOneAddress(Address address);

    /**
     * 删除一个收货地址
     *
     * @param address the address
     * @return the message
     */
    Message deleteOneAddress(Address address);



    Message addAddress(Address address);


    Message findOne(String addressId);

    Message findAll(String userId);

}
