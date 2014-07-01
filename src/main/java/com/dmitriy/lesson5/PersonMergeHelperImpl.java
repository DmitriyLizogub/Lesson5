package com.dmitriy.lesson5;

import java.util.Arrays;

/**
 * Created by dmitriy on 7/1/14.
 */
public class PersonMergeHelperImpl implements PersonMargeHelper {

    @Override
    public Person[] merge(Person[] firstArray, Person[] secondArray){

        int resultLength = firstArray.length + secondArray.length;
        Person[] resultArray = Arrays.copyOf(firstArray,resultLength);

        for(int i = firstArray.length; i<resultArray.length; i++){
            resultArray[i] = secondArray[i-firstArray.length];
        }

        try {
            Arrays.sort(resultArray);
        } catch (ClassCastException e){
            e.printStackTrace();
        }

        for (int k = 0; k < resultArray.length-1; k++) {  //TODO - fix dups
            if (resultArray[k].equals(resultArray[k + 1])) {
                resultArray[k] = null;
            }
        }

        return resultArray;
    }
}
