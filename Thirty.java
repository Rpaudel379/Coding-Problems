public class Thirty {
    public static void main(String[] args) {
        ProductArray p = new ProductArray();

        // int[] nums = new int[] { 1, 2, 3, 4 };
        // int[] nums = new int[] { -1, 1, 0, -3, 3 };
        int[] nums = new int[] { 2, 3, 4, 5 };

        // 1 2 6 24
        // 60 40 30 24
        // 60 20 5  1
        p.productExceptSelf(nums);
    }
}

class ProductArray {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] out = new int[length];
        out[0] = 1;

        for (int i = 1; i < length; i++) {
            
            out[i] = out[i - 1] * nums[i - 1];
        }

        for (int i : out) {
            System.out.print(i + " ");
        }
        int product = 1;
        for (int i = length - 1; i >= 0; i--) {
            out[i] = out[i] * product;
            product *= nums[i];
        }

        return out;
    }

}