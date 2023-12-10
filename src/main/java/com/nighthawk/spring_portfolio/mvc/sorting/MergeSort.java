package com.nighthawk.spring_portfolio.mvc.sorting;

public class MergeSort extends Sort {

    public MergeSort(int[] array) {
        super(array);
    }

    public void sort(int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            sort(low, middle);
            sort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    @Override
    public void sort() {
        startTimer();
        sort(0, array.length - 1);
        stopTimer();
    }

    private void merge(int low, int middle, int high) {
        int leftLength = middle - low + 1;
        int rightLength = high - middle;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = array[low + i];
        }
        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = array[middle + 1 + i];
        }

        int i = 0, j = 0, k = low;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
