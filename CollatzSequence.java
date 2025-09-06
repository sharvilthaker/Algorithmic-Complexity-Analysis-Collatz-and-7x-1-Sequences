/*
* Name: Sharvil Thaker
* ID: B00937903
* Assignment 2
* For a given positive integer n, this class constructs and determines
the length of the Collatz sequence. For numbers up to a certain n,
it can also determine which number generates the longest Collatz
sequence. Also how long it will take to execute the longest sequence
andthe option to enter numbers continuously until the user
types in0, at which point the application will end.*/

import java.util.*;

public class CollatzSequence {

/*Using a given integer n, this method finds the length of the Collatz sequence.
Like divide n by two if it is even.  Add one and multiply n by three if it's odd.
Continue until n equals 1.*/
    public static long collatzLength(long n){
        long length =1;
        while(n != 1){
            if(n % 2 == 0){
                n = n/ 2;
            }
            else{
                n = 3 * n + 1;
            }
            length++;
        }
        return length;
    }

    /*Using method, the longest Collatz sequence is produced by n ≤ n.
    It iterates over all integers between 1 and n, picking the length
    of each number's Collatz sequence and recording which number has the longest sequence.*/
    public static long[] longestCollatz(long n){
        long max = 0;
        long maxNumber = 0;
        for (long i = 1; i <= n; i++){
            long length = collatzLength(i);
            if(length > max){
                max = length;
                maxNumber = i;
            }
        }
        return new long [] {maxNumber, max};
        }

/*The understanding of thr whole main methods logic was completed by the help of Chatgpt
https://chatgpt.com/
I have tried using if else instead of for but I was getting error so to upgrade the logic
and run it i have taken help from chatgpt for the code from line 51 to 63

*The number ≤ n that generates the longest Collatz sequence is found using this method.
It estimates the length of each number's Collatz sequence* as it loops over all
numbers from 1 to n, recording which number has the longest sequence.*/
    public static void main (String[] args){
        Scanner in = new Scanner (System.in);

        while (true){
            System.out.println("Enter");
            String insert = in.nextLine();
            String[] integer = insert.split("\\s+");

            for(String num : integer){
                long n = Long.parseLong(num);
                if(n == 0){
                    System.exit(0);
                }
                long startTime = System.currentTimeMillis();
                long[] number = longestCollatz(n);
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                System.out.printf("%d %d %d %d%n", n, number[0], number[1], executionTime);
            }
        }
    }
}
