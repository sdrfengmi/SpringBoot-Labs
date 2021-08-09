package com.rollback.shardingjdbcdemo.demo.sharding.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rollback.shardingjdbcdemo.demo.sharding.model.PubTable;
import com.rollback.shardingjdbcdemo.demo.sharding.model.Table0;
import com.rollback.shardingjdbcdemo.demo.sharding.service.PubTableService;
import com.rollback.shardingjdbcdemo.demo.sharding.service.Table0Service;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author koala
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/table0")
public class Table0Controller {
    @Autowired
    Table0Service table0Service;

    @Autowired
    PubTableService pubTableService;

    @GetMapping("save")
    public void save(int tag){
            table0Service.save(new Table0(){{setSource("source"+tag);setRemark("remark"+tag);}});
    }
    @Transactional
    @ShardingTransactionType(TransactionType.XA)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
    @GetMapping("saveByTransaction")
    public void saveByTransaction(int tag){
        for (int i = 0; i < 10; i++) {
            if(i==5){
                List list=null;
                list.add("error");
            }
            table0Service.save(new Table0(){{setSource("source"+tag);setRemark("remark"+tag);}});
        }
    }

    @GetMapping("select")
    public  PageInfo select(int pageNum,int pageSize,Long id){
//        HintManager hintManager = HintManager.getInstance();
//        hintManager.setMasterRouteOnly();
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Table0> queryWrapper=new QueryWrapper();
        if(!StringUtils.isEmpty(id)) {
            queryWrapper.eq("id", id);
        }
        queryWrapper.eq("source","source1");
        List<Table0> list = table0Service.list(queryWrapper);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @GetMapping("select1")
    public  List<Table0> select1(Long id){
        QueryWrapper<Table0> queryWrapper=new QueryWrapper();
        if(!StringUtils.isEmpty(id)) {
            queryWrapper.eq("id", id);
        }
        //queryWrapper.eq("source","source1");
        List<Table0> list = table0Service.list(queryWrapper);
        return list;
    }

    @GetMapping("saveByShardingDb")
    public void saveByShardingDb(){
        table0Service.save(new Table0(){{setSource("source");setRemark("remark");}});
        pubTableService.save(new PubTable(){{setSource("source");setRemark("remark");}});
    }


}
