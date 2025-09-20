package com.ejemplo.serverfansj;

import java.io.IOException;

public class Command {
    
    public static int validateIpmi(){

        ProcessBuilder validate = new ProcessBuilder("ipmitool", "-V");
        
        try {

            Process process = validate.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Ipmitool installed on system!");
                
            } 
            return exitCode;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }

    }
        
}
