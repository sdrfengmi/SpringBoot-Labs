package com.rollback.shardingjdbcdemo.demo.sharding.controller;


import com.rollback.shardingjdbcdemo.demo.sharding.model.PubTable;
import com.rollback.shardingjdbcdemo.demo.sharding.service.PubTableService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/pub-table")
public class PubTableController {
    @Autowired
    PubTableService pubTableService;

    @GetMapping("save")
    public void save(){
        pubTableService.save(new PubTable(){{setSource("source");setRemark("remark");}});
    }

    @GetMapping("list")
    public List<PubTable> list(){
        List<PubTable> list = pubTableService.list();
        return  list;
    }

}
