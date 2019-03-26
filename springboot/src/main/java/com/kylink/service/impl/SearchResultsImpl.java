package com.kylink.service.impl;

import com.kylink.service.SearchResults;

import java.util.List;

public class SearchResultsImpl<T> implements SearchResults<T> {
    /**
     * Number of total results
     */
    private long numResults;

    /**
     * List of results
     */
    private List<T> results;

    public SearchResultsImpl(List<T> all) {
        setNumResults(all.size());
        setResults(all);
    }

    public SearchResultsImpl(List<T> page, long total) {
        setNumResults(total);
        setResults(page);
    }

    public long getNumResults() {
        return numResults;
    }

    public void setNumResults(long numResults) {
        this.numResults = numResults;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
