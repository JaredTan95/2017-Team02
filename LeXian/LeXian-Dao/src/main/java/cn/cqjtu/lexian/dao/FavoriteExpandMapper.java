package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Favorite;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 收藏业务扩展
 * 基于用户操作
 * Created by allen on 2017/7/1.
 */
@Component
public interface FavoriteExpandMapper {
    List<Favorite> selectAllByUserId(String userId);
}
