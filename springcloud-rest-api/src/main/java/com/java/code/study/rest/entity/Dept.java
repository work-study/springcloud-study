package com.java.code.study.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zouw
 * @date Created in 5:00 PM 2019/4/20
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private static final long serialVersionUID = 284639820098793717L;
    private Long deptno;
    private String dname;
    private String db_source;

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDname("zz").setDb_source("ss");
    }
}
