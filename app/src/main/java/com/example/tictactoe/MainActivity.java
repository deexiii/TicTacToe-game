package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    public static final String PLAYER_SYMBOL = "X";
    public static final String AI_SYMBOL = "O";
    protected TextView gameResult;
    protected List<Button> buttons;
    protected Button startButton;
    protected Board board;
    protected Player player;
    protected Player Playerai;
    protected MoveGenerator moveGenerator;
    protected boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.xo_48x48);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        initializeUi();
        board = new Board();
        moveGenerator = new MoveGenerator(board);
        player = new Player(PLAYER_SYMBOL, getString(R.string.you_win));
        Playerai = new Player(AI_SYMBOL, getString(R.string.lose));
    }
    private void initializeUi(){
         gameResult = findViewById(R.id.tv_gameResult);
         initializeStartBtn();
         initializeBtns();
     }
     private void initializeStartBtn(){
         startButton = findViewById(R.id.b_start);
         startButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 cleanButtons();
                 board.erase();
                 gameOver = false;
                 gameResult.setText("");
                 enableButtons();
             }

         });
     }

    private void initializeBtns() {
        buttons = new  ArrayList<>();
        buttons.add ((Button) findViewById(R.id.b_top_left));
        buttons.add ((Button) findViewById(R.id.b_top_center));
        buttons.add ((Button) findViewById(R.id.b_top_right));
        buttons.add ((Button) findViewById(R.id.b_middle_left));
        buttons.add ((Button) findViewById(R.id.b_middle_center));
        buttons.add ((Button) findViewById(R.id.b_middle_right));
        buttons.add ((Button) findViewById(R.id.b_bottom_left));
        buttons.add ((Button) findViewById(R.id.b_bottom_center));
        buttons.add ((Button) findViewById(R.id.b_bottom_right));
        addButtonsActions();
    }

    private void addButtonsActions() {
        for (final Button button : buttons){
            button.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Button clickedButton= (Button) v;
                    movePlayer(buttons.indexOf(clickedButton),player);
                    if(!gameOver){
                        move();
                    }

                }
           });
       }
    }

    private void move() {
        Integer Move = moveGenerator.getMove();
        if(Move != null){
            markButton(buttons.get(Move), Playerai);
            markBoard(Move, Playerai);
            checkWin(Playerai);
            checkTie();
        }

    }

    private void movePlayer(int playerMove,Player player){
        markButton(buttons.get(playerMove),player);
        markBoard(playerMove,player);
        checkWin(player);
        checkTie();
    }

    private void checkTie() {
        if(!gameOver && board.Full()){
            gameOver = true;
            gameResult.setText(getString(R.string.tie));
        }
    }

    private void checkWin(Player player) {
        if (board.won(player)) {
            gameOver = true;
            gameResult.setText(player.getWinningText());
            disableButtons();
        }
    }

    private void markBoard(int position, Player player){
        board.mark(position,player.getSymbol());

    }

    private void markButton(Button clickedButton,Player player) {
        clickedButton.setText(player.getSymbol());
        clickedButton.setClickable(false);
    }
    private void disableButtons() {
        for (Button button : buttons) {
            button.setClickable(false);
            }
        }

        private void enableButtons() {
            for (Button button : buttons) {
                button.setClickable(true);
            }
        }

        private void cleanButtons() {
            for (Button button : buttons){
                button.setText("");
            }
        }
}