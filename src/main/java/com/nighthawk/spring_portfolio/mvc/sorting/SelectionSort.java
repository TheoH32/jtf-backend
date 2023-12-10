package com.nighthawk.spring_portfolio.mvc.sorting;

public class SelectionSort extends Sort {

    public SelectionSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        startTimer();
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
        stopTimer();
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
