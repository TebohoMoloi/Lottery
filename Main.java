package com.company;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final int range = 50;
    private static final int length = 6;
    public static void main(String[] args) {
        Scanner input_name = new Scanner(System.in);
        System.out.print("Hi there, Please enter your name: ");
        String user_name = input_name.next();
        System.out.println("\033[0;1mHi "+ user_name+", Welcome to Orion lottery\033[0m\n");
        System.out.println("Here is your choice of numbers:       "+user());
        System.out.println("Here is the machine's random numbers: "+machine(range, length));
        

    }
    public static String machine(int range, int length){
        if (range > length){
            int[] numbers = new int[length];
            for (int i = 0; i < numbers.length; i++){
                int remainder = range - i;
                int newRandSpot = (int) (Math.random()*remainder);
                newRandSpot++;
                for (int t = 1; t < range+1; t++){
                    boolean taken = false;
                    for (int number : numbers){
                        if (t==number){
                            taken = true;
                            break;
                        }
                    }
                    if (!taken){
                        newRandSpot--;
                        if (newRandSpot==0){
                            numbers[i] = t;
                        }
                    }
                }
            }
            Arrays.sort(numbers);
            return Arrays.toString(numbers);
        }else {
            System.out.println("Invalid array length!\n");
        }
        return null;
    }
    public static String user(){
        Scanner input = new Scanner(System.in);
        System.out.println("\033[0;1m Please enter six numbers of your choice\033[0m : ");
        int[] numbers = new int[6];
        for (int i = 0; i < numbers.length; i++){
            System.out.print(i+1+". ");
            numbers[i] = input.nextInt();
        }
        Arrays.sort(numbers);
        return Arrays.toString(numbers);
    }
}
