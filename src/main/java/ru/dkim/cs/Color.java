package ru.dkim.cs;

public enum Color {
    X("x"),
    EMPTY(" ");

    private final String c;

    Color(String c) {
        this.c = c;
    }

    public String getC() {
        return c;
    }
}
