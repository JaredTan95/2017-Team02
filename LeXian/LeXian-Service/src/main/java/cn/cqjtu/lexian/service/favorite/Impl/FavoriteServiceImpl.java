package cn.cqjtu.lexian.service.favorite.Impl;

import cn.cqjtu.lexian.dao.FavoriteExpandMapper;
import cn.cqjtu.lexian.dao.FavoriteMapper;
import cn.cqjtu.lexian.model.Favorite;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.favorite.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by allen on 2017/7/1.
 */
@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteMapper favoriteMapper;
    private FavoriteExpandMapper favoriteExpandMapper;

    @Autowired
    public void setFavoriteExpandMapper(FavoriteExpandMapper favoriteExpandMapper) {
        this.favoriteExpandMapper = favoriteExpandMapper;
    }

    @Autowired
    public void setFavoriteMapper(FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }

    @Override
    public Message add2Favorite(Favorite favorite) {
        try {
            return favoriteMapper.insert(favorite) > 0 ?
                    Message.getSuccessMessage().put("favorite", favorite)
                    : Message.getSuccessMessage().put("error", "看不懂你的骚操作～");
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", "服务器忙不过来啊～，你看->" + e.getMessage());
        }
    }

    @Override
    public Message findAllMyFavorite(Favorite favorite) {
        try {
            return Message.getSuccessMessage()
                    .put("favoriteList", favoriteExpandMapper.selectAllByUserId(favorite.getUserid()));
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", e.getMessage());
        }
    }

    @Override
    public Message findOneMyFavorite(Favorite favorite) {
        try {
            return Message.getSuccessMessage()
                    .put("favorite", favoriteMapper.selectByPrimaryKey(favorite));
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", "Are you kiding me?你确定你收藏过此商品？" + e.getMessage());
        }
    }

    @Override
    public Message delOneMyFavorite(Favorite favorite) {
        try {
            return favoriteMapper.deleteByPrimaryKey(favorite) > 0 ?
                    Message.getSuccessMessage() : Message.getFailedMessage();
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", e.getMessage());
        }
    }

    @Override
    public Message delAllMyFavorite(Favorite favorite) {
        try {
            //TODO：删除对应用户的所有收藏 ---基于用户Id
        } catch (Exception e) {
        }
        return null;
    }
}
