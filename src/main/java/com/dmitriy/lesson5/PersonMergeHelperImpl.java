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

            Arrays.sort(resultArray, Person.PersonComparator);


        setDuplicatesInArrayToNull(resultArray);

        int resultArrayLength = resultArray.length - countNullInArray(resultArray);
        Person [] rezArray = new Person[resultArrayLength];

        for (int d = 0; d < resultArray.length; d++){ //TODO
            if (resultArray[d] != null) {
                    rezArray[d] = resultArray[d];

            }
        }

        return rezArray;
    }


    private Person[] setDuplicatesInArrayToNull(Person[] resultArray) {
        for (int k = 0; k < resultArray.length-1; k++) {
                if (resultArray[k].equals(resultArray[k+1])) {
                    resultArray[k] = null;
                }
        }
        return resultArray;
    }


    private int countNullInArray(Person[] resultArray) {
        int nullCounter = 0;
        for (int z = 0; z < resultArray.length; z++){
            if (resultArray[z] == null){
                nullCounter++;
            }
        }
        return nullCounter;
    }
}
