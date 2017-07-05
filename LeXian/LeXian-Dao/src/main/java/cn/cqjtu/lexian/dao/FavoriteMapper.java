package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Favorite;
import cn.cqjtu.lexian.model.FavoriteKey;
import org.springframework.stereotype.Component;

@Component
public interface FavoriteMapper {
    int deleteByPrimaryKey(FavoriteKey key);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(FavoriteKey key);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}