package com.ketai.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.pms.entity.SpuInfoDescEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * spu信息介绍
 *
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-04-03 11:04:16
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageVo queryPage(QueryCondition params);
}

