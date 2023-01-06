package com.vinay.leetcode.string;

public class AdditiveNumber {

    public static void main(String[] args) {
        AdditiveNumber additiveNumber = new AdditiveNumber();
        System.out.println(additiveNumber.isAdditiveNumber("100111"));
    }

    public boolean isAdditiveNumber(String num) {
        StringBuilder first = new StringBuilder();
        char[] chars = num.toCharArray();
        for (int i=0;i<num.length()/2;i++){
            first.append(chars[i]);
            if (first.charAt(0) == '0' && first.length()>1)
                break;
            StringBuilder second = new StringBuilder();
            for (int j=i+1;j<num.length();j++){
                second.append(chars[j]);
                int subStringLength = num.length()-j-1;
                if (second.charAt(0) == '0' && second.length()>1 ||
                        (subStringLength < first.length() || subStringLength < second.length()))
                    break;
                String substring = num.substring(j + 1);
                boolean b = recursiveAddition(substring, first.toString(), second.toString());
                if (b)
                    return true;
            }
        }
        return false;
    }

    private boolean recursiveAddition(String remNum, String first, String second){
        int maxLength = Math.max(first.length(), second.length());
        if (remNum.length()<maxLength)
            return false;
        String add2Nos = add2Nos(first, second);
        if (!remNum.startsWith(add2Nos))
            return false;
        if (remNum.length()>add2Nos.length())
            return recursiveAddition(remNum.substring(add2Nos.length()), second, add2Nos);

        return true;
    }

    private String add2Nos(String first, String second){
        StringBuilder stringBuilder = new StringBuilder();
        int maxLength = Math.max(first.length(), second.length());
        int carry = 0;
        int firstLength = first.length()-1;
        int secondLength = second.length()-1;
        for (int i=0;i<maxLength;i++){
            int sum = carry;
            if (i<first.length()){
                sum += Integer.parseInt(first.substring(firstLength-i, firstLength-i+1));
            }
            if (i<second.length()){
                sum += Integer.parseInt(second.substring(secondLength-i, secondLength-i+1));
            }
            carry = sum/10;
            sum = sum%10 ;
            stringBuilder.insert(0, sum);
        }
        if (carry!=0)
            stringBuilder.insert(0,carry);

        return stringBuilder.toString();
    }
}
