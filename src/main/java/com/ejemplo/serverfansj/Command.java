package com.ejemplo.serverfansj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

    public static int validateIpmi() {

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

    public static void commandOne(Config config) {
        List<String> command = new ArrayList<>(Arrays.asList("ipmitool", "-I", "lanplus", "-H", config.getIp(), "-U", config.getUser(), "-P", config.getPassword(), "raw",
                "0x30", "0x30", "0x01", "0x00"));
        ProcessBuilder manualFans = new ProcessBuilder(command);

        try {

            Process process = manualFans.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Fans set to Manual!");

            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    
    }
    

    public static void commandTwo(Config config) {

        int speed = config.getSpeed();
        String speedHex = Integer.toHexString(speed);

        List<String> command = new ArrayList<>(Arrays.asList("ipmitool", "-I", "lanplus", "-H", config.getIp(), "-U", config.getUser(), "-P", config.getPassword(), "raw",
                "0x30", "0x30", "0x02", "0xff", speedHex));
        ProcessBuilder manualFans = new ProcessBuilder(command);

        try {

            Process process = manualFans.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Fans speed set to " + speed + "%");

            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
