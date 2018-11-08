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

    private EditText instructionET;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARMap.lookupInstruction("ADD").display();
        ARMap.init();
        this.instructionET = (EditText) findViewById(R.id.instructionET);
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

        Instruction i = new Instruction(instructionET.getText().toString());
        i.execute();
        Toast.makeText(this, "Execution Complete", Toast.LENGTH_SHORT).show();



    }


}