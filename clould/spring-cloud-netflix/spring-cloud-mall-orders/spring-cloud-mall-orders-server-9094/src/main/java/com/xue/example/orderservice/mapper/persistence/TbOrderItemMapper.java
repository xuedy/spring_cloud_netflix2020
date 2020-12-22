package com.xue.example.orderservice.mapper.persistence;

import com.xue.example.orderservice.mapper.entitys.TbOrderItem;
import com.xue.example.orderservice.mapper.entitys.TbOrderItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TbOrderItemMapper {
    long countByExample(TbOrderItemExample example);

    int deleteByExample(TbOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    List<TbOrderItem> selectByExample(TbOrderItemExample example);

    TbOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOrderItem record, @Param("example") TbOrderItemExample example);

    int updateByExample(@Param("record") TbOrderItem record, @Param("example") TbOrderItemExample example);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);
}