// You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.

// Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.

public class TwentySix {
    public static void main(String[] args) {
        Kth kth = new Kth();

        kth.kthFactor(12, 4);
        kth.SqrtkthFactor(12, 2);
    }
}

class Kth {

    // O(sqrt N) - time
    // O(1) - space
    
    public int SqrtkthFactor(int n, int k) {

        for (int i = 1; i < Math.sqrt(n); i++) {
            if ((n % i == 0) && --k == 0) {
                System.out.println(i);
                return i;
            }
        }

        for (int i = (int) Math.sqrt(n); i >= 1; --i) {
            if ((n % (n / i) == 0) && --k == 0) {
                System.out.println(n / i);
                return n / i;
            }
        }

        return -1;
    }

    public int kthFactor(int n, int k) {

        int j = 0;

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                j++;

                if (j == k) {
                    System.out.println(i);
                    return i;
                }
            }

        }

        return -1;
    }
}