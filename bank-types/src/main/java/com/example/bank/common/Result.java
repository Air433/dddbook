package com.example.bank.common;

public class Result<T> {

    private T data;

    public Result(T data) {
        this.data = data;
    }

    public static Result success(boolean data) {
        return new Result(data);
    }
}
