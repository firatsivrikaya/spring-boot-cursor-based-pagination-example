package com.firatsivrikaya.cursorbased.paging.extractor;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;


public class IdBasedCursorTokenExtractor {
    public static <T> Pair<Long, List<T>> extract(List<T> list, int size, Function<T, Long> nextPageTokenFunction) {
        if (CollectionUtils.isEmpty(list)){
            return Pair.of(null, Collections.emptyList());
        }

        int listSize = list.size();
        if (size >= listSize){
            return Pair.of(null, list);
        }

        T lastItem = list.get(listSize - 1);
        Long nextPageToken = nextPageTokenFunction.apply(lastItem);
        List<T> subList = list.subList(0, size);
        return Pair.of(nextPageToken, subList);
    }
}
