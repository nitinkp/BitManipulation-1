import java.util.Arrays;

public class SingleNumber {
    public static int singleNumber(int[] nums) { //O(n) T.C, O(1) S.C
        int result = 0;
        for(int num : nums) {
            //Intuition is that XOR between same numbers is 1, so whatever is left will be the result
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,3,4,2,5,1};

        System.out.println("The single number from " + Arrays.toString(nums) + " is: " +
                singleNumber(nums));
    }
}