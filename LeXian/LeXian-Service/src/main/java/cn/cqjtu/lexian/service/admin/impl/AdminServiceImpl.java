package cn.cqjtu.lexian.service.admin.impl;

import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.dao.AdminExpandMapper;
import cn.cqjtu.lexian.dao.AdminMapper;
import cn.cqjtu.lexian.model.Admin;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tanjian on 2017/7/1.
 * 后台用户服务实现
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminExpandMapper adminExpandMapper;

    @Override
    public Message Validate(Admin admin) {
        Admin isAdmin;
        try {
            isAdmin = adminExpandMapper.selectByAccount(admin.getAdminaccount());
            return isAdmin != null ? (isAdmin.getAdminpassword().equals(admin.getAdminpassword())
                    ? Message.getSuccessMessage().put("admin", isAdmin)
                    .put("token", UUidUtils.getToken()) : Message.getSuccessMessage().put("error","账户密码填求不对."))
                    : (Message.getSuccessMessage().put("error", "你mmp,你都不注册还想登录，滚！！！"));
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", e.getMessage());
        }
    }

    @Override
    public Message Update(Admin admin) {
        try {
            return adminMapper.updateByPrimaryKeySelective(admin) > 0
                    ? Message.getSuccessMessage().put("admin", admin) : Message.getFailedMessage();
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", e.getMessage());
        }
    }
}
