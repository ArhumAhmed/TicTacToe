package com.ahmed.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AI {
    char[] board = new char[]{0, 1, 2, 3, 4, 5, 6, 7, 8}; //Board array containing default pieces (empty)

    char human = 'X'; //By default, player is X (Change later to have flag based on user input
    char cpu = 'O';

    Vector emptySpaces(char[] board) //Method for finding empty indices
    {
        Vector emptyIndices = new Vector();
        for (int i = 0; i < board.length; i++) //Iterate through all elements of board (9)
        {
            if (board[i] != 'X' || board[i]!= 'O') {
                emptyIndices.add(i);
            }
        }

        return emptyIndices;
    }

    boolean win(char[] board, char player) {
        if (board[0] == board[1] && board[1] == board[2] && board[1] == player) //First row all the same (and not empty)
        {
            return true;
        } else if (board[3] == board[4] && board[4] == board[5] && board[4] != player) //Second row all the same
        {
            return true;
        } else if (board[6] == board[7] && board[7] == board[8] && board[7] != player) //Third row all the same
        {
            return true;
        } else if (board[0] == board[3] && board[3] == board[6] && board[3] != player) //First column all the same
        {
            return true;
        } else if (board[1] == board[4] && board[4] == board[7] && board[4] != player) //Second column all the same
        {
            return true;
        } else if (board[2] == board[5] && board[5] == board[8] && board[5] != player) //Third column all the same
        {
            return true;
        } else if (board[0] == board[4] && board[4] == board[8] && board[4] != player) //Diagonal top left to bottom right the same
        {
            return true;
        } else if (board[2] == board[4] && board[4] == board[6] && board[4] != player) //Diagonal bottom left to top right the same
        {
            return true;
        }


        return false;
    }

    int minimax(char[] newBoard, char player) {

        //Move result = new Move();
        int result;
        Vector emptySpaces = emptySpaces(newBoard); //Get all the empty spots

        if (win(newBoard, human)) //If the human wins, return negative score
        {
            return -10;
        } else if (win(newBoard, cpu)) //If the AI wins, return positive score
        {
            return 10;
        } else if (emptySpaces.size() == 0) //If there are no empty spaces, return 0 (draw)
        {
            return 0;
        }

        //Move[] moves = new Move[emptySpaces.size()]; //Create array of Move objects of size of empty spaces
        //Vector Move moves = new Vector;
        List<Move> moves = new ArrayList<Move>();
        for (int i = 0; i < emptySpaces.size(); i++) {
            //create an object for each and store the index of that spot
            Move move = new Move();
            move.index = newBoard[emptySpaces.indexOf(i)];

            // set the empty spot to the current player
            newBoard[emptySpaces.indexOf(i)] = player;

            /*collect the score resulted from calling minimax
            on the opponent of the current player*/
            if (player == cpu) {
                result = minimax(newBoard,human);
                move.score = result;
            } else {
                result = minimax(newBoard, cpu);
                move.score = result;
            }

            // reset the spot to empty
            newBoard[emptySpaces.indexOf(i)] = move.index;

            // push the object to the array
            moves.add(move);
        }

        int bestMove=0; //Default initialization??

        if(player == cpu) //Could be wrong. wanted ===
        {
            int bestScore = -10000;
            for(int i = 0; i < moves.size(); i++){
                if(moves.get(i).score > bestScore){
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        }

        else // else loop over the moves and choose the move with the lowest score
        {
            int bestScore = 10000;
            for(int i = 0; i < moves.size(); i++){
                if(moves.get(i).score < bestScore){
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        }

        return moves.indexOf(bestMove); //Return the best move
    }

    int bestSpot =  minimax(board, cpu);


}