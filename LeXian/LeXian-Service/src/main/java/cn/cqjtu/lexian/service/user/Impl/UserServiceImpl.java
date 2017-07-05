package cn.cqjtu.lexian.service.user.Impl;

import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.dao.ShopcartMapper;
import cn.cqjtu.lexian.dao.UserExpandMapper;
import cn.cqjtu.lexian.dao.UserMapper;
import cn.cqjtu.lexian.model.Shopcart;
import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.UserExpand;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Created by allen on 2017/7/1.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserExpandMapper userExpandMapper;

    @Autowired
    private ShopcartMapper shopcartMapper;

    @Autowired
    private UserMapper userMapper;



    @Override
    public Message register(UserExpand userExpand) {
        if (userExpand==null){
            return Message.getSuccessMessage().put("error","不合法的注册信息");
        }
        try {
            if(!userExpand.getRePassword().equals(userExpand.getUserpassword())){
                return Message.getSuccessMessage().put("error","密码信息不正确");
            }

            Message userByuserAccount = findUserByuserAccount(userExpand.getUseraccount());
            if(userByuserAccount.getMap().get("user")!=null){
                return Message.getSuccessMessage().put("error","用户名存在");
            }

            String spid=UUidUtils.uuid().replaceAll("-","");
            userExpand.setUserid(spid);
            //userExpand.setShopcartid(spid);


            Shopcart shopcart=new Shopcart();
            shopcart.setShopcartid(spid);
            //shopcart.setUserid(spid);
            shopcart.setProductionKindAmount(1);

            int i = userMapper.insert(userExpand);
            if(i<0){
                return Message.getSuccessMessage().put("error","注册信息不合法");
            }

            int num_sp=shopcartMapper.insert(shopcart);
            if (num_sp<=0){
                return Message.getSuccessMessage().put("error","服务器忙~");
            }

            shopcart.setUserid(spid);
            shopcartMapper.updateByPrimaryKey(shopcart);
            userExpand.setShopcartid(spid);
            userMapper.updateByPrimaryKey(userExpand);

            userExpand.setRePassword("");
            userExpand.setUserpassword("");
            userExpand.setVerificationCode("");
            return  Message.getSuccessMessage().put("user",userExpand);
        }catch (Exception e){
            return Message.getSuccessMessage().put("error","注册信息不合法");
        }
    }

    @Override
    public Message login(User user) {
        User userq;
        try {
            userq = userExpandMapper.findUserByAccount(user.getUseraccount());
            return userq != null ? (user.getUserpassword().equals(userq.getUserpassword())
                    ? Message.getSuccessMessage().put("user", userq)
                    .put("token", UUidUtils.getToken()) : Message.getSuccessMessage().put("error","账户密码不对."))
                    : (Message.getFailedMessage().put("error", "你mmp,你都不注册还想登录，滚！！！"));
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", e.getMessage());
        }
    }

    @Override
    public Message findUserByuserAccount(String userAccount) {
        User user= userExpandMapper.findUserByAccount(userAccount);
        if(user==null){
            return  Message.getSuccessMessage().put("error","不存在的用户");
        }
        return Message.getSuccessMessage().put("user",user);
    }
}
