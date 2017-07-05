package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by tanjian on 2017/7/1.
 */
@Component
public interface AdminExpandMapper {
    Admin selectByAccount(@Param("adminAccount") String adminAccount);
}
