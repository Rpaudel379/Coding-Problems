import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TwentyFive {
    public static void main(String[] args) {
        TopKFrequentElements topk = new TopKFrequentElements();

        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };

        topk.usingBucket(nums, 3);
    }
}

class TopKFrequentElements {

    public int[] usingBucket(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> freq = new ArrayList<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i <= nums.length; i++) {
            freq.add(new ArrayList<>());
        }

        map.forEach((n, v) -> {
            freq.get(v).add(n);
        });

        int[] out = new int[k];
        int outLen = 0;

        for (int i = freq.size() - 1; i >= 0; i--) {

            for (int j : freq.get(i)) {
                out[outLen] = j;
                outLen++;

                if (outLen == k) {
                    return out;
                }
            }

        }

        return null;
    }
}


//   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//         ArrayList<ArrayList<Integer>> freq = new ArrayList<>();

//         for (int i = 0; i <= nums.length; i++){
//             freq.add(new ArrayList<>());
//         }
        
//         System.out.println(freq);


//         for (int i : nums){
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }

//         // Arrays.toString(map.keySet().toArray());

//         System.out.println(map.entrySet());
     
//         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//             int n = entry.getKey();
//             int c = entry.getValue();
//             freq.get(c).add(n);
//         }
//         System.out.println(freq);

//     //   map.forEach((number, count) -> {
//       //      freq.get(count).add(number);
//        // System.out.println(freq);
//       //  });

//         int res[] = new int [k];
//         int resLen = 0;
//        for(int i = freq.size() - 1; i >= 0; i--){
//            for(int j : freq.get(i)){
            

//                res[resLen] = j;
//                resLen++;

//                if (resLen == k){
//                    return res;
//                }
//            }
//        }


//         return null;