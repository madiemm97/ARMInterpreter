package com.example.madie.arminterpreter;

public class ARMap
{
    private static String[] instructions = {"ADD", "SUB"};
    private static int[] instructionMappings = {1112, 1624};
    private static String[] registers = new String[31];
    private static String[] registerBinMap = new String[3];

    // {"X0", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10", "X11", "X12", "X13", "X14",
    //                "X15", "X16", "X17", "X18", "X19", "X20", "X21", "X22", "X23", "X24", "X25", "X26", "X27", "X28", "X29", "X30", "X31", "X32"}

    public ARMap()
    {
        new ARMap();
        for(int i = 0; i < 32; i++)
        {
            ARMap.registers[i] = "X" + i;
            ARMap.registerBinMap[i] = ARMap.decimalTo5BitBinary(1);
        }
    }

    public static BinaryValue lookupInstruction(String instruction)
    {
        instruction = instruction.toUpperCase();
        for(int i = 0; i < instructions.length; i++)
        {
            if(instructions[i].equals(instruction))
            {
                return new BinaryValue(decimalTo11BitBinary(instructionMappings[i]));
            }
        }

        return null; // we assume every mapping is found, so this should never happen/get hit
    }

    private static String decimalTo5BitBinary(int opCode)
    {
        return ARMap.decimalTo11BitBinary(5);
    }

    private static String decimalTo11BitBinary(int opCode)
    {
        return ARMap.decimalTo11BitBinary(11);
    }

    private static String decimalToBitBinary(int numBits)
    {
        String answer = "";
        while(numBits > 0)
        {
            answer = (numBits%2) + answer;
            numBits /= 2;
        }

        for(int i = answer.length(); i < numBits; i++)
        {
            answer = 0 + answer;
        }

        return answer;
    }
}
