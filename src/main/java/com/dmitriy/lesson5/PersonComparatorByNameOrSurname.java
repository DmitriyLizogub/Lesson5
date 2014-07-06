package com.dmitriy.lesson5;

import java.util.Comparator;

/**
 * Created by dmitriy on 7/6/14.
 */
public class PersonComparatorByNameOrSurname implements Comparator<Person>{

   @Override
    public int compare(Person person1, Person person2){

       if (person1 != null && person2 != null){
           String personName1 = person1.getName().toUpperCase();
           String personName2 = person2.getName().toUpperCase();
           String personSurName1 = person2.getSurName().toUpperCase();
           String personSurName2 = person2.getSurName().toUpperCase();

           if (!personName2.equals(personName1)){
           //ascending order
           return personName2.compareTo(personName1);}
           else return personSurName2.compareTo(personSurName1);
       } else return -1;
   }
}

