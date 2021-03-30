package com.company;

import java.util.ArrayList;

public class Board {
    ArrayList<Piece> pieces = new ArrayList<Piece>();


    Square[][] squares = new Square[3][3];

    public boolean testGame(){
        String rowLineCombo="";
        boolean xWins = false;
        for(int i = 0; i<8;i++){
            switch(i){
                //across rows
                case 0:
                    rowLineCombo = squares[0][0].getPiece().name + squares[0][1].getPiece().name + squares[0][2].getPiece().name;
                    break;
                case 1:
                    rowLineCombo = squares[1][0].getPiece().name + squares[1][1].getPiece().name + squares[1][2].getPiece().name;
                    //rowLineCombo = row2.get(0) + row2.get(1) + row2.get(2);
                    break;
                case 2:
                    rowLineCombo = squares[2][0].getPiece().name + squares[2][1].getPiece().name + squares[2][2].getPiece().name;
                    //rowLineCombo = row3.get(0) + row3.get(1) + row3.get(2);
                    break;
                //across rows
                //=============
                //vertical columns
                case 3:
                    rowLineCombo = squares[0][0].getPiece().name + squares[1][0].getPiece().name + squares[2][0].getPiece().name;
                    //rowLineCombo = row1.get(0) + row2.get(0) + row3.get(0);
                    break;
                case 4:
                    rowLineCombo = squares[0][1].getPiece().name + squares[1][1].getPiece().name + squares[2][1].getPiece().name;
                    //rowLineCombo = row1.get(1) + row2.get(1) + row3.get(1);
                    break;
                case 5:
                    rowLineCombo = squares[0][2].getPiece().name + squares[1][2].getPiece().name + squares[2][2].getPiece().name;
                    //rowLineCombo = row1.get(2) + row2.get(2) + row3.get(2);
                    break;
                //vertical columns
                //===========
                //angle lines
                case 6:
                    rowLineCombo = squares[0][0].getPiece().name + squares[1][1].getPiece().name + squares[2][2].getPiece().name;
                    //rowLineCombo = row1.get(0) + row2.get(1) + row3.get(2);
                    break;
                case 7:
                    rowLineCombo = squares[0][2].getPiece().name + squares[1][1].getPiece().name + squares[2][0].getPiece().name;
                    //rowLineCombo = row1.get(2) + row2.get(1) + row3.get(0);
                    break;
            }
            //System.out.println(rowLineCombo);
            if(rowLineCombo.equals("x|x|x|")){
                return true;
            }else if(rowLineCombo.equals("o|o|o|")){
                return false;
            }
        }
        return xWins;
    }

    public void setUp(){
        for(int x = 0; x < 3; x++){
            for(int y = 0; y <3; y++){
                squares[x][y] = new Square();
                Piece emptyPiece = new Piece("-|");
                squares[x][y].setPiece(emptyPiece);
            }
        }
    }

    public void setPieceOnSpace(Piece piece, int x, int y){
        if(squares[x][y].getPiece().name.equals("-|")){
            piece.setName(piece.getName() + "|");
            squares[x][y].setPiece(piece);
        }
    }

    public ArrayList<Piece> printBoard(){
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                System.out.print(squares[x][y].getPiece().name);
                pieces.add(squares[x][y].getPiece());
            }
            System.out.println();
        }
        return pieces;
    }

    public Board() {
        this.setUp();
    }
}
