package com.rollback.shardingjdbcdemo.demo.sharding.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rollback.shardingjdbcdemo.demo.sharding.mapper.PubTableMapper;
import com.rollback.shardingjdbcdemo.demo.sharding.model.PubTable;
import com.rollback.shardingjdbcdemo.demo.sharding.service.PubTableService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author koala
 * @since 2021-06-04
 */
@Service
public class PubTableServiceImpl extends ServiceImpl<PubTableMapper, PubTable> implements PubTableService {

}
