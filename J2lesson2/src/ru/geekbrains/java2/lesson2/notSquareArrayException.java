package ru.geekbrains.java2.lesson2;

public class notSquareArrayException extends RuntimeException{

    public notSquareArrayException(String s, int x, int y){
        super(s);
    }
}
