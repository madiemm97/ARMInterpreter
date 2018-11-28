package com.example.madie.arminterpreter;
import java.util.LinkedList;

public class Instruction
{
    private String magicTrick;
    private String destinationName;
    private LinkedList<String> theInputNames = new LinkedList<String>();

    public Instruction(String instruction)
    {
        instruction = instruction.trim();
        int locationOfFirstSpace = instruction.indexOf(' ');
        this.magicTrick = instruction.substring(0, locationOfFirstSpace);

        String theRest = instruction.substring(locationOfFirstSpace).trim(); //"X0,[X1, 4]"
        String[] parts = theRest.split(","); // ["X0", "[X1", "4]"]
        this.destinationName = parts[0].trim(); //"X0
        this.theInputNames.add(parts[1].trim()); //"X1"
        this.theInputNames.add(parts[2].trim()); //"X2"
    }

    public void execute()
    {
        if(this.magicTrick.equalsIgnoreCase("ADD"))
        {
            Register destinationRegister = ARMap.findRegisterWithName(this.destinationName);
            Register input2Register = ARMap.findRegisterWithName(theInputNames.get(0));
            Register input1Register = ARMap.findRegisterWithName(theInputNames.get(1));
            destinationRegister.setValue(input2Register.getValue() + input1Register.getValue());
        }
        else if(this.magicTrick.equalsIgnoreCase("SUB"))
        {
            //write the code to Subtract input1 from input2 and store the result in destinationName
            Register destinationRegister = ARMap.findRegisterWithName(this.destinationName);
            Register input2Register = ARMap.findRegisterWithName(theInputNames.get(0));
            Register input1Register = ARMap.findRegisterWithName(theInputNames.get(1));
            destinationRegister.setValue(input2Register.getValue() - input1Register.getValue());
        }
        else if(this.magicTrick.equalsIgnoreCase("ADDI"))
        {
            //write the code to ADD input2 to an immediate value and store the result in destinationName
            Register destinationRegister = ARMap.findRegisterWithName(this.destinationName);
            Register input2Register = ARMap.findRegisterWithName(theInputNames.get(0));
            int immediateValue = Integer.parseInt(theInputNames.get(1));
            destinationRegister.setValue(input2Register.getValue() + immediateValue);
        }
        else if(this.magicTrick.equalsIgnoreCase("SUBI"))
        {
            //write the code to Subtract the immediate value in input1 from input2 and store the result in destinationName
            Register destinationRegister = ARMap.findRegisterWithName(this.destinationName);
            Register input2Register = ARMap.findRegisterWithName(theInputNames.get(0));
            int immediateValue = Integer.parseInt(theInputNames.get(1));
            destinationRegister.setValue(input2Register.getValue() - immediateValue);
        }
        else if(this.magicTrick.equalsIgnoreCase("LDUR"))
        {
            Register destinationRegister = ARMap.findRegisterWithName(this.destinationName);
            Register baseRegister = ARMap.findRegisterWithName(theInputNames.get(0).substring(1));
            String temp = theInputNames.get(1);
            int offset = Integer.parseInt(temp.substring(0, temp.length()-1));
            int baseAddressValue = baseRegister.getValue();
            int finalMemoryBucket = baseAddressValue + offset;
            destinationRegister.setValue(ARMap.memory[finalMemoryBucket]);
        }
    }
}