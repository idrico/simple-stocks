package com.mycompany.app.utility;

/**
 * Created by Angelo Verdicchio on 17/09/2015.
 */
public class Utility {




    public  int inInt(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Integer.valueOf(inString().trim()).intValue();
            }

            catch (NumberFormatException e) {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }

    public  void inputFlush() {
        int dummy;

        try {
            while ((System.in.available()) != 0)
                dummy = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }

    public  void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }

    public  String inString() {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    finished = true;
                else if ((char) aChar != '\r')
                    s = s + (char) aChar; // Enter into string
            }

            catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    public   void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                System.out.println("************************************************************************************************************************************");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
        }
    }

    public   void pressButtonToContinue()
    {
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

}
