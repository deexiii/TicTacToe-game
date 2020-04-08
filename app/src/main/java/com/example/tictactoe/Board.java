package com.example.tictactoe;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;


class Board {
    private List<String> marks = new ArrayList<>(asList ("","","","","","","","",""));
    private List<PossibleWin> possibleWins = new ArrayList<>();

    Board(){
        possibleWins.add(new PossibleWin(0,1,2));
        possibleWins.add(new PossibleWin(3,4,5));
        possibleWins.add(new PossibleWin(6,7,8));

        possibleWins.add(new PossibleWin(0,3,6));
        possibleWins.add(new PossibleWin(1,4,7));
        possibleWins.add(new PossibleWin(2,5,8));

        possibleWins.add(new PossibleWin(0,4,8));
        possibleWins.add(new PossibleWin(2,4,6));

    }

    void mark(Integer position, String symbol){
        marks.set(position,symbol);
    }
    boolean won(Player player){
        for (PossibleWin possibleWin : possibleWins) {
            if(checkWin(possibleWin,player.getSymbol())){
                return true;
            }
            
        }
        return false;

    }
    void erase(){
        marks = new ArrayList<>(asList ("","","","","","","","",""));
    }

    private boolean checkWin(PossibleWin possibleWin, String playerSymbol){
        return marks.get(possibleWin.getOne()).equals(playerSymbol) &&
                marks.get(possibleWin.getTwo()).equals(playerSymbol) &&
                marks.get(possibleWin.getThree()).equals(playerSymbol);
    }

    boolean Full() {
        for (String mark : marks) {
            if(mark.isEmpty()){
                return false;
            }

        }
        return true;

    }

    boolean Empty(int iaMove) {
        return marks.get(iaMove).isEmpty();
    }
}
