package com.ketai.pms.service.impl;

import com.ketai.pms.dao.AttrAttrgroupRelationDao;
import com.ketai.pms.entity.AttrAttrgroupRelationEntity;
import com.ketai.pms.vo.AttrVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.ketai.pms.dao.AttrDao;
import com.ketai.pms.entity.AttrEntity;
import com.ketai.pms.service.AttrService;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryAttrsByCid(QueryCondition condition, Long cid, Integer type) {
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
        if (cid != null){
            wrapper.eq("catelog_id",cid);
        }
        wrapper.eq("attr_type",type);
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(condition),
                wrapper
        );

        return new PageVo(page);
    }
    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;
    @Override
    public void saveAttr(AttrVO attrVO) {
        //新增attr
        this.save(attrVO);
        Long attrId = attrVO.getAttrId();
        //新增中间表
        AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
        relationEntity.setAttrId(attrId);
        relationEntity.setAttrGroupId(attrVO.getAttrGroupId());
        this.attrAttrgroupRelationDao.insert(relationEntity);
    }

}