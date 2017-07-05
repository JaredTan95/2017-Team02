package cn.cqjtu.lexian.service.address.Impl;

import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.dao.AddressExpandMapper;
import cn.cqjtu.lexian.dao.AddressMapper;
import cn.cqjtu.lexian.model.Address;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 收货地址服务层实现
 * Created by allen on 2017/7/1.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    AddressMapper addressMapper;
    AddressExpandMapper addressExpandMapper;//扩展DAO层

    @Autowired
    public void setAddressMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Autowired
    public void setAddressExpandMapper(AddressExpandMapper addressExpandMapper) {
        this.addressExpandMapper = addressExpandMapper;
    }

    @Override
    public Message findUserAllAddress(Address address) {
        try{
            return Message.getSuccessMessage()
                    .put("addressList",addressExpandMapper.selectByUserId(address.getUserid()));
        }catch (Exception e){
            return Message.getFailedMessage().put("message",e.getMessage());
        }
    }

    @Override
    public Message findOneAddress(Address address) {
        try{
            return Message.getSuccessMessage()
                    .put("address",addressMapper.selectByPrimaryKey(address));
        }catch (Exception e){
            return Message.getFailedMessage().put("message",e.getMessage());
        }
    }

    @Override
    public Message updateOneAddress(Address address) {
        try {
            return addressMapper.updateByPrimaryKeySelective(address)>0?
                    Message.getSuccessMessage():Message.getFailedMessage();
        }catch (Exception e){
            return Message.getFailedMessage().put("message",e.getMessage());
        }
    }

    @Override
    public Message deleteOneAddress(Address address) {
        try {
            return addressMapper.deleteByPrimaryKey(address)>0?
                    Message.getSuccessMessage():Message.getFailedMessage();
        }catch (Exception e){
            return Message.getFailedMessage().put("message",e.getMessage());
        }
    }

    @Override
    public Message addAddress(Address address) {
        if (address.getAddresspost()==null){
            address.setAddresspost("");
        }
        try {
            address.setAddressid(UUidUtils.uuid().replaceAll("-",""));
            int num=addressExpandMapper.addAddress(address);
            if(num>0){
                return Message.getSuccessMessage().put("address",address);
            }else{
                return Message.getSuccessMessage().put("error","服务器忙，请稍后重试");
            }
        }catch (Exception e) {
            return Message.getSuccessMessage().put("error","收货人信息不合法");
        }
    }

    @Override
    public Message findOne(String addressId) {
        if(addressId==null||addressId.length()<=0){
            return Message.getSuccessMessage().put("error","不存的收获信息编号");
        }else{
            Address address = addressExpandMapper.findAddressByAddressId(addressId);
            return Message.getSuccessMessage().put("address",address);
        }
    }

    @Override
    public Message findAll(String userId) {
        List<Address> addresses = addressExpandMapper.selectByUserId(userId);
        if(addresses!=null&&addresses.size()>0){
            return  Message.getSuccessMessage().put("address",addresses);
        }else{
            return  Message.getSuccessMessage().put("error","当前没有收货人");
        }
    }
}
