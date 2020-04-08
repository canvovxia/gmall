package com.ketai.pms.vo;

import com.ketai.pms.entity.AttrAttrgroupRelationEntity;
import com.ketai.pms.entity.AttrEntity;
import com.ketai.pms.entity.AttrGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author: Lenovo
 * @description:
 * @date: 2020/4/8 12:14
 */
@Data
public class AttGroupVO extends AttrGroupEntity {
    private List<AttrEntity> attrEntities;
    private List<AttrAttrgroupRelationEntity>relations;

}
