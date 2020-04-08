package com.ketai.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.pms.entity.ProductAttrValueEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * spu属性值
 *
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-04-03 11:04:16
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageVo queryPage(QueryCondition params);
}

