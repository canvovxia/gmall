package com.ketai.pms.dao;

import com.ketai.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-04-03 11:04:16
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
