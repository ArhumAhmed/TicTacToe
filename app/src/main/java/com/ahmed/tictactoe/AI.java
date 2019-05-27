package com.ahmed.tictactoe;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AI {

    //char[] newBoard = arr; //Board array containing default pieces (empty)

    char human = 'X'; //By default, player is X (Change later to have flag based on user input
    char cpu = 'O';
    List<Move> availableMoves;
    Move aiMove;
    char[] board = MainActivity.arr;

    List<Move> getEmptySpaces() //Method for finding empty indices
    {
        availableMoves = new ArrayList<>();
        for (int i = 0; i < board.length; i++) //Iterate through all elements of board (9)
        {
            if (board[i] != 'X' && board[i]!= 'O') {
                availableMoves.add(new Move(i));
            }
        }

        return availableMoves;
    }

    boolean win(char[] board, char player) {
        if (board[0] == board[1] && board[1] == board[2] && board[1] == player) //First row all the same (and not empty)
        {
            return true;
        } else if (board[3] == board[4] && board[4] == board[5] && board[4] == player) //Second row all the same
        {
            return true;
        } else if (board[6] == board[7] && board[7] == board[8] && board[7] == player) //Third row all the same
        {
            return true;
        } else if (board[0] == board[3] && board[3] == board[6] && board[3] == player) //First column all the same
        {
            return true;
        } else if (board[1] == board[4] && board[4] == board[7] && board[4] == player) //Second column all the same
        {
            return true;
        } else if (board[2] == board[5] && board[5] == board[8] && board[5] == player) //Third column all the same
        {
            return true;
        } else if (board[0] == board[4] && board[4] == board[8] && board[4] == player) //Diagonal top left to bottom right the same
        {
            return true;
        } else if (board[2] == board[4] && board[4] == board[6] && board[4] == player) //Diagonal bottom left to top right the same
        {
            return true;
        }


        return false;
    }

    void makeMove(Move move, char player)
    {
        board[move.index] = player;
    }

    int minimax(int depth, int turn) {

        if (win(board, human)) //If the human wins, return negative score
        {
            return -1;
        }
        if (win(board, cpu)) //If the AI wins, return positive score
        {
            return 1;
        }

        List<Move> movesAvailable = getEmptySpaces(); //Get all the empty spots

        if (movesAvailable.isEmpty()) //If there are no empty spaces, return 0 (draw)
        {
            return 0;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < movesAvailable.size(); i++) {
            //create an object for each and store the index of that spot
            Move move = movesAvailable.get(i);
            if (turn == 1)
            {
                makeMove(move,human);
                int currentScore = minimax(depth + 1, 2);
                max = Math.max(currentScore, max);
                if(currentScore >= 0)
                {
                    if(depth == 0)
                    {
                        aiMove = move;
                    }
                }
                if(currentScore == 1)
                {
                    board[move.index] = 0;
                    break;
                }
                if(i == movesAvailable.size()-1 && max < 0)
                {
                    if(depth == 0)
                    {
                        aiMove = move;
                    }
                }
            }
            else if (turn == 2) {
                makeMove(move, cpu);
                int currentScore = minimax(depth + 1, 1);
                min = Math.min(currentScore, min);
                if(min == -1)
                {
                    board[move.index] = 0;
                    break;
                }
            }
           board[move.index] = 0; //Reset this point
        }

            return turn==1?max:min;
        }

     Move getBestMove()
     {
         Move bestMove = new Move(1);
         bestMove.score = minimax(0,2);
         bestMove = aiMove;

         return bestMove;
     }



}