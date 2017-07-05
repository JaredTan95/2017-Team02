package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Category;
import org.springframework.stereotype.Component;

@Component
public interface CategoryMapper {
    int deleteByPrimaryKey(String categoryid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String categoryid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}