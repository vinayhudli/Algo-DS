package com.vinay.leetcode;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args) {


    }
    public String convert(String s, int numRows) {
        List<StringBuilder> result = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            result.add(new StringBuilder());
        }

        //because of if condition inside loop it has to be false
        boolean goingDown = false;
        int resultIndex = 0;
        for (char c:s.toCharArray()){
            result.get(resultIndex).append(c);
            if (resultIndex == numRows-1 || resultIndex == 0){
                goingDown = !goingDown;
            }
            if (goingDown){
                resultIndex ++;
                resultIndex = resultIndex==numRows?numRows-1:resultIndex;
            }else{
                resultIndex--;
                resultIndex = resultIndex<0?0:resultIndex;
            }

        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder str:result)
            ret.append(str);
        return ret.toString();
    }
}
