package com.example.demo.controller.countdownlatch;

import java.util.List;

public class MyFutureTask{
    private List<Integer> array;
    private Integer index;
    private Integer sum;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public List<Integer> getArray() {
        return array;
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "MyFutureTask{" +
                "array=" + array +
                ", index=" + index +
                ", sum=" + sum +
                '}';
    }
}
