package com.java.code.study.entity.result;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zouw
 * @date Created in 2:32 PM 2019/4/15
 */
@Data
@ToString
public class Hits implements Serializable {
    private static final long serialVersionUID = 8993753257911500672L;
    private Integer total;
    private Integer max_score;

    List<InnerHits> hits;
}
