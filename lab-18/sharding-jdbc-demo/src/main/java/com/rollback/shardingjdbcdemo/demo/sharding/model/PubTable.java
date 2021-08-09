package com.rollback.shardingjdbcdemo.demo.sharding.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author koala
 * @since 2021-06-04
 */
@Data
@TableName("pub_table")
public class PubTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String source;

    private String remark;


}
