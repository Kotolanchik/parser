package ru.kolodkin.parser.tools;

public interface OnNewDataHandler<T> {
    void OnNewData(Object sender, T e);
}
