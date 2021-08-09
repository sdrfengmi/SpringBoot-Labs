package com.rollback.shardingjdbcdemo.demo.sharding.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @since 2021-05-31
 */
@Data
@TableName(value = "my_table")
public class Table0 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String source;

    private String remark;


}
