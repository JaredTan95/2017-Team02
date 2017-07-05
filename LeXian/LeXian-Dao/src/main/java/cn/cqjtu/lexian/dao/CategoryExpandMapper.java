package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tanjian on 2017/7/1.
 */
@Component
public interface CategoryExpandMapper {
    List<Category> findAllCate();
}
