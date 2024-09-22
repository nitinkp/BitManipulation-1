import java.util.Arrays;

public class SingleNumber3 {
    public static int[] singleNumber3(int[] nums) { //O(n) T.C, O(1) S.C
        //Intuition is same as singleNumber1 to find the XOR value of all nums
        int bitmask = 0;
        for(int num : nums) { //O(n)
            bitmask ^= num;
        }

        //but the above XOR (bitmask) is combination of two single digits.
        //Hence, find the least significant bit by doing '&' bw the bitmask and its 2s complement (-bitmask)
        int diff = bitmask & (-bitmask);

        int x = 0;
        for(int num : nums) { //O(n)
            //Now if the '&' bw the LSB and each num in input is not 0, then it could potentially be one of the singles
            if((diff & num) != 0) x^= num; //even if non-singles are filtered, it will be nullified in the XOR operation
        }

        return new int[]{x, bitmask^x}; //One of the single is x and the other is XOR bw x and earlier bitmask
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,5,1,2,4,2};

        System.out.println("The two single numbers out of " + Arrays.toString(nums) + " is: " +
                Arrays.toString(singleNumber3(nums)));
    }
}
