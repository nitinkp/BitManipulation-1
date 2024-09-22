public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) { //O(1) T.C, O(1) S.C
        long c = 0;
        long sign = 1;
        if (divisor == 1) return dividend;
        if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0)) sign = -1;
        long dd = Math.abs((long) dividend);
        long dr = Math.abs((long) divisor);
        for (int i = 30; i >= 0; i--) {
            if (dd >= (dr << i)) {
                c += (1L << i);
                dd -= (dr << i);
            }
        }
        return (int) (c * sign);
    }

    public static void main(String[] args) {
        int dividend = 708780;
        int divisor = 78;

        System.out.println("The quotient when " + dividend + " is divided by " + divisor +
                " is: " + divide(dividend, divisor));
    }
}
