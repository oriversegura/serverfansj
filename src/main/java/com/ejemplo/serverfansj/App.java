package com.ejemplo.serverfansj;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class App 
{
    public static void main( String[] args )
    {
        if(args.length == 0){
            System.err.println("Error: no route to config file.");
            return;
        } 

        String configPath = args[0];

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            Config config = objectMapper.readValue(new File(configPath), Config.class);
            
            System.out.println("Config sucesfull loaded!");
        } catch (IOException e) {
            System.err.println("Error in read config file: " + e.getMessage());
            e.printStackTrace();
        }       

        Command.validateIpmi();

    }
}
