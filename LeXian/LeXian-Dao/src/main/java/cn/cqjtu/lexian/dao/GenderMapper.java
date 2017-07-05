package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Gender;
import org.springframework.stereotype.Component;

@Component
public interface GenderMapper {
    int deleteByPrimaryKey(Integer genderid);

    int insert(Gender record);

    int insertSelective(Gender record);

    Gender selectByPrimaryKey(Integer genderid);

    int updateByPrimaryKeySelective(Gender record);

    int updateByPrimaryKey(Gender record);
}