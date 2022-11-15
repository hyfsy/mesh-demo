package com.hyf.cloudnative.client.entity;

public class Result<T> {

    private Integer id;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(Integer id, T data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> of(Integer id, T data) {
        return new Result<>(id, data);
    }

    public static <T> Result<T> of(T data) {
        return new Result<>(data.hashCode(), data);
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
