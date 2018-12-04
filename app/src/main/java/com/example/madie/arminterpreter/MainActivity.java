package com.example.madie.arminterpreter;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;
import java.lang.Character;

public class MainActivity extends AppCompatActivity
{
    private EditText instructionET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARMap.init();

        this.instructionET = (EditText)this.findViewById(R.id.instructionET);
        //ARMap.lookupInstruction("ADD").display();
    }

    public void registersButtonPressed(View v)
    {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }

    public void memoryButtonPressed(View v)
    {
        Intent i = new Intent(this, MemoryScreen.class);
        this.startActivity(i);
    }

    public void executeButtonPressed(View v)
    {
        ArrayList<String> commands = new ArrayList<String>();
        String temp = "";

        //puts all of the commands separately in an array list
        for(int i = 0; i < instructionET.length(); i++)
        {
//            if(instructionET.getText().toString().charAt(i).isLetter() || instructionET.getText().toString().charAt(i).isDigit() || instructionET.getText().toString().charAt(i).isWhiteSpace())
//            {
//                temp += instructionET.getText().toString().charAt(i);
//            }

            if(instructionET.getText().toString().charAt(i) == '\n')
            {
                commands.add(temp);
                temp = "";
            }

            else
            {
                temp += instructionET.getText().toString().charAt(i);
            }
        }

        //Make each command an instruction
        for(int i = 0; i < commands.size(); i++)
        {
            Instruction inst = new Instruction(commands.get(i)); //"ADD X0,X1,    X2"
            inst.execute();
        }

        Toast.makeText(this, "Execution Complete", Toast.LENGTH_SHORT).show();


        //Read the instruction from the instructionET and appropriately
        //execute it
        //For example, if instructionET contained: ADD X0, X1, X2
        //Your code should grab the value from X1 and X2, add them
        //together, and store the result in X0
//        Instruction i = new Instruction(this.instructionET.getText().toString()); //"ADD X0,X1,    X2"
//        i.execute();
//        Toast.makeText(this, "Execution Complete", Toast.LENGTH_SHORT).show();
    }
}