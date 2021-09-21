// filename: project1.java
// author: Chiebuka Lebechi, UHV ID: 2034983
// modified: 16 September 2021
// assignment: COSC 4337 Project #1
// purpose: 

import java.io.*;

public class project1 
{
    // public ProcessBuilder directory(File directory)
    // {
    //     Process p = null;
    //     ProcessBuilder pb = new ProcessBuilder("do_foo.sh");
    //     pb.directory(new File("/home"));
    //     p = pb.start();
    // }

    public static void main(String[] args) throws java.io.IOException
    {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // break out with <control><C>
        while(true)
        {
            // read user input
            System.out.print("jsh> ");
            commandLine = console.readLine();

            // if user entered a return, loop again
            if (commandLine.equals(""))
            {
                continue;
            }

            // parse user input into an array
            String[] arr = commandLine.split(" ");
 
            // arr is the command that is run in a separate proocess
            ProcessBuilder pb = new ProcessBuilder(arr);
            pb.directory(new File(System.getProperty("user.dir")));
            Process process = pb.start();

             // if user entered a return, loop again
             if (arr.length == 1 && arr[0].equals("cd"))
             {
                pb.directory(new File(System.getProperty("user.home")));
             }

            // obtain input stream
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            // read the output of the process
            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
            }

            br.close();
            
        }

    } // main method

   


} // simpleShell class
