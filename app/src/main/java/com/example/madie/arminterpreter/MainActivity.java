package com.example.madie.arminterpreter;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText instructionET;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARMap.lookupInstruction("ADD").display();
        ARMap.init();

    }

    public void registersButtonPressed(View v)
    {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }

    public void executeButtonPressed(View v)
    {
        //Read the instruction from the instructionET and appropriately execute it
        //For example, if instructionET contained: ADD X0, X1, X2
        //your code should grab the value from X1 and X2, add them together, and store the result in X0

        instructionET = (EditText) findViewById(R.id.instructionET);

        String instruction = instructionET.toString();

        Register X0 = new Register("X0");
        Register X1 = new Register("X1");
        Register X2 = new Register("X2");

        Character zero = instruction.charAt(0);
        Character one = instruction.charAt(1);
        Character two = instruction.charAt(2);

        if(zero.equals("A") && one.equals("D") && two.equals("D"))
        {
            int answer = X1.getValue() + X1.getValue();
            Toast.makeText(this, "Your X0 result is: " + answer, Toast.LENGTH_SHORT).show();
        }


    }


}