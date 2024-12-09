public class FortyFive {
    public static void main(String[] args) {

        MinimumNumberOfExercises exercise = new MinimumNumberOfExercises();

        // {
        // int energy = 6;
        // int[] exercises = new int[] { 1, 2 };
        // int out = exercise.minimum(energy, exercises.length, exercises);
        // System.out.println(out);
        // }

        {
            int energy = 10;
            int[] exercises = new int[] { 1, 2 };
            int out = exercise.minimum2(energy, exercises.length, exercises);
            System.out.println(out);
        }
        {
            int energy = 6;
            int[] exercises = new int[] { 1, 2, 4, 3 };
            int out = exercise.minimum2(energy, exercises.length, exercises);
            System.out.println(out);
        }

    }
}

class MinimumNumberOfExercises {

    public int minimum2(int energy, int n, int[] exercises) {

        int totalEnergy = 0;
        for (int exercise : exercises) {
            totalEnergy += 2 * exercise;
        }

        // guarente that any exerices wont make it tired
        if (totalEnergy < energy) {
            return -1;
        }
        
        


        return -1;
    }

    public int minimum(int energy, int n, int[] exercises) {

        for (int exercise : exercises) {
            if (exercise == energy) {
                return 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += exercises[i];

            if (sum >= energy) {
                return (i + 1);
            }
        }

        sum = 0;

        for (int i = 0; i < n; i++) {
            sum += 2 * exercises[i];
            if (sum >= energy) {
                return 2 * (i + 1);
            }
        }

        return -1;
    }
}

// Problem Statement :

// Today you decided to go to the gym. You currently have energy equal to E
// units. There are N exercises in the gym. Each of these exercises drains Ai
// amount of energy from your body.

// You feel tired if your energy reaches 0 or below. Calculate the minimum
// number of exercises you have to perform such that you become tired. Every
// unique exercise can only be performed at most 2 times as others also have to
// use the machines.

// If performing all the exercises does not make you feel tired, return -1.

// Input Format
// E :: INTEGER
// The first line contains an integer, E, denoting the Energy.
// E :: 1 -> 10^5

// N :: INTEGER
// The next line contains an integer, N, denoting the number of exercises. N ::
// 1 -> 10^5

// A :: INTEGER ARRAY
// Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer
// describing the amount of energy drained by i-th exercise.
// A[i] :: 1 -> 10^5

// Test Cases
// Case#: 1
// Input:
// 6
// 2
// 1
// 2
// Output:
// 4
// E = 6
// Do 1st exercise 2 times
// Do 2nd exercise 2 times
// Hence, total exercises done 4.

// Case#: 2
// Input:
// 10
// 2
// 1
// 2
// Output:
// -1
// E = 10
// By doing both the exercises 2 times, you won't feel tired.
// Case#: 3
// Input:
// 2
// 3
// 1
// 5
// 2
// Output:
// 1
// E = 2
// Use 3rd exercise 1 time.
// Hence, total exercise done 1.