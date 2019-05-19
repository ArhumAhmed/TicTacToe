package com.ahmed.tictactoe;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AI extends MainActivity{

    //char[] newBoard = arr; //Board array containing default pieces (empty)

    char human = 'X'; //By default, player is X (Change later to have flag based on user input
    char cpu = 'O';
    List<Move> availableMoves;
    Move aiMove;

    List<Move> getEmptySpaces() //Method for finding empty indices
    {
        availableMoves = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) //Iterate through all elements of board (9)
        {
            if (arr[i] != 'X' && arr[i]!= 'O') {
                availableMoves.add(new Move(i));
            }
        }

        return availableMoves;
    }

    boolean win(char[] arr, char player) {
        if (arr[0] == arr[1] && arr[1] == arr[2] && arr[1] == player) //First row all the same (and not empty)
        {
            return true;
        } else if (arr[3] == arr[4] && arr[4] == arr[5] && arr[4] == player) //Second row all the same
        {
            return true;
        } else if (arr[6] == arr[7] && arr[7] == arr[8] && arr[7] == player) //Third row all the same
        {
            return true;
        } else if (arr[0] == arr[3] && arr[3] == arr[6] && arr[3] == player) //First column all the same
        {
            return true;
        } else if (arr[1] == arr[4] && arr[4] == arr[7] && arr[4] == player) //Second column all the same
        {
            return true;
        } else if (arr[2] == arr[5] && arr[5] == arr[8] && arr[5] == player) //Third column all the same
        {
            return true;
        } else if (arr[0] == arr[4] && arr[4] == arr[8] && arr[4] == player) //Diagonal top left to bottom right the same
        {
            return true;
        } else if (arr[2] == arr[4] && arr[4] == arr[6] && arr[4] == player) //Diagonal bottom left to top right the same
        {
            return true;
        }


        return false;
    }

    void makeMove(Move move, char player)
    {
        arr[move.index] = player;
    }

    int minimax(int depth, int turn) {

        if (win(arr, human)) //If the human wins, return negative score
        {
            return -1;
        }
        if (win(arr, cpu)) //If the AI wins, return positive score
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
                    arr[move.index] = 0;
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
                    arr[move.index] = 0;
                    aiMove = move;
                    break;
                }
            }
           arr[move.index] = 0; //Reset this point
        }

            return turn==1?max:min;
        }

     Move getBestMove()
     {
         Move bestMove = new Move(1);
         bestMove.score = minimax(5,2);
         bestMove = aiMove;

         return bestMove;
     }



}