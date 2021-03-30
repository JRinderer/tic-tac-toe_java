package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Player xPlayer;
    Player oPLayer;
    boolean gameOver = false;
    Scanner gameScanner = new Scanner(System.in);
    Board gameBoard = new Board();


    private void askUserToMove(Player player){
        int x=0;
        int y = 0;
        System.out.println(player.getMarker() + " Players Turn");
        System.out.println("Please enter the X and Y coordinates to place your marker");
        try {
            System.out.print("Enter the X coordinates: ");
            x = gameScanner.nextInt();
            System.out.print("Enter the Y coodinates: ");
            y = gameScanner.nextInt();
            Piece tempPiece = new Piece(player.getMarker());
            gameBoard.setPieceOnSpace(tempPiece,x,y);

        }catch (Exception ex){
            System.out.println("Please enter a number only");
        }
    }

    public Game() {
        //create players
        ArrayList<Player> players = new ArrayList<>();
        this.xPlayer = new Player("x",true,false);
        this.oPLayer = new Player("o",false,false);
        players.add(xPlayer);
        players.add(oPLayer);
        Player playerHolder = new Player();
        //create board


        while (!gameOver){
            gameBoard.printBoard();
            playerHolder = Player.whosTurn(players);
            askUserToMove(playerHolder);
            gameOver = gameBoard.testGame();
            Player.flipTurn(players);
            playerHolder.setTurn(false);
        }

        gameBoard.printBoard();


    }
}
