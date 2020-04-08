package com.example.tictactoe;

class Player {
    private String symbol;
    private String winningText;

    Player(String symbol, String winningText){
        this.symbol = symbol;
        this.winningText = winningText;
    }
    String getWinningText(){
        return winningText;
    }
    String getSymbol(){
        return symbol;
    }
}
