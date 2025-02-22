package com.company.groomingzone.common.repository;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SearchCondition {

    private int offset;
    private int limit;
    private SingleSortCondition sortCondition;

    public int getScrollLimit() {
        return limit + 1;
    }
}
