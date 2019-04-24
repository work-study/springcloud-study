package com.java.code.study.entity.result;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zouw
 * @date Created in 2:29 PM 2019/4/15
 */
@Data
@ToString
public class Shards implements Serializable {

    private static final long serialVersionUID = 5350502230003980897L;
    private Integer total;
    private Integer successful;
    private Integer skipped;
    private Integer failed;
}
