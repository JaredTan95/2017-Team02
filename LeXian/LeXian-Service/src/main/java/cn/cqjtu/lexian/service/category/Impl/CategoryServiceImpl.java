package cn.cqjtu.lexian.service.category.Impl;

import cn.cqjtu.lexian.common.util.CheckPropertyUtil;
import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.dao.CategoryExpandMapper;
import cn.cqjtu.lexian.dao.CategoryMapper;
import cn.cqjtu.lexian.model.Category;
import cn.cqjtu.lexian.model.message.ErrorMessage;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * Created by allen on 2017/7/1.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    CategoryMapper categoryMapper;
    CategoryExpandMapper categoryExpandMapper;

    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Autowired
    public void setCategoryExpandMapper(CategoryExpandMapper categoryExpandMapper) {
        this.categoryExpandMapper = categoryExpandMapper;
    }

    @Override
    public Message addOneCata(Category category) {
        category.setCategoryid(UUidUtils.uuid().replaceAll("-", ""));
        List<ErrorMessage> list = CheckPropertyUtil.checkProperty(Category.class, category);
        if (list.size() > 0) {
            return Message.getFailedMessage().put("error", "分类标题不对诶~");
        }
        try {
            return categoryMapper.insert(category) > 0 ?
                    Message.getSuccessMessage().put("category", category) : Message.getFailedMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return Message.getFailedMessage().put("error", e.getMessage());
        }
    }

    @Override
    public Message updateOneCate(Category category) {
        List<ErrorMessage> list = CheckPropertyUtil.checkProperty(Category.class, category);
        if (list.size() > 0) {
            return Message.getFailedMessage().put("error", "可能不存在该分类，也有可能你分类标题填错了~");
        }
        try {
            return categoryMapper.updateByPrimaryKey(category) > 0 ?
                    Message.getSuccessMessage().put("category", category)
                    : Message.getSuccessMessage().put("error", "可能不存在该分类，也有可能你分类标题填错了~");
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", e.getMessage());
        }
    }

    @Override
    public Message findOneCate(Category category) {
        Category cate;
        try {
            cate = categoryMapper.selectByPrimaryKey(category.getCategoryid());
            return cate != null ? Message.getSuccessMessage().
                    put("category", cate) : Message.getSuccessMessage()
                    .put("error", "又是什么骚操作？没找到该分类诶～");
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", "啊啊啊！我(服务器)受不鸟啦～" + e.getMessage());
        }
    }

    @Override
    public Message findAllCate() {
        try {
            return Message.getSuccessMessage()
                    .put("categoryLists", categoryExpandMapper.findAllCate());
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", "服务器太忙了，待会再来～");
        }
    }
}
