package com.dtv.models;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 14.08.14
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
public class PaginationModel {


    private int pageIndex;
    private int start;
    private int max;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
