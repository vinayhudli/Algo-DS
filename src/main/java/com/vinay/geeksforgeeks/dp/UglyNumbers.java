package com.vinay.geeksforgeeks.dp;

/**
 * Ugly numbers are numbers whose only prime factors are 2,3 or 5
 */
public class UglyNumbers {

    public int[] getUglyNumbers(int count){
        int[] result = new int[count] ;
        result[0] = 1 ;
        int index_to_multiply_by2 =0, index_to_multiply_by3 = 0, index_to_multiply_by5  = 0;

        for (int i=1;i<count;i++){
            int low = Math.min(result[index_to_multiply_by2]*2, result[index_to_multiply_by3]*3) ;
            low = Math.min(low, result[index_to_multiply_by5]*5) ;
            if (low % 2 ==0)
                index_to_multiply_by2++;
            if (low % 3 == 0)
                index_to_multiply_by3++;
            if (low%5==0)
                index_to_multiply_by5++;

            result[i] = low;
        }
        return result;
    }

    public static void main(String[] args) {
        UglyNumbers uglyNumbers = new UglyNumbers();
        int[] result = uglyNumbers.getUglyNumbers(10);
        for (int i=0;i<result.length;i++)
            System.out.println(result[i]);

    }

}
