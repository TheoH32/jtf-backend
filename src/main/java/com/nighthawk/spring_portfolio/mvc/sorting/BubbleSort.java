package com.nighthawk.spring_portfolio.mvc.sorting;

public class BubbleSort extends Sort {

    public BubbleSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        startTimer();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    swap(i - 1, i);
                    swapped = true;
                }
            }
        }
        stopTimer();
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
