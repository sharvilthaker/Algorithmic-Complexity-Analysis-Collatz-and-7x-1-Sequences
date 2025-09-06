/*
 * Name: Sharvil Thaker
 * ID: B00937903
 * Assignment 2

*Divide by 2 if n is even. Multiply by 7 and add 1 if n is odd
and n% 4 == 1. Multiply by 7 and subtract 1 if n is odd and n% 4 == 3.
Until the user enters 0 to end the program, the software calculates
the longest sequence for numbers up to a given n, measures the
execution time, and repeats the procedure.*/
import java.util.*;

public class CousinOfCollatz {

    public static long cousinLength(long n){
        long length = 1;
        while(n != 1){


            if (n % 2 == 0){
                n = n / 2;
            }
            else if (n % 4 == 1){
                n = 7*n + 1;
            }


            else{
                n = 7*n - 1;
            }
            length++;
        }
        return length;}


    public static long[] longestCousin(long n){
        long maxL = 0;
        long maxN = 0;
        for (long i = 1; i <= n; i++){
            long length = cousinLength(i);
            if(length > maxL){
                maxL = length;
                maxN = i;
            }
        }
        /*The return statement logic is taken from Chatgpt

        *The code was failing when the long number was entered
        so to fix it I have taken this statement from https://chatgpt.com/

        *return the number with the longest sequence, length.*/
        return new long[]{ maxN, maxL};
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter");
            String insert = in.nextLine();
            String[] integer = insert.split("\\s+");
            for(String num: integer ){
                long n = Long.parseLong(num);
                if(n ==0){
                    System.exit(0);
                }
                long startTime = System.currentTimeMillis();
                long[] number = longestCousin(n);
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                System.out.printf("%d %d %d%n", number[0], number[1], executionTime);
            }
        }
    }
}
