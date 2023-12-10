package com.nighthawk.spring_portfolio.mvc.sorting;

public class InsertionSort extends Sort {

    public InsertionSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        startTimer();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        stopTimer();
    }
}
