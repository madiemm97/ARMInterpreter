package com.example.madie.arminterpreter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

public class InstructionPickerActivity extends AppCompatActivity
{
    private LinkedList<Button> theButtons = new LinkedList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_picker);

        this.theButtons.add((Button)this.findViewById(R.id.addButton));
        this.theButtons.add((Button)this.findViewById(R.id.addiButton));
        this.theButtons.add((Button)this.findViewById(R.id.subButton));
        this.theButtons.add((Button)this.findViewById(R.id.subiButton));
        this.theButtons.add((Button)this.findViewById(R.id.ldurButton));
        this.theButtons.add((Button)this.findViewById(R.id.sturButton));
        this.theButtons.add((Button)this.findViewById(R.id.movzButton));
    }

    private int indexOfButton(Button b)
    {
        for(int i = 0; i < this.theButtons.size(); i++)
        {
            if(b == this.theButtons.get(i))
            {
                return i;
            }
        }
        return -1;
    }

    public void onInstructionButtonPressed(View v)
    {
        int posOfButton = this.indexOfButton((Button)v);
        //System.out.println(ARMap.instructionSyntaxMap[posOfButton]);
        String newLine = ARMap.instructionSyntaxMap[posOfButton];
        //concatenate current instructionET with a new line and newLine, which is the string of the new instruction 
    }
}