package com.rollback.shardingjdbcdemo.demo.sharding.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rollback.shardingjdbcdemo.demo.sharding.model.PubTable;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author koala
 * @since 2021-06-04
 */
@Mapper
public interface PubTableMapper extends BaseMapper<PubTable> {

}
