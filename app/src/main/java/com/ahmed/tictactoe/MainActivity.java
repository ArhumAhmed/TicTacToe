package com.ahmed.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //boolean turn; //Flag that tracks whose turn it is.
    boolean isPlayerX=true; //Boolean to track if player turn
    boolean gameOver=false;
    boolean onePlayerMode = false;
    public static char arr[] = new char[9]; //Array to store the locations of the boxes (3x3)
    //Buttons representing the sector
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;

    TextView X;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        RotateAnimation animation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        animation.setDuration(1800);
        animation.setRepeatCount(Animation.INFINITE);
        //Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        X = findViewById(R.id.X);
        X.setAnimation(animation);
        X.startAnimation(animation);


    }

    boolean isXWinner()
    {
        if(arr[0]==arr[1] && arr[1]==arr[2] && arr[1]=='X') //First row all the same (and not empty)
        {
            return true;
        }

        else if (arr[3]==arr[4] && arr[4]==arr[5] && arr[4]=='X') //Second row all the same
        {
            return true;
        }

        else if (arr[6]==arr[7] && arr[7]==arr[8] && arr[7]=='X') //Third row all the same
        {
            return true;
        }

        else if (arr[0]==arr[3] && arr[3]==arr[6] && arr[3]=='X') //First column all the same
        {
            return true;
        }

        else if (arr[1]==arr[4] && arr[4]==arr[7] && arr[4]=='X') //Second column all the same
        {
            return true;
        }

        else if (arr[2]==arr[5] && arr[5]==arr[8] && arr[5]=='X') //Third column all the same
        {
            return true;
        }

        else if (arr[0]==arr[4] && arr[4]==arr[8] && arr[4]=='X') //Diagonal top left to bottom right the same
        {
            return true;
        }

        else if (arr[2]==arr[4] && arr[4]==arr[6] && arr[4]=='X') //Diagonal bottom left to top right the same
        {
            return true;
        }
        return false;
    }

    boolean isOWinner()
    {
        if(arr[0]==arr[1] && arr[1]==arr[2] && arr[1]=='O') //First row all the same (and not empty)
        {
            return true;
        }

        else if (arr[3]==arr[4] && arr[4]==arr[5] && arr[4]=='O') //Second row all the same
        {
            return true;
        }

        else if (arr[6]==arr[7] && arr[7]==arr[8] && arr[7]=='O') //Third row all the same
        {
            return true;
        }

        else if (arr[0]==arr[3] && arr[3]==arr[6] && arr[3]=='O') //First column all the same
        {
            return true;
        }

        else if (arr[1]==arr[4] && arr[4]==arr[7] && arr[4]=='O') //Second column all the same
        {
            return true;
        }

        else if (arr[2]==arr[5] && arr[5]==arr[8] && arr[5]=='O') //Third column all the same
        {
            return true;
        }

        else if (arr[0]==arr[4] && arr[4]==arr[8] && arr[4]=='O') //Diagonal top left to bottom right the same
        {
            return true;
        }

        else if (arr[2]==arr[4] && arr[4]==arr[6] && arr[4]=='O') //Diagonal bottom left to top right the same
        {
            return true;
        }
        return false;
    }
    boolean isGameOver()
    {
        if(arr[0]!=0 && arr[1]!=0 && arr[2]!=0 && arr[3]!=0 && arr[4]!=0 && arr[5]!=0 && arr[6]!=0 && arr[7]!=0 && arr[8]!=0)
        {
            return true;
        }
        return false;
    }
    public void onePlayer(View v)
    {
        onePlayerMode = true;
        setContentView(R.layout.activity_main);
    }

    public void twoPlayer(View v)
    {
        setContentView(R.layout.activity_main);
    }


    public void aiMove(View v)
    {

        if(!gameOver)

        {
            //X piece TextViews
            TextView x0=findViewById(R.id.x0);
            TextView x1=findViewById(R.id.x1);
            TextView x2=findViewById(R.id.x2);
            TextView x3=findViewById(R.id.x3);
            TextView x4=findViewById(R.id.x4);
            TextView x5=findViewById(R.id.x5);
            TextView x6=findViewById(R.id.x6);
            TextView x7=findViewById(R.id.x7);
            TextView x8=findViewById(R.id.x8);

            //O piece TextViews
            TextView o0=findViewById(R.id.o0);
            TextView o1=findViewById(R.id.o1);
            TextView o2=findViewById(R.id.o2);
            TextView o3=findViewById(R.id.o3);
            TextView o4=findViewById(R.id.o4);
            TextView o5=findViewById(R.id.o5);
            TextView o6=findViewById(R.id.o6);
            TextView o7=findViewById(R.id.o7);
            TextView o8=findViewById(R.id.o8);




            AI ai = new AI(); //Define the AI object
            Move bestMove = new Move(15);
            bestMove = ai.getBestMove(); //Define the best move

            if(bestMove.index == 0)
            {
                o0.setVisibility(View.VISIBLE);
                arr[0] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else if(bestMove.index==1)
            {
                o1.setVisibility(View.VISIBLE);
                arr[1] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else if(bestMove.index==2)
            {
                o2.setVisibility(View.VISIBLE);
                arr[2] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else if(bestMove.index==3)
            {
                o3.setVisibility(View.VISIBLE);
                arr[3] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else if(bestMove.index==4)
            {
                o4.setVisibility(View.VISIBLE);
                arr[4] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else if(bestMove.index==5)
            {
                o5.setVisibility(View.VISIBLE);
                arr[5] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else if(bestMove.index==6)
            {
                o6.setVisibility(View.VISIBLE);
                arr[6] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else if(bestMove.index==7)
            {
                o7.setVisibility(View.VISIBLE);
                arr[7] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else if(bestMove.index==8)
            {
                o8.setVisibility(View.VISIBLE);
                arr[8] = 'O';
                isPlayerX = !isPlayerX; //Change the turn
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Didn't find an int for bestmove",Toast.LENGTH_LONG).show();
                Log.d("Move:","BestMove: "+bestMove);
            }

            if(isGameOver() || isXWinner() || isOWinner())
            {
                String winner;
                if(isOWinner())
                {
                    winner = "O is the winner!";
                }
                else if(isXWinner())
                {
                    winner = "X is the winner!";
                }
                else
                {
                    winner="Tie!";
                }
                Toast.makeText(getApplicationContext(),winner,Toast.LENGTH_LONG).show();
                gameOver=true;
            }

        }



    }
    public void userMove(View v)
    {

        //X piece TextViews
        TextView x0=findViewById(R.id.x0);
        TextView x1=findViewById(R.id.x1);
        TextView x2=findViewById(R.id.x2);
        TextView x3=findViewById(R.id.x3);
        TextView x4=findViewById(R.id.x4);
        TextView x5=findViewById(R.id.x5);
        TextView x6=findViewById(R.id.x6);
        TextView x7=findViewById(R.id.x7);
        TextView x8=findViewById(R.id.x8);

        //O piece TextViews
        TextView o0=findViewById(R.id.o0);
        TextView o1=findViewById(R.id.o1);
        TextView o2=findViewById(R.id.o2);
        TextView o3=findViewById(R.id.o3);
        TextView o4=findViewById(R.id.o4);
        TextView o5=findViewById(R.id.o5);
        TextView o6=findViewById(R.id.o6);
        TextView o7=findViewById(R.id.o7);
        TextView o8=findViewById(R.id.o8);

        //Define buttons
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);


        if(onePlayerMode) //If the user wants to play against AI
        {

           /* if(!isPlayerX) //If it is the AI's turn
            {
                aiMove(v);
            }


            else  //If its the player's turn
            { */

           if(!gameOver)
            {
                    if(findViewById(v.getId()) == button0) //If user clicked top left
                    {
                        if(arr[0]!='X' && arr[0]!= 'O') //Check to see if space occupied. 1 check if null?
                        {
                            x0.setVisibility(View.VISIBLE); //Make X piece visible in the top left spot
                            //x0.bringToFront();
                            //Toast.makeText(getApplicationContext(),"Beep",Toast.LENGTH_LONG).show();
                            arr[0] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched

                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(findViewById(v.getId()) == button1) //If user clicked top left
                    {
                        if(arr[1]!='X' && arr[1]!= 'O') //Check to see if space occupied. 1 check if null?
                        {
                            x1.setVisibility(View.VISIBLE); //Make X piece visible in the top left spot
                            arr[1] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(findViewById(v.getId()) == button2) //If user clicked top left
                    {
                        if(arr[2]!='X' && arr[2]!= 'O') //Check to see if space occupied. 1 check if null?
                        {
                            x2.setVisibility(View.VISIBLE); //Make X piece visible in the top left spot
                            arr[2] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(findViewById(v.getId()) == button3) //If user clicked top left
                    {
                        if(arr[3]!='X' && arr[3]!= 'O') //Check to see if space occupied. 1 check if null?
                        {
                            x3.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[3] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(findViewById(v.getId()) == button4) //If user clicked top left
                    {
                        if(arr[4]!='X' && arr[4]!= 'O') //Check to see if space occupied. 1 check if null?
                        {
                            x4.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[4] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(findViewById(v.getId()) == button5) //If user clicked top left
                    {
                        if(arr[5]!='X' && arr[5]!= 'O') //Check to see if space occupied. 1 check if null?
                        {
                            x5.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[5] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(findViewById(v.getId()) == button6) //If user clicked top left
                    {
                        if(arr[6]!='X' && arr[6]!= 'O') //Check to see if space occupied. 1 check if null?
                        {
                            x6.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[6] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(findViewById(v.getId()) == button7) //If user clicked top left
                    {
                        if(arr[7]!='X' && arr[7]!= 'O') //Check to see if space occupied. 1 check if null?
                        {
                            x7.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[7] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(findViewById(v.getId()) == button8) //If user clicked top left
                    {
                        if(arr[8]!='X' && arr[8]!= 'O') //Check to see if space occupied. 1 check if null?
                        {

                            x8.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[8] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                            //aiMove(v); //launch the method again with turn switched
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                        }
                    }

                if(isGameOver() || isXWinner() || isOWinner())
                {
                    String winner;
                    if(isOWinner())
                    {
                        winner = "O is the winner!";
                    }
                    else if(isXWinner())
                    {
                        winner = "X is the winner!";
                    }
                    else
                    {
                        winner="Tie!";
                    }
                    Toast.makeText(getApplicationContext(),winner,Toast.LENGTH_LONG).show();
                    gameOver=true;
                }

                if((!isPlayerX) && (!gameOver))
                {
                    aiMove(v);
                }
            }

        }


        else  //If the user picks 2 player mode
        {
            if(!gameOver)
            {
                if(findViewById(v.getId()) == button0) //If user clicked top left
                {
                    if(arr[0]!='X' && arr[0]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x0.setVisibility(View.VISIBLE); //Make X piece visible in the top left spot
                            //x0.bringToFront();
                            //Toast.makeText(getApplicationContext(),"Beep",Toast.LENGTH_LONG).show();
                            arr[0] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o0.setVisibility(View.VISIBLE);
                            arr[0] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(findViewById(v.getId()) == button1) //If user clicked top left
                {
                    if(arr[1]!='X' && arr[1]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x1.setVisibility(View.VISIBLE); //Make X piece visible in the top left spot
                            arr[1] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o1.setVisibility(View.VISIBLE);
                            arr[1] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(findViewById(v.getId()) == button2) //If user clicked top left
                {
                    if(arr[2]!='X' && arr[2]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x2.setVisibility(View.VISIBLE); //Make X piece visible in the top left spot
                            arr[2] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o2.setVisibility(View.VISIBLE);
                            arr[2] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(findViewById(v.getId()) == button3) //If user clicked top left
                {
                    if(arr[3]!='X' && arr[3]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x3.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[3] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o3.setVisibility(View.VISIBLE);
                            arr[3] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(findViewById(v.getId()) == button4) //If user clicked top left
                {
                    if(arr[4]!='X' && arr[4]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x4.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[4] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o4.setVisibility(View.VISIBLE);
                            arr[4] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(findViewById(v.getId()) == button5) //If user clicked top left
                {
                    if(arr[5]!='X' && arr[5]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x5.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[5] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o5.setVisibility(View.VISIBLE);
                            arr[5] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(findViewById(v.getId()) == button6) //If user clicked top left
                {
                    if(arr[6]!='X' && arr[6]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x6.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[6] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o6.setVisibility(View.VISIBLE);
                            arr[6] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(findViewById(v.getId()) == button7) //If user clicked top left
                {
                    if(arr[7]!='X' && arr[7]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x7.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[7] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o7.setVisibility(View.VISIBLE);
                            arr[7] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(findViewById(v.getId()) == button8) //If user clicked top left
                {
                    if(arr[8]!='X' && arr[8]!= 'O') //Check to see if space occupied. 1 check if null?
                    {
                        if(isPlayerX) //If player is X
                        {
                            x8.setVisibility(View.VISIBLE); //Make X piece visible in corresponding spot
                            arr[8] = 'X'; //Store the piece in the array
                            isPlayerX = !isPlayerX; //Change the turn
                        }

                        else //Otherwise, player is O
                        {
                            o8.setVisibility(View.VISIBLE);
                            arr[8] = 'O';
                            isPlayerX = !isPlayerX; //Change the turn
                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
                    }
                }

                if(isGameOver() || isXWinner() || isOWinner())
                {
                    String winner;
                    if(isOWinner())
                    {
                        winner = "O is the winner!";
                    }
                    else if(isXWinner())
                    {
                        winner = "X is the winner!";
                    }
                    else
                    {
                        winner="Tie!";
                    }
                    Toast.makeText(getApplicationContext(),winner,Toast.LENGTH_LONG).show();
                    gameOver=true;
                }
            }
        }


    }


}
