package com.example.aweso.arminterpreter;

public class ARMap
{
    private static String[] instructions = {"ADD", "SUB"};
    private static int[] instructionMappings = {1112, 1624};
    rivate static String[] registers = {"X1","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2","X2"};
//finish mapping here
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
        return null;  //we assume every mapping is found, so this should never get hit!
    }

    private static String decimalTo11BitBinary(int opCode)
    {
        String answer = "";
        while(opCode > 0)
        {
            answer = (opCode%2) + answer;
            opCode /= 2;
        }

        for(int i = answer.length(); i < 11; i++)
        {
            answer = 0 + answer;
        }
        return answer;
    }
}
