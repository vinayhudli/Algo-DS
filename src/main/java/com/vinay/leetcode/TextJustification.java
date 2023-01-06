package com.vinay.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is 68th problem in leetcode
 */

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int currentLineWidth = 0 ;

        List<String> temp = new LinkedList<>();
        for (int i=0;i<words.length;i++){
            String word = words[i] ;
            if (currentLineWidth+word.length()+1<=maxWidth) {
                if (!temp.isEmpty()) {
                    String tempWord = temp.get(temp.size()-1)+" " ;
                    temp.remove(temp.size()-1);
                    temp.add(tempWord);
                    currentLineWidth++ ;
                }
                temp.add(word);
                currentLineWidth += word.length();
            }else if(currentLineWidth+word.length()<=maxWidth){
                if(!temp.isEmpty()){
                    rearrangeWords(temp, false, currentLineWidth, maxWidth);
                    result.addAll(temp);
                    printResult(temp);
                    temp.clear();
                    currentLineWidth = 0;
                }
                temp.add(word);
                currentLineWidth+=word.length();
            }else{
                rearrangeWords(temp, false, currentLineWidth, maxWidth);
                result.addAll(temp);
                printResult(temp);
                temp.clear();
                temp.add(word);
                currentLineWidth = 0;
            }

        }
        rearrangeWords(temp, true, currentLineWidth, maxWidth);
        printResult(temp);
        return null;
    }

    private void printResult(List<String> temp){
        for(String word: temp){
            System.out.print(word);
        }
        System.out.println();
    }

    private void rearrangeWords(List<String> words, boolean isLastLine, int lineWidth, int maxWidth){
        int spaceLeft = maxWidth-lineWidth ;
        if (isLastLine || words.size()==1){
            StringBuilder builder = new StringBuilder(words.get(words.size()-1));
            for (int i=0;i<spaceLeft;i++){
                builder.append(" ");
            }
            words.remove(words.size()-1);
            words.add(builder.toString());
            return;
        }
        int extraSpace = spaceLeft/(words.size()-1) ;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<extraSpace;i++)
            stringBuilder.append(" ");
        List<String> tempWords = new ArrayList<>();
        for (int i =0 ; i<words.size()-1;i++){
            tempWords.add(words.get(i)+stringBuilder.toString());
        }

        int modSpace = (maxWidth-lineWidth)%(words.size()-1) ;
        for (int i =0 ; i<modSpace;i++){
            String str = tempWords.remove(i);
            tempWords.add(i, str+" ");
        }
        words = tempWords;
    }
}
