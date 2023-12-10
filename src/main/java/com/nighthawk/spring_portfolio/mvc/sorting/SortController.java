package com.nighthawk.spring_portfolio.mvc.sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.leaderboard.Leaderboard;
import com.nighthawk.spring_portfolio.mvc.leaderboard.LeaderboardjpaRepository;
import com.nighthawk.spring_portfolio.mvc.person.PersonDetailsService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
//import java.util.Optional;

@RestController
@RequestMapping("/api/sort")
public class SortController {

    @PostMapping("/bubble")
    public ResponseEntity<SortResponse> bubbleSort() {
        int[] array = generateRandomArray(10000);
        BubbleSort bubbleSort = new BubbleSort(array);
        bubbleSort.sort();
        return ResponseEntity.ok(new SortResponse(array, bubbleSort.getSortTime()));
    }

    @PostMapping("/selection")
    public ResponseEntity<SortResponse> selectionSort() {
        int[] array = generateRandomArray(10000);
        SelectionSort selectionSort = new SelectionSort(array);
        selectionSort.sort();
        return ResponseEntity.ok(new SortResponse(array, selectionSort.getSortTime()));
    }

    @PostMapping("/merge")
    public ResponseEntity<SortResponse> mergeSort() {
        int[] array = generateRandomArray(10000);
        MergeSort mergeSort = new MergeSort(array);
        mergeSort.sort();
        return ResponseEntity.ok(new SortResponse(array, mergeSort.getSortTime()));
    }

    @PostMapping("/insertion")
    public ResponseEntity<SortResponse> insertionSort() {
        int[] array = generateRandomArray(10000);
        InsertionSort insertionSort = new InsertionSort(array);
        insertionSort.sort();
        return ResponseEntity.ok(new SortResponse(array, insertionSort.getSortTime()));
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return array;
    }
}
