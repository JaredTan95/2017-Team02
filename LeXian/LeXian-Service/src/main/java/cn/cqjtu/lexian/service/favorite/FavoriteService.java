package cn.cqjtu.lexian.service.favorite;

import cn.cqjtu.lexian.model.Favorite;
import cn.cqjtu.lexian.model.message.Message;

/**
 * Created by tanjian on 2017/7/1.
 */
public interface FavoriteService {
    /**
     * 添加至收藏夹.
     *
     * @param favorite the favorite
     * @return the message
     */
    Message add2Favorite(Favorite favorite);

    /**
     * 查找所有收藏
     *
     * @param favorite
     * @return the message
     */
    Message findAllMyFavorite(Favorite favorite);

    /**
     * 查找一个收藏信息
     *
     * @param favorite
     * @return the message
     */
    Message findOneMyFavorite(Favorite favorite);

    /**
     * 删除一个收藏信息
     *
     * @param favorite
     * @return the message
     */
    Message delOneMyFavorite(Favorite favorite);

    /**
     * 删除所有收藏信息
     *
     * @param favorite
     * @return the message
     */
    Message delAllMyFavorite(Favorite favorite);
}
