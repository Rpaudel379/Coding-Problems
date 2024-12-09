
public class Forty {
    public static void main(String[] args) {
        KokoEatingBanana koko = new KokoEatingBanana();
        // {
        // int[] piles = new int[] { 3, 6, 7, 11 };
        // int h = 8;

        // koko.minEatingSpeed(piles, h);
        // }

        // {
        // int[] piles = new int[] { 30, 11, 23, 4, 20 };
        // int h = 5;

        // koko.minEatingSpeed(piles, h);
        // }
        // {
        // int[] piles = new int[] { 30, 11, 23, 4, 20 };
        // int h = 6;

        // koko.minEatingSpeed(piles, h);
        // }

        // {
        // int[] piles = new int[] { 312884470 };
        // int h = 312884469;

        // koko.binarySearch(piles, h);
        // }
        {
            int[] piles = new int[] { 1000000000 };
            int h = 2;

            koko.binarySearch(piles, h);
        }
    }
}

class KokoEatingBanana {

    // binary search
    // T - O(log(max(n)) * n)
    // greatest of piles * length of piles
    public int binarySearch(int[] piles, int h) {

        int max = 0;
        for (int i : piles) {
            max = Math.max(max, i);
        }

        int l = 1, r = max;
        int minK = r;

        while (l <= r) {
            int hours = 0;

            int midK = (l + r) / 2;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / midK);
            }

            if (hours <= h) {
                System.out.println(hours);
                minK = Math.min(minK, midK);
                r = midK - 1;
            } else {
                l = midK + 1;
            }

        }
        System.out.println(minK);
        return minK;
    }

    // brute force
    // T - O(max(n) * n)
    // greatest of piles * length of piles
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (int i : piles) {
            max = Math.max(max, i);
        }

        for (int i = 1; i <= max; i++) {

            int hour = 0;

            for (int j = 0; j < piles.length; j++) {

                int pile = piles[j];

                hour += Math.ceil((float) pile / i);

            }
            if (hour == h) {
                System.out.println(i);
                return i;
            }
        }

        return 1;
    }

}