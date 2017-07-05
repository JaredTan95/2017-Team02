package cn.cqjtu.lexian.service.category;

import cn.cqjtu.lexian.model.Category;
import cn.cqjtu.lexian.model.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tanjian on 2017/7/1.
 */

public interface CategoryService {
    /**
     * 添加一个分类信息.
     *
     * @param category the category
     * @return the message
     */
    Message addOneCata(Category category);

    /**
     * 更新一个分类信息
     *
     * @param category the category
     * @return the message
     */
    Message updateOneCate(Category category);


    /**
     * 查询一个分类信息，只能查找标题.
     *
     * @param category the category
     * @return the message
     */
    Message findOneCate(Category category);

    /**
     * Find all cate.
     *
     * @return the message
     */
    Message findAllCate();
}
