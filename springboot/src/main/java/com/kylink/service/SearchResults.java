package com.kylink.service;

import java.util.List;

public interface SearchResults<T> {

    /**
     * Get the total number of results.
     *
     * @return
     */
    public long getNumResults();

    /**
     * Get the results.
     *
     * @return
     */
    public List<T> getResults();
}
