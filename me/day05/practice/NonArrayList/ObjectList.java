package me.day05.practice.NonArrayList;

public interface ObjectList<T> {
    void add(T t);

    void grow();

    int size();

}
