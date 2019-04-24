package com.java.code.study.entity.result;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author zouw
 * @date Created in 2:34 PM 2019/4/15
 */
@Data
@ToString
public class InnerHits implements Serializable {

    private static final long serialVersionUID = -6595113623831646340L;
    private String _index;
    private String _type;
    private String _id;
    private Integer _score;
    HashMap<String,Object> _source;
}
