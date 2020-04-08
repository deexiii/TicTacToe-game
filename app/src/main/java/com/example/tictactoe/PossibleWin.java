package com.example.tictactoe;

class PossibleWin {
    private int one;
    private int two;
    private int three;

    PossibleWin(int one, int two, int three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    int getOne() {
        return one;
    }

    int getTwo() {
        return two;
    }

    int getThree() {
        return three;
    }
}