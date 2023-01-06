package com.vinay.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseInteger {
    public static void main(String[] args) {
        byte b = 9;
//        System.out.println(b);
        ReverseInteger reverseInteger = new ReverseInteger();
//        System.out.println(reverseInteger.reverse(-214));
//        int test = (int) Math.pow(2,31) -1;
//        System.out.println(test);
        System.out.println(reverseInteger.reverse(0));
    }

    public int reverse(int x) {
        if (x == 0)
            return x;
        int result = 0;
        boolean isNegative = x < 0;
        int maxPositive = (int) (Math.pow(2, 31) -1);
        int minNegative = (int) Math.pow(2,31) *-1;

        while (x!=0){
            int mod = x % 10;
            if (isNegative){
                if (result < minNegative/10 ||
                        (result == minNegative/10 && mod < -7)){
                    return 0;
                }
            }else {
                if (result > maxPositive/10 ||
                        (result == maxPositive/10 && mod > 6)){
                    return 0;
                }
            }

            result = result*10 + mod;
            x /= 10;

        }
        return result;
    }

    public int reverseUsingByteArray(int x) {
        List<Byte> byteList = new ArrayList<>();
        if (x == 0)
            return 0;
        else if (x < 0)
            byteList = numberToByteArray(x*-1, true);
        else
            byteList = numberToByteArray(x, true);
        List<Byte> maxNum = numberToByteArray((int) (Math.pow(2, 31) - 1), false);
        if (!isAboveRange(maxNum, byteList, x<0)){
            StringBuilder str = new StringBuilder();
            byteList.forEach(entry->str.append(entry));
            int result = Integer.valueOf(str.toString()) ;
            if (x<0)
                result *= -1;
            return result;
        }
        return 0;
    }

    private List<Byte> numberToByteArray(int x, boolean append) {
        List<Byte> result = new LinkedList<>();
        if (append){
            while (x != 0) {
                byte mod = (byte) (x % 10);
                if (mod < 0)
                    mod *= -1 ;
                result.add(mod);
                x = x / 10;
            }
        }else{
            while (x != 0) {
                byte mod = (byte) (x % 10);
//                result.add(mod);
                result.add(0, mod);
                x = x / 10;
            }
        }

        return result;
    }

    private boolean isAboveRange(List<Byte> maxPositive, List<Byte> oparative, boolean isNegative){
        if (oparative.size() > maxPositive.size())
            return true;

        int diff = maxPositive.size()-oparative.size();
        if (diff > 0)
            return false;

        for (int i=0;i< maxPositive.size();i++){
            if (i == maxPositive.size()-1){
                if (isNegative){
                    return maxPositive.get(i)+1 < oparative.get(i) ;
                }else{
                    return maxPositive.get(i) < oparative.get(i) ;
                }
            }

              if(maxPositive.get(i)< oparative.get(i))
                return true;
              else if (maxPositive.get(i)> oparative.get(i))
                  return false;

        }

        return false;
    }

}
