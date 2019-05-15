package com.ahmed.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean turn; //Flag that tracks whose turn it is.
    char arr[] = new char[9]; //Array to store the locations of the boxes (3x3)
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        if(findViewById(v.getId()) == button0) //If user clicked top left
        {
            if(arr[0]!='X' && arr[0]!= 'O') //Check to see if space occupied. 1 check if null?
            {
                x0.setVisibility(View.VISIBLE); //Make X piece visible in the top left spot
                arr[0] = 'X'; //Store the piece in the array
            }

            else
            {
                Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
            }
        }


    }
}
