package com.cleansolution.general.daoapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Paginator {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Paginator.class);
    private int firstResult;
    private int maxResults;

    // a separated comma order properties: +=ASC, -=DESC, for example: +id,-processName
    private String sort;

    public Paginator(int firstResult, int maxResults, String sort) {
        super();
        this.firstResult = firstResult;
        this.maxResults = maxResults;
        this.sort = sort;
    }

    public Paginator(int firstResult, int maxResults) {
        this.firstResult = firstResult;
        this.maxResults = maxResults;
    }

    public static Paginator createPaginator() {
        return new Paginator(-1, -1);
    }

    public int getFirstResult() {
        return firstResult;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public String getSort() {
        return sort;
    }

    public static Paginator getDefault() {
        return new Paginator(0, 1000);
    }

}
