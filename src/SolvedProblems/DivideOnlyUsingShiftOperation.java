package SolvedProblems;

class DivideOnlyUsingShiftOperation{
    public int divide(int dividendNumber, int divisorNumber) {
        long dividend = Math.abs((long) dividendNumber);
        long divisor = Math.abs((long) divisorNumber);
        long quotient = 0;
        long currentSum = 0;
        for (long i = 31; i>=0; i--) {
            System.out.println(currentSum+(divisor<<i));

            if(currentSum+(divisor<<i)<= dividend){
                currentSum+=(divisor<<i);
                quotient |= (1L <<i);

            }
        }
        long WithoutSign = quotient;
        // for checking sign of the number
        int sign ;
        int xor = dividendNumber ^ divisorNumber;

        if(xor<0) sign = -1;
        else sign= 1;

        // problem case is when -Integer.MIN_VALUE / -1 because it should be Integer.MIN_VALUE but positive integer can have only values up to (Integer.MIN_VALUE -1 ) so java will convert the whole value into a negative number.
        if(sign<0){
            return (int)(-WithoutSign);
        }
        else {
            if( WithoutSign >Integer.MAX_VALUE ) {
                return Integer.MAX_VALUE;
            }
            return (int)WithoutSign;
        }
    }
}