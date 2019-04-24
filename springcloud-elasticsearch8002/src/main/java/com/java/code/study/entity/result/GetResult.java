package com.java.code.study.entity.result;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zouw
 * @date Created in 2:05 PM 2019/4/15
 */
@Data
@ToString
public class GetResult {
    private Integer took;
    private Boolean timed_out;
    private Shards _shards;

    private Hits hits;

    public List<Map<String,Object>> getSourceByResult() {
        if (this.getHits() == null||CollectionUtils.isEmpty(this.getHits().getHits())) {
            return new ArrayList<>();
        }

        List<InnerHits> innerHitsList = this.getHits().getHits();
        List<Map<String, Object>> mapList = innerHitsList.stream().filter(x -> MapUtils.isNotEmpty(x.get_source())).map(InnerHits::get_source).collect(Collectors.toList());
        return CollectionUtils.isEmpty(mapList)?new ArrayList<>():mapList;
    }
}