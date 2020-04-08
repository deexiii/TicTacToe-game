package com.example.tictactoe;

import java.util.Random;

class MoveGenerator {
    private final Random random = new Random ();
    private Board board;

    MoveGenerator(Board board){
        this.board = board;
    }
    Integer getMove(){
        if(board.Full()) {
            return null;
        }
        while(true){

            int iaMove = random.nextInt(9);
            if(board.Empty(iaMove)){
                return iaMove;
            }
        }
    }
}
