package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Results<T> implements Serializable {

    @JsonProperty("Items")
    private T[] items;

    @JsonProperty("MoreResults")
    private boolean moreResults;

    public Results() {
        this(null, false);
    }

    public Results(T[] items, boolean moreResults) {
        this.items = items;
        this.moreResults = moreResults;
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public boolean isMoreResults() {
        return moreResults;
    }

    public void setMoreResults(boolean moreResults) {
        this.moreResults = moreResults;
    }
}
