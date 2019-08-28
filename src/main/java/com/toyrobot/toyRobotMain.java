package com.toyrobot;

import java.util.Scanner;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.helper.Robot;
import com.toyrobot.helper.SquareTableTop;

public class toyRobotMain {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        SquareTableTop squareTableTop = new SquareTableTop(5,5);
        Robot robot = new Robot();
        Console console = new Console(squareTableTop, robot);

        System.out.println("*** Toy Robot Console ***\n");
        System.out.println("Enter below command\n");

        System.out.println("\'PLACE X,Y,EAST|WEST|NORTH|SOUTH\'\n");
        System.out.println(" (X) - x co-ordinate on the square table top (0-5)");
        System.out.println(" (Y) - y co-ordinate on the square table top (0-5)");
        System.out.println(" EAST|WEST|NORTH|SOUTH - Select any one direction for the toy robot to start with");
        System.out.println(" MOVE|LEFT|RIGHT - use these commands to move and change directions ");
        System.out.println(" REPORT - use this command to display current postion and direction ");
        System.out.println(" EXIT - use this to stop the application ");

        boolean applicationRunning = true;
        while (applicationRunning) {
            String userInput = keyboard.nextLine();
            if ("EXIT".equals(userInput)) {
                keyboard.close();
                applicationRunning = false;
                System.out.println("You are now out of the application...");
            } else {
                try {
                    String outputMessage = console.process(userInput);
                    if(!outputMessage.equals("true")){
                        System.out.println(outputMessage);
                    }

                } catch (ToyRobotException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

}

