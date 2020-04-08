package com.ketai.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.pms.entity.AttrGroupEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;
import com.ketai.pms.vo.AttGroupVO;


/**
 * 属性分组
 *
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2020-04-03 11:04:16
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo queryGroupByPage(QueryCondition condition, Long catId);

    AttGroupVO queryGroupWithAttrByGid(Long gid);
}

