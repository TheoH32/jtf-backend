package com.nighthawk.spring_portfolio.mvc.sorting;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.*;

public abstract class Sort {

    protected int[] array;
    protected long startTime;
    protected long endTime;

    public Sort(int[] array) {
        this.array = array;
    }

    public abstract void sort();

    public long getSortTime() {
        return endTime - startTime;
    }

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        endTime = System.currentTimeMillis();
    }
}

