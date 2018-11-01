package com.example.aweso.arminterpreter;

public class ARMap
{
    private static String[] instructions = {"ADD", "SUB"};
    private static int[] instructionMappings = {1112, 1624};
    private static String[] registers = new String[31];
    private static String[] registerBinMap = new String[31];

    public static void init()
    {
        for(int i = 0; i < 32; i++)
        {
            ARMap.registers[i] = "X" + i;
            ARMap.registerBinMap[i] = ARMap.decimalTo5BitBinary(i);
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
        return null;  //we assume every mapping is found, so this should never get hit!
    }

    private static String decimalTo5BitBinary(int opCode)
    {
        return ARMap.decimalToNBitBinary(opCode, 5);
    }

    private static String decimalTo11BitBinary(int opCode)
    {
        return ARMap.decimalToNBitBinary(opCode, 11);
    }

    private static String decimalToNBitBinary(int opCode, int numBits)
    {
        String answer = "";
        while(opCode > 0)
        {
            answer = (opCode%2) + answer;
            opCode /= 2;
        }

        for(int i = answer.length(); i < numBits; i++)
        {
            answer = 0 + answer;
        }
        return answer;
    }
}
