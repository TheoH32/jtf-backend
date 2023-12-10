package com.nighthawk.spring_portfolio.mvc.sorting;

public class SortResponse {

    private int[] sortedArray;
    private long sortTime;

    public SortResponse(int[] sortedArray, long sortTime) {
        this.sortedArray = sortedArray;
        this.sortTime = sortTime;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }

    public long getSortTime() {
        return sortTime;
    }

    public void setSortTime(long sortTime) {
        this.sortTime = sortTime;
    }
}
