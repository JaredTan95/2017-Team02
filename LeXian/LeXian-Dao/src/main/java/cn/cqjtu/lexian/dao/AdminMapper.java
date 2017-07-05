package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Admin;
import org.springframework.stereotype.Component;

@Component
public interface AdminMapper {
    int deleteByPrimaryKey(String adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}