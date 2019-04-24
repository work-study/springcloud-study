package com.java.code.study.mvc.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zouw
 * @date Created in 1:29 PM 2019/4/19
 */
@Data
@ToString
public class Person implements Serializable {
    private static final long serialVersionUID = -3387004249310015094L;
    private String name;
    private Integer age;
}
